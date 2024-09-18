package tw.com.ispan.controller;

import java.util.Map;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.com.ispan.domain.Members;
import tw.com.ispan.service.MemberService;
import tw.com.ispan.util.JsonWebTokenUtility;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/ajax/secure")
@CrossOrigin
public class LoginAjaxController {

    @Autowired
    private MemberService memberService;

    @Autowired
    private JsonWebTokenUtility jsonWebTokenUtility;

    // Google 登錄的 API
    @PostMapping("/google-login")
    public String googleLogin(@RequestBody Map<String, String> tokenMap) {
        String idTokenString = tokenMap.get("token");

        // 调用 service 层来处理 Google 登录逻辑
        JSONObject responseJson = memberService.googleLogin(idTokenString);

        // 返回 JSON 响应
        System.out.println("Response JSON: " + responseJson.toString());  // 打印完整响应
        return responseJson.toString();
    }


    // 一般登錄邏輯
    @PostMapping("/login")
    public String login(@RequestBody String json) {
        JSONObject responseJson = new JSONObject();

        // 接收資料
        JSONObject obj = new JSONObject(json);
        String username = obj.isNull("username") ? null : obj.getString("username");
        String password = obj.isNull("password") ? null : obj.getString("password");

        // 驗證資料
        if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
            responseJson.put("success", false);
            responseJson.put("message", "請輸入帳號/密碼以便執行登入");
            return responseJson.toString();
        }

        // 呼叫業務邏輯
        Members member = memberService.login(username, password);
        if (member == null) {
            responseJson.put("success", false);
            responseJson.put("message", "登入失敗");
        } else {
            responseJson.put("success", true);
            responseJson.put("message", "登入成功");
            // JWT 建立並返回給前端
            String date = new JSONObject().put("date", member.getRegistrationDate()).toString();
            JSONObject user = new JSONObject()
                .put("membername", member.getUsername())
                .put("realname", member.getRealName())
                .put("email", member.getEmail())
                .put("date", date);
           
            
            String token = jsonWebTokenUtility.createEncryptedToken(user.toString(), null);
            responseJson.put("token", token);
            responseJson.put("realname", member.getRealName());
            responseJson.put("membersId", member.getMembersId());
        }

        return responseJson.toString();
    }

    // 註冊邏輯
    @PostMapping("/register")
    public String register(@RequestBody String json) {
        JSONObject responseJson = new JSONObject();

        // 接收註冊資料
        JSONObject obj = new JSONObject(json);
        String username = obj.optString("username", null);
        String password = obj.optString("password", null);
        String realName = obj.optString("realName", null);
        String email = obj.optString("email", null);
        String phone = obj.optString("phone", null);
        String address = obj.optString("address", null);

        // 驗證資料
        if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
            responseJson.put("success", false);
            responseJson.put("message", "用戶名和密碼為必填項");
            return responseJson.toString();
        }

        try {
            // 呼叫業務邏輯進行註冊
            Members newMember = memberService.registerMember(username, password, realName, email, phone, address);
            responseJson.put("success", true);
            responseJson.put("message", "註冊成功");
        } catch (IllegalArgumentException e) {
            responseJson.put("success", false);
            responseJson.put("message", e.getMessage());
        } catch (Exception e) {
            responseJson.put("success", false);
            responseJson.put("message", "註冊失敗");
        }

        return responseJson.toString();
    }

    // 登出邏輯
    @PostMapping("/logout")
    public String logout(HttpServletRequest request) {
        JSONObject responseJson = new JSONObject();

        // 使會話失效
        request.getSession().invalidate();

        responseJson.put("success", true);
        responseJson.put("message", "登出成功");

        return responseJson.toString();
    }
}
