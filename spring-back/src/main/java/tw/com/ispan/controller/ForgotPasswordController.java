package tw.com.ispan.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tw.com.ispan.service.MemberService;

@CrossOrigin
@RestController
public class ForgotPasswordController {

    @Autowired
    private MemberService memberService;

    // 發送驗證碼
    @PostMapping("/api/forgot-password/send-code")
    public Map<String, Object> sendVerificationCode(@RequestBody Map<String, String> request) {
        String email = request.get("email");
        boolean success = memberService.sendResetPasswordCode(email);
        return Map.of("success", success);
    }

    // 重設密碼
    @PostMapping("/api/forgot-password/reset-password")
    public Map<String, Object> resetPassword(@RequestBody Map<String, String> request) {
        String email = request.get("email");
        String code = request.get("code");
        String newPassword = request.get("newPassword");
        boolean success = memberService.resetPassword(email, code, newPassword);
        return Map.of("success", success);
    }
}
