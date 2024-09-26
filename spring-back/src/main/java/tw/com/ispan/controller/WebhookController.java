package tw.com.ispan.controller;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tw.com.ispan.service.DialogflowService;
import tw.com.ispan.service.LineMessageService;

@CrossOrigin
@RestController
public class WebhookController {

    private static final Logger logger = LoggerFactory.getLogger(WebhookController.class);

    @Autowired
    private LineMessageService lineMessageService;

    @Autowired
    private DialogflowService dialogflowService; // 加入 DialogflowService

    // 確保返回 200 狀態碼，即使是處理其他未映射的 HTTP POST 請求
    @PostMapping("/webhook")
    public ResponseEntity<String> handleWebhook(@RequestBody String message) {
        logger.info("Webhook endpoint hit with message: {}", message);
        System.out.println("Received Webhook Message: " + message);

        try {
            // 解析 Webhook 中的 JSON 字串
            JSONObject jsonMessage = new JSONObject(message);

            // 確認 "events" 是否存在並且是非空的 JSONArray
            if (jsonMessage.has("events") && jsonMessage.getJSONArray("events").length() > 0) {
                JSONArray events = jsonMessage.getJSONArray("events");

                // 提取用戶 ID 和訊息內容
                String userId = events.getJSONObject(0).getJSONObject("source").getString("userId");
                String userMessage = events.getJSONObject(0).getJSONObject("message").getString("text");

                // 使用 Dialogflow 來處理用戶的訊息
                String dialogflowResponse = dialogflowService.getDialogflowResponse(userId, userMessage);

                // 使用 LineMessageService 推送 Dialogflow 的回應訊息
                lineMessageService.pushMessage(userId, dialogflowResponse);
                
                return ResponseEntity.ok("Message pushed to LINE!");
            } else {
                logger.error("Invalid JSON format or empty events array");
                return ResponseEntity.ok("No events to process, Webhook received successfully.");
            }
        } catch (JSONException e) {
            logger.error("Error parsing JSON message", e);
            return ResponseEntity.status(400).body("Invalid JSON format");
        }
    }
}
