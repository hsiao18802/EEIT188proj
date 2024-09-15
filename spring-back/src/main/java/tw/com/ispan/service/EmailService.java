package tw.com.ispan.service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
	
    private final JavaMailSender mailSender;

    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    // 發送驗證碼到用戶的郵箱
    public void sendVerificationCode(String toEmail, String verificationCode) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(toEmail);
        message.setSubject("重設密碼驗證碼");
        message.setText("您的驗證碼是：" + verificationCode);
        message.setFrom("kwkw4183704@gmail.com");  // 固定發送者
        mailSender.send(message);
    }
}
