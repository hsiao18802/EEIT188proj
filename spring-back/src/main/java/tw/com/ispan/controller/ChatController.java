package tw.com.ispan.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tw.com.ispan.domain.ChatRecord;
import tw.com.ispan.domain.Members;
import tw.com.ispan.repository.ChatRecordRepository;
import tw.com.ispan.repository.MembersRepository;

@CrossOrigin
@RestController
public class ChatController {

    @Autowired
    private ChatRecordRepository chatRecordRepository;

    @Autowired
    private MembersRepository membersRepository;

    @Autowired
    private SimpMessageSendingOperations messagingTemplate;

    /**
     * 處理發送消息的請求
     */
    @MessageMapping("/sendMessage")
    public void handleMessage(ChatRecord message) {
        // 檢查 message 中是否包含會員 ID
        if (message.getMember() == null || message.getMember().getMembersId() == null) {
            throw new IllegalArgumentException("Message or Member information cannot be null");
        }

        // 查找會員
        Members member = membersRepository.findById(message.getMember().getMembersId())
                .orElseThrow(() -> new RuntimeException("無法找到會員，ID：" + message.getMember().getMembersId()));
        message.setMember(member);
        message.setTimestamp(new Date());

        // 保存消息
        chatRecordRepository.save(message);

        // 發送消息到前端訂閱的會員頻道
        messagingTemplate.convertAndSend("/topic/member/" + message.getMember().getMembersId(), message);
    }

    /**
     * 提供 API 來加載指定會員的聊天紀錄
     */
    @GetMapping("/api/chat-history")
    public List<ChatRecord> getChatHistory(@RequestParam("memberId") Integer memberId) {
        Members member = membersRepository.findById(memberId)
                .orElseThrow(() -> new RuntimeException("無法找到會員，ID：" + memberId));

        // 查詢並返回該會員的所有聊天紀錄，按時間排序
        return chatRecordRepository.findByMemberOrderByTimestampAsc(member);
    }
}
