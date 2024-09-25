package tw.com.ispan.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.cloud.dialogflow.v2.EventInput;
import com.google.cloud.dialogflow.v2.QueryInput;

import tw.com.ispan.domain.ChatRecord;
import tw.com.ispan.domain.CustomerServiceRequest;
import tw.com.ispan.domain.Members;
import tw.com.ispan.repository.ChatRecordRepository;
import tw.com.ispan.repository.CustomerServiceRequestRepository;
import tw.com.ispan.repository.MembersRepository;
import tw.com.ispan.service.DialogflowService;

@CrossOrigin// 設置 CORS 政策，允許來自前端的請求
@RestController
@RequestMapping("/api")
public class ApiDialogflowController {

    @Autowired
    private DialogflowService dialogflowService;

    @Autowired
    private ChatRecordRepository chatRecordRepository; // 聊天紀錄的 repository

    @Autowired
    private MembersRepository membersRepository; // 會員的 repository

    @Autowired
    private CustomerServiceRequestRepository customerServiceRequestRepository; // 客戶服務請求的 repository

    // 處理來自前端的對話請求
    @PostMapping("/dialogflow")
    public ResponseEntity<Map<String, Object>> handleMessage(@RequestBody Map<String, Object> requestBody) {
        String sessionId = (String) requestBody.get("sessionId");
        Map<String, Object> queryInput = (Map<String, Object>) requestBody.get("queryInput");
        Map<String, String> textInput = (Map<String, String>) queryInput.get("text");
        String message = textInput.get("text");

        // 如果沒有 sessionId，則生成一個新的 UUID 作為 sessionId
        if (sessionId == null || sessionId.isEmpty()) {
            sessionId = UUID.randomUUID().toString();
        }

        // 假設前端傳來會員 ID，這樣可以在每次請求中關聯到具體會員
        Integer membersId = (Integer) requestBody.get("membersId");

        Optional<Members> optionalMember = membersRepository.findById(membersId);

        if (optionalMember.isPresent()) {
            Members member = optionalMember.get();

            // 調用 Dialogflow API 並獲取回應
            String responseText = dialogflowService.getDialogflowResponse(sessionId, message);

            // 判斷是否觸發了人工客服 Intent
            boolean isHumanAgent = dialogflowService.checkForHumanAgentIntent(sessionId, message);

            if (isHumanAgent) {
                System.out.println("轉接人工客服...");
                // 如果觸發了人工客服，則在 CustomerServiceRequest 中建立一個新的請求
                CustomerServiceRequest customerServiceRequest = new CustomerServiceRequest();
                customerServiceRequest.setMember(member);
                customerServiceRequest.setIssueDescription("User requested for human agent support.");
                customerServiceRequest.setStatus("Pending"); // 初始狀態設置為等待處理
                customerServiceRequest.setCreatedAt(new Date());
                customerServiceRequestRepository.save(customerServiceRequest);
            }

            // 儲存聊天記錄
            ChatRecord chatRecord = new ChatRecord();
            chatRecord.setSessionId(sessionId);
            chatRecord.setMember(member); // 關聯到具體會員
            chatRecord.setSender("user"); // 設置發送方是用戶
            chatRecord.setMessage(message);
            chatRecord.setTimestamp(new Date()); // 設置當前時間
            chatRecordRepository.save(chatRecord);

            // 儲存機器人的回覆
            ChatRecord botReply = new ChatRecord();
            botReply.setSessionId(sessionId);
            botReply.setMember(member); // 關聯到具體會員
            botReply.setSender("support"); // 設置發送方是客服
            botReply.setMessage(responseText);
            botReply.setTimestamp(new Date()); // 設置當前時間
            chatRecordRepository.save(botReply);

            // 返回回應
            Map<String, Object> response = new HashMap<>();
            response.put("sessionId", sessionId);
            response.put("responseText", responseText);
            response.put("isHumanAgent", isHumanAgent); // 傳遞是否是人工客服的標記

            return ResponseEntity.ok(response);
        } else {
            // 如果找不到會員，返回錯誤回應
            Map<String, Object> response = new HashMap<>();
            response.put("error", "會員未找到");
            return ResponseEntity.status(400).body(response);
        }
    }

    // 加載聊天歷史記錄
    @PostMapping("/chat-history")
    public ResponseEntity<List<Map<String, Object>>> getChatHistory(@RequestBody Map<String, Object> requestBody) {
        Integer membersId = (Integer) requestBody.get("membersId");
        List<Map<String, Object>> chatHistory = new ArrayList<>();

        // 查詢與此會員相關的所有聊天紀錄，按時間排序
        List<ChatRecord> chatRecords = chatRecordRepository.findByMember_MembersIdOrderByTimestampAsc(membersId);
        for (ChatRecord record : chatRecords) {
            Map<String, Object> chatData = new HashMap<>();
            chatData.put("sender", record.getSender());
            chatData.put("text", record.getMessage());
            chatData.put("timestamp", record.getTimestamp());
            chatHistory.add(chatData);
        }

        return ResponseEntity.ok(chatHistory);
    }

    // 處理人工客服請求的 API
    @PostMapping("/customer-support")
    public ResponseEntity<Map<String, Object>> handleCustomerSupportRequest(@RequestBody Map<String, Object> requestBody) {
        Integer membersId = (Integer) requestBody.get("membersId");
        String issueDescription = (String) requestBody.get("issueDescription"); // 前端傳遞的問題描述

        // 檢查會員 ID 是否存在
        if (membersId == null) {
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("error", "Member ID must not be null.");
            return ResponseEntity.badRequest().body(errorResponse);
        }

        // 查找會員信息
        Optional<Members> optionalMember = membersRepository.findById(membersId);

        if (optionalMember.isPresent()) {
            Members member = optionalMember.get();

            // 新建一個 CustomerServiceRequest 實體並儲存到資料庫
            CustomerServiceRequest customerServiceRequest = new CustomerServiceRequest();
            customerServiceRequest.setMember(member);
            customerServiceRequest.setIssueDescription(issueDescription != null ? issueDescription : "User requested for human agent support.");
            customerServiceRequest.setStatus("Pending"); // 初始狀態設置為等待處理
            customerServiceRequest.setCreatedAt(new Date());

            customerServiceRequestRepository.save(customerServiceRequest);

            Map<String, Object> response = new HashMap<>();
            response.put("message", "客服請求已創建。");
            return ResponseEntity.ok(response);
        } else {
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("error", "會員未找到");
            return ResponseEntity.status(400).body(errorResponse);
        }
    }
    
    @GetMapping("/customer-support-requests")
    public ResponseEntity<List<Map<String, Object>>> getCustomerSupportRequests() {
        List<Map<String, Object>> responseList = new ArrayList<>();

        // 查詢狀態為 Pending 的客服請求
        List<CustomerServiceRequest> customerRequests = customerServiceRequestRepository.findByStatus("Pending");

        for (CustomerServiceRequest request : customerRequests) {
            Map<String, Object> response = new HashMap<>();
            response.put("id", request.getId());
            response.put("membersId", request.getMember().getMembersId());
            response.put("issueDescription", request.getIssueDescription());
            response.put("status", request.getStatus());
            responseList.add(response);
        }

        return ResponseEntity.ok(responseList);
    }
    
    
    

    // 處理歡迎事件
    @PostMapping("/welcome")
    public ResponseEntity<Map<String, Object>> triggerWelcomeEvent(@RequestBody Map<String, Object> requestBody) {
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

        Map<String, Object> response = new HashMap<>();
        response.put("sessionId", sessionId);
        response.put("responseText", responseText);

        return ResponseEntity.ok(response);
    }
}
