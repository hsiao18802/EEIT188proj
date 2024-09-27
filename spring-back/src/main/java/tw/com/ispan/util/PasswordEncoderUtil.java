package tw.com.ispan.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoderUtil {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        
        // 替換成你希望加密的密碼
        String rawPassword = "admin";
        
        // 加密密碼
        String encodedPassword = encoder.encode(rawPassword);
        
        // 輸出加密後的密碼
        System.out.println("加密後的密碼：" + encodedPassword);
    }
}
