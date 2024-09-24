package tw.com.ispan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import tw.com.ispan.service.DialogflowService;
import tw.com.ispan.service.LineMessageService;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class ApiDialogflowController {

    @Autowired
    private DialogflowService dialogflowService;

    @Autowired
    private LineMessageService lineMessageService; // 新增 LineMessageService 來處理推送消息

    // 處理來自前端的對話請求
    @PostMapping("/dialogflow")
    public ResponseEntity<Map<String, String>> handleMessage(@RequestBody Map<String, Object> requestBody) {
        // 獲取 sessionId 和用戶消息
        String sessionId = (String) requestBody.get("sessionId");
        Map<String, Object> queryInput = (Map<String, Object>) requestBody.get("queryInput");
        Map<String, String> textInput = (Map<String, String>) queryInput.get("text");
        String message = textInput.get("text");

        // 如果沒有 sessionId，則生成一個新的 UUID 作為 sessionId
        if (sessionId == null || sessionId.isEmpty()) {
            sessionId = UUID.randomUUID().toString();
        }

        // 調用 Dialogflow API 並獲取回應
        String responseText = dialogflowService.getDialogflowResponse(sessionId, message);

        // 透過 Line API 推送消息到指定用戶
        String userId = "U7b2bd6649cb9eb31c62bc0d6712cc143"; // 這裡需要提供具體用戶的 LINE ID
        lineMessageService.pushMessage(userId, responseText);

        // 構建回應返回給前端
        Map<String, String> response = new HashMap<>();
        response.put("sessionId", sessionId);
        response.put("responseText", responseText);

        return ResponseEntity.ok(response);
    }
}
