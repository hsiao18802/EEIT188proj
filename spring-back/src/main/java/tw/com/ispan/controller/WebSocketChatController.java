package tw.com.ispan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Controller;
import tw.com.ispan.domain.ChatRecord;
import tw.com.ispan.domain.Members;
import tw.com.ispan.repository.ChatRecordRepository;
import tw.com.ispan.repository.MembersRepository;

import java.util.Date;

@Controller
public class WebSocketChatController {

    @Autowired
    private ChatRecordRepository chatRecordRepository;

    @Autowired
    private MembersRepository membersRepository;

    @Autowired
    private SimpMessageSendingOperations messagingTemplate;

    @MessageMapping("/sendMessage")
    @SendTo("/topic/messages")
    public ChatRecord sendMessage(ChatRecord chatRecord) {
        // 儲存聊天記錄到資料庫
        chatRecord.setTimestamp(new Date());
        chatRecordRepository.save(chatRecord);

        return chatRecord;
    }

    public void sendCustomerMessageToUser(ChatRecord chatRecord) {
        // 發送消息給特定客戶端
        messagingTemplate.convertAndSend("/topic/messages/" + chatRecord.getMember().getMembersId(), chatRecord);
    }
}
