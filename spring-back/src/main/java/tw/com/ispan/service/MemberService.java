package tw.com.ispan.service;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.gson.GsonFactory;

import tw.com.ispan.domain.Members;
import tw.com.ispan.repository.MembersRepository;
import tw.com.ispan.util.DatetimeConverter;
import tw.com.ispan.util.JsonWebTokenUtility;

@Service
@Transactional
public class MemberService {

	@Autowired
	private MembersRepository membersRepository;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Autowired
	private JsonWebTokenUtility jsonWebTokenUtility;

	@Autowired
	private StringRedisTemplate redisTemplate; // 用於 Redis 操作
	
	@Autowired
	private EmailService emailService;

	// 普通登入邏輯
	public Members login(String username, String password) {
		Optional<Members> optional = membersRepository.findByUsername(username);
		if (optional.isPresent()) {
			Members member = optional.get();
			String storedPassword = new String(member.getPassword());

			if (passwordEncoder.matches(password, storedPassword)) {
				return member;
			} else {
				System.out.println("密碼不匹配");
			}
		}
		return null;
	}

	// Google 登錄和黑名單檢查邏輯
	public JSONObject googleLogin(String idTokenString) {
	    JSONObject responseJson = new JSONObject();

	    // 验证 Google Token
	    GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier.Builder(new NetHttpTransport(),
	            GsonFactory.getDefaultInstance())
	            .setAudience(Collections
	                    .singletonList("817520602073-7t549n8e39okn7hg67oql84u71kp0e5t.apps.googleusercontent.com")) // 替换为你的 Google 客户端 ID
	            .build();

	    try {
	        GoogleIdToken idToken = verifier.verify(idTokenString);
	        if (idToken != null) {
	            GoogleIdToken.Payload payload = idToken.getPayload();
	            String email = payload.getEmail();
	            String name = (String) payload.get("name");

	            // 查找用户是否已经存在
	            Members member = membersRepository.findByEmail(email).orElse(null);
	            if (member == null) {
	                // 如果用户不存在，注册新用户
	                member = registerMember(email, null, name, email, null, null);
	            }

	            // 黑名單檢查邏輯
	            if (member.isBlacklisted()) {
	                responseJson.put("success", true);
	                responseJson.put("blacklisted", true);
	                responseJson.put("message", "您已被列入黑名單，請等待自動登出");
	                return responseJson;
	            }

	            // 生成 JWT 并返回
	            String date = DatetimeConverter.toString(member.getRegistrationDate(), "yyyy-MM-dd");
	            JSONObject user = new JSONObject().put("membername", member.getUsername())
	                    .put("realname", member.getRealName()) // 填充 realname
	                    .put("email", member.getEmail()).put("date", date);
	            String token = jsonWebTokenUtility.createEncryptedToken(user.toString(), null);

	            // 構建返回 JSON
	            responseJson.put("success", true);
	            responseJson.put("token", token);
	            responseJson.put("realname", member.getRealName()); // 返回 realname
	            responseJson.put("membersId", member.getMembersId());
	            responseJson.put("blacklisted", false); // 用户未被列入黑名单
	            return responseJson;

	        } else {
	            responseJson.put("success", false);
	            responseJson.put("message", "無效的 Google 登錄");
	            return responseJson;
	        }
	    } catch (Exception e) {
	        responseJson.put("success", false);
	        responseJson.put("message", "Google 驗證失敗");
	        return responseJson;
	    }
	}



	
	
	
	

	// 一般註冊邏輯
	public Members registerMember(String username, String password, String realName, String email, String phone,
			String address) {

		System.out.println("Received realName: " + realName);
		if (membersRepository.findByUsername(username).isPresent()) {
			throw new IllegalArgumentException("用戶名已存在");
		}

		if (membersRepository.findByEmail(email).isPresent()) {
			throw new IllegalArgumentException("Email 已被使用");
		}

		Members member = new Members();
		member.setUsername(username);

		// 如果是 Google 登錄，則生成一個隨機密碼
		if (password == null || password.isEmpty()) {
			password = generateRandomPassword();
		}

		String encodedPassword = passwordEncoder.encode(password);
		member.setPassword(encodedPassword.getBytes());

		// 如果 realName 為空，則使用 username 作為後備值
		if (realName == null || realName.isEmpty()) {
			realName = username; // 或者你可以選擇其他適當的替代值
		}
		member.setRealName(realName);

		member.setEmail(email);
		member.setPhone(phone);
		member.setAddress(address);

		return membersRepository.save(member);
	}

