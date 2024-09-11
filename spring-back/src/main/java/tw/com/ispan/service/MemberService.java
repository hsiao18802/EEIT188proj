package tw.com.ispan.service;

import java.util.Arrays;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.com.ispan.domain.Members;
import tw.com.ispan.repository.MembersRepository;



@Service
@Transactional
public class MemberService {

    @Autowired
    private MembersRepository membersRepository;
    
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;


//    // 使用 byte[] 進行密碼比對
//    public Members login(String username, String password) {
//        Optional<Members> optional = membersRepository.findByUsername(username);
//        if (optional.isPresent()) {
//            Members member = optional.get();
//            // 從資料庫中取出存儲的 byte[] 密碼
//            byte[] storedPassword = member.getPassword();
//            // 將使用者輸入的密碼轉換為 byte[] 進行比對
//            byte[] inputPasswordBytes = password.getBytes();
//
//            // 比較兩個 byte[] 是否相等
//            if (Arrays.equals(storedPassword, inputPasswordBytes)) {
//                return member;  // 密碼匹配，登入成功
//            } else {
//                System.out.println("密碼不匹配");
//            }
//        }
//        return null;  // 登入失敗
//    }
    
    
    public Members login(String username, String password) {
        Optional<Members> optional = membersRepository.findByUsername(username);
        if (optional.isPresent()) {
            Members member = optional.get();
            
            // 取得加密的密碼，轉換成 String
            String storedPassword = new String(member.getPassword());

            // 使用 BCrypt 進行密碼匹配
            if (passwordEncoder.matches(password, storedPassword)) {
                return member;  // 密碼匹配，登入成功
            } else {
                System.out.println("密碼不匹配");
            }
        }
        return null;  // 登入失敗
    }
    
    
    public Members registerMember(String username, String password, String realName, String email, String phone, String address) {
        // 檢查用戶名是否已存在
        if (membersRepository.findByUsername(username).isPresent()) {
            throw new IllegalArgumentException("用戶名已存在");
        }

        System.out.println("Real Name in Service: " + realName);
        
        // 創建新用戶
        Members member = new Members();
        member.setUsername(username);
        
        // 使用 BCrypt 加密密碼，直接存儲為 String
        String encodedPassword = passwordEncoder.encode(password);
        member.setPassword(encodedPassword.getBytes());  // 如果欄位類型為 byte[]，應轉換為 String

        member.setRealName(realName);
        member.setEmail(email);
        member.setPhone(phone);
        member.setAddress(address);

        // 保存新用戶
        return membersRepository.save(member);
    }

    
    
    
    

    public boolean changePassword(String username, String oldPassword, String newPassword) {
        if (username != null) {
            Members member = this.login(username, oldPassword);
            if (member != null) {
                // 使用 BCrypt 加密新密碼，直接存儲為 String
                String newEncodedPassword = passwordEncoder.encode(newPassword);
                member.setPassword(newEncodedPassword.getBytes());  // 如果欄位類型為 byte[]

                membersRepository.save(member);  // 更新資料庫
                return true;
            }
        }
        return false;
    }



	
	public Members testFindByUsername(String username) {
	    Optional<Members> optional = membersRepository.findByUsername(username);
	    return optional.orElse(null);
	}

}
