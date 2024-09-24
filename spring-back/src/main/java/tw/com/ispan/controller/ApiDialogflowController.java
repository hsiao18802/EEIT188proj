package tw.com.ispan.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.cloud.dialogflow.v2.EventInput;
import com.google.cloud.dialogflow.v2.QueryInput;

import tw.com.ispan.service.DialogflowService;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class ApiDialogflowController {

    @Autowired
    private DialogflowService dialogflowService;

    // 處理來自前端的對話請求
    @PostMapping("/dialogflow")
    public ResponseEntity<Map<String, String>> handleMessage(@RequestBody Map<String, Object> requestBody) {
        String sessionId = (String) requestBody.get("sessionId");
        Map<String, Object> queryInput = (Map<String, Object>) requestBody.get("queryInput");
        Map<String, String> textInput = (Map<String, String>) queryInput.get("text");
        String message = textInput.get("text");

        if (sessionId == null || sessionId.isEmpty()) {
            sessionId = UUID.randomUUID().toString();
        }

        String responseText = dialogflowService.getDialogflowResponse(sessionId, message);

        Map<String, String> response = new HashMap<>();
        response.put("sessionId", sessionId);
        response.put("responseText", responseText);

        return ResponseEntity.ok(response);
    }

    @PostMapping("/welcome")
    public ResponseEntity<Map<String, String>> triggerWelcomeEvent(@RequestBody Map<String, Object> requestBody) {
        String sessionId = (String) requestBody.get("sessionId");
        if (sessionId == null || sessionId.isEmpty()) {
            sessionId = UUID.randomUUID().toString();
        }

        EventInput eventInput = EventInput.newBuilder()
                .setName("Welcome")
                .setLanguageCode("zh-TW")
                .build();
        QueryInput queryInput = QueryInput.newBuilder()
                .setEvent(eventInput)
                .build();

        String responseText = dialogflowService.getDialogflowResponse(sessionId, queryInput);

        Map<String, String> response = new HashMap<>();
        response.put("sessionId", sessionId);
        response.put("responseText", responseText);

        return ResponseEntity.ok(response);
    }
}
