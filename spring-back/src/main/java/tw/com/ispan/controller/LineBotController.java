package tw.com.ispan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.linecorp.bot.model.event.MessageEvent;
import com.linecorp.bot.model.event.message.TextMessageContent;
import com.linecorp.bot.model.message.TextMessage;
import com.linecorp.bot.spring.boot.annotation.EventMapping;
import com.linecorp.bot.spring.boot.annotation.LineMessageHandler;
import tw.com.ispan.service.DialogflowService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@CrossOrigin
@LineMessageHandler
@RestController
public class LineBotController {

    private static final Logger logger = LoggerFactory.getLogger(LineBotController.class);

    @Autowired
    private DialogflowService dialogflowService;

    // 處理來自 LINE Bot 的文字消息
    @EventMapping
    public TextMessage handleTextMessageEvent(MessageEvent<TextMessageContent> event) {
        try {
            // 取得用戶的文字消息
            String userMessage = event.getMessage().getText();
            // 使用 LINE User ID 作為 sessionId
            String sessionId = event.getSource().getUserId();

            // 調用 Dialogflow API 獲取回應
            String responseText = dialogflowService.getDialogflowResponse(sessionId, userMessage);

            // 返回 Dialogflow 的回應給用戶
            return new TextMessage(responseText);

        } catch (Exception e) {
            // 捕獲所有異常，記錄日誌
            logger.error("Error processing message event", e);

            // 返回一個靜態的錯誤消息作為 LINE 的回應，並確保返回 200 狀態碼
            return new TextMessage("抱歉，目前無法處理您的請求。");
        }
    }

    // 確保返回 200 狀態碼，即使是處理其他未映射的 HTTP POST 請求
    @PostMapping("/webhook")
    public ResponseEntity<String> handleWebhook() {
        logger.info("Webhook endpoint hit");
        return ResponseEntity.ok("Webhook received successfully!");
    }
}