	// 隨機生成密碼的輔助方法
	private String generateRandomPassword() {
		return UUID.randomUUID().toString(); // 使用 UUID 生成隨機密碼
	}

	// 查找會員根據 email
	public Members findByEmail(String email) {
		Optional<Members> optionalMember = membersRepository.findByEmail(email);
		return optionalMember.orElse(null);
	}

	// 查找會員根據 username
	public Members getMemberByUsername(String username) {
		Optional<Members> optionalMember = membersRepository.findByUsername(username);
		return optionalMember.orElse(null);
	}

	// 更新會員信息
	public Members updateMember(Members updatedMember) {
		Optional<Members> optionalMember = membersRepository.findById(updatedMember.getMembersId());
		if (optionalMember.isPresent()) {
			Members existingMember = optionalMember.get();
			existingMember.setRealName(updatedMember.getRealName());
			existingMember.setEmail(updatedMember.getEmail());
			existingMember.setPhone(updatedMember.getPhone());
			existingMember.setAddress(updatedMember.getAddress());

			return membersRepository.save(existingMember);
		} else {
			throw new IllegalArgumentException("會員不存在");
		}
	}

	// 更新會員大頭貼
	public Members updateMemberPhoto(MultipartFile file, String username) {
		Optional<Members> optionalMember = membersRepository.findByUsername(username);
		if (optionalMember.isPresent()) {
			Members member = optionalMember.get();
			try {
				byte[] photoBytes = file.getBytes();
				member.setMemberPhoto(photoBytes);
				return membersRepository.save(member);
			} catch (IOException e) {
				throw new RuntimeException("圖片上傳失敗", e);
			}
		} else {
			throw new RuntimeException("會員不存在");
		}
	}

//	// 發送忘記密碼的驗證碼到郵箱
	public boolean sendResetPasswordCode(String email) {
		Optional<Members> memberOptional = membersRepository.findByEmail(email);
		if (memberOptional.isPresent()) {
			String verificationCode = generateVerificationCode();
			redisTemplate.opsForValue().set(email, verificationCode, 10, TimeUnit.MINUTES); // 保存驗證碼到 Redis，10 分鐘過期
			emailService.sendVerificationCode(email, verificationCode); // 發送驗證碼到用戶郵箱
			return true;
		} else {
			throw new IllegalArgumentException("Email 不存在");
		}
	}

	// 驗證驗證碼並重設密碼
	public boolean resetPassword(String email, String verificationCode, String newPassword) {
		String storedCode = redisTemplate.opsForValue().get(email);
		if (storedCode != null && storedCode.equals(verificationCode)) {
			Optional<Members> memberOptional = membersRepository.findByEmail(email);
			if (memberOptional.isPresent()) {
				Members member = memberOptional.get();
				String encodedPassword = passwordEncoder.encode(newPassword);
				member.setPassword(encodedPassword.getBytes());
				membersRepository.save(member);
				redisTemplate.delete(email); // 驗證碼已使用，從 Redis 中刪除
				return true;
			} else {
				throw new IllegalArgumentException("用戶不存在");
			}
		} else {
			throw new IllegalArgumentException("驗證碼無效或已過期");
		}
	}

	// 生成隨機的 6 位數驗證碼
	private String generateVerificationCode() {
		return String.format("%06d", new java.util.Random().nextInt(999999));
	}

	// 修改密碼
	public boolean changePassword(String username, String oldPassword, String newPassword) {
		Members member = this.login(username, oldPassword);
		if (member != null) {
			String newEncodedPassword = passwordEncoder.encode(newPassword);
			member.setPassword(newEncodedPassword.getBytes());
			membersRepository.save(member);
			return true;
		}
		return false;
	}
	
	
	
	
	// 獲取所有會員
    public List<Members> getAllMembers() {
        return membersRepository.findAll();
    }

    // 將會員加入黑名單
    public void addToBlacklist(Integer id) {
        Members member = membersRepository.findById(id).orElseThrow(() -> new RuntimeException("會員未找到"));
        member.setBlacklisted(true);
        membersRepository.save(member);
    }

    // 將會員移出黑名單
    public void removeFromBlacklist(Integer id) {
        Members member = membersRepository.findById(id).orElseThrow(() -> new RuntimeException("會員未找到"));
        member.setBlacklisted(false);
        membersRepository.save(member);
    }


    // 根據會員ID獲取會員資料
    public Members findById(Integer id) {
        return membersRepository.findById(id).orElseThrow(() -> new RuntimeException("會員未找到"));
    }
	
	
	
	
	
}
