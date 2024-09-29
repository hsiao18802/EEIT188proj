package tw.com.ispan.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.com.ispan.domain.CustomerServiceRequest;
import tw.com.ispan.domain.Members;
import tw.com.ispan.repository.CustomerServiceRequestRepository;
import tw.com.ispan.repository.MembersRepository;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class CustomerServiceRequestController {

    @Autowired
    private CustomerServiceRequestRepository customerServiceRequestRepository;

    @Autowired
    private MembersRepository membersRepository;
    
    
    @Autowired
    private SimpMessageSendingOperations messagingTemplate; // 注入 messagingTemplate

    // 獲取所有等待支援的客戶請求
    @GetMapping("/customer-support-requests")
    public ResponseEntity<List<CustomerServiceRequest>> getAllPendingRequests() {
        // 確保返回的每個請求都包含 ID
        List<CustomerServiceRequest> requests = customerServiceRequestRepository.findByStatus("Pending");
        return ResponseEntity.ok(requests);
    }

   

    // 創建新的客戶請求
    @PostMapping("/customer-support-request")
    public ResponseEntity<?> createRequest(@RequestBody Map<String, Object> requestBody) {
        Integer memberId = (Integer) requestBody.get("memberId");
        String issueDescription = (String) requestBody.get("issueDescription");

        Members member = membersRepository.findById(memberId).orElse(null);
        if (member == null) {
            return ResponseEntity.badRequest().body("Invalid member ID");
        }

        // 檢查是否已經存在 "Pending" 狀態的請求
        List<CustomerServiceRequest> existingRequests = customerServiceRequestRepository.findByMemberAndStatus(member, "Pending");
        if (!existingRequests.isEmpty()) {
            return ResponseEntity.badRequest().body("A pending request already exists for this member.");
        }

        // 如果沒有存在則創建新的請求
        CustomerServiceRequest newRequest = new CustomerServiceRequest();
        newRequest.setMember(member);
        newRequest.setIssueDescription(issueDescription);
        newRequest.setStatus("Pending");
        newRequest.setCreatedAt(new Date());

        customerServiceRequestRepository.save(newRequest);

        // 廣播新請求消息給後台
        messagingTemplate.convertAndSend("/topic/new-support-request", newRequest);

        return ResponseEntity.ok("Request created successfully");
    }
    


    // 刪除客服請求
    @DeleteMapping("/customer-support-request/{id}")
    public ResponseEntity<String> deleteCustomerRequest(@PathVariable Long id) {
        System.out.println("接收到刪除請求，ID：" + id); // 日誌輸出，確認接收到的 ID
        Optional<CustomerServiceRequest> requestOpt = customerServiceRequestRepository.findById(id);

        if (requestOpt.isPresent()) {
            customerServiceRequestRepository.delete(requestOpt.get());
            return ResponseEntity.ok("客服請求已解決並刪除");
        } else {
            return ResponseEntity.badRequest().body("找不到該客服請求，ID：" + id);
        }
    }
}
