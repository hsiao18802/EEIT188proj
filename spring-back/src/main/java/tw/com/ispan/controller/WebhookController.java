package tw.com.ispan.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class WebhookController {

    private static final Logger logger = LoggerFactory.getLogger(WebhookController.class);

    // 確保返回 200 狀態碼，即使是處理其他未映射的 HTTP POST 請求
    @PostMapping("/webhook")
    public ResponseEntity<String> handleWebhook() {
        logger.info("Webhook endpoint hit");
        return ResponseEntity.ok("Webhook received successfully!");
    }
}
