package tw.com.ispan.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.com.ispan.domain.CustomerServiceRequest;
import tw.com.ispan.domain.Members;
import tw.com.ispan.repository.CustomerServiceRequestRepository;
import tw.com.ispan.repository.MembersRepository;
import tw.com.ispan.service.DialogflowService;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class ApiDialogflowController {

    @Autowired
    private DialogflowService dialogflowService;

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

//            // 判斷是否觸發了人工客服 Intent
//            boolean isHumanAgent = dialogflowService.checkForHumanAgentIntent(sessionId, message);
//
//            if (isHumanAgent) {
//                System.out.println("轉接人工客服...");
//                // 檢查是否已經有未解決的客服請求
//                Optional<CustomerServiceRequest> existingRequest = customerServiceRequestRepository.findTopByMemberAndStatusOrderByCreatedAtDesc(member, "Pending");
//
//                if (existingRequest.isPresent()) {
//                    // 已經有未解決的請求，不需要創建新的
//                    CustomerServiceRequest existing = existingRequest.get();
//                    existing.setIssueDescription("User re-requested for human agent support."); // 可選：更新問題描述
//                    customerServiceRequestRepository.save(existing);
//                } else {
//                    // 沒有未解決的請求，創建新的
//                    CustomerServiceRequest customerServiceRequest = new CustomerServiceRequest();
//                    customerServiceRequest.setMember(member);
//                    customerServiceRequest.setIssueDescription("User requested for human agent support.");
//                    customerServiceRequest.setStatus("Pending");
//                    customerServiceRequest.setCreatedAt(new Date());
//                    customerServiceRequestRepository.save(customerServiceRequest);
//                }
//            }

            // 返回回應
            Map<String, Object> response = new HashMap<>();
            response.put("sessionId", sessionId);
            response.put("responseText", responseText);
//            response.put("isHumanAgent", isHumanAgent); // 傳遞是否是人工客服的標記

            return ResponseEntity.ok(response);
        } else {
            // 如果找不到會員，返回錯誤回應
            Map<String, Object> response = new HashMap<>();
            response.put("error", "會員未找到");
            return ResponseEntity.status(400).body(response);
        }
    }

    
    
}
