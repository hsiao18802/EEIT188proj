package tw.com.ispan.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Controller;

import tw.com.ispan.domain.ChatRecord;
import tw.com.ispan.repository.ChatRecordRepository;
import tw.com.ispan.repository.MembersRepository;

@Controller
public class WebSocketChatController {

    @Autowired
    private ChatRecordRepository chatRecordRepository;

    @Autowired
    private MembersRepository membersRepository;

    @Autowired
    private SimpMessageSendingOperations messagingTemplate;

    // 處理客服發送給用戶的消息
    @MessageMapping("/sendMessage/support/{membersId}")
    @SendTo("/topic/support/{membersId}")
    public ChatRecord sendSupportMessage(ChatRecord chatRecord) {
        // 檢查訊息是否為空或只有空白
        if (chatRecord.getMessage() == null || chatRecord.getMessage().trim().isEmpty()) {
            return null; // 如果訊息為空或只有空白，則不執行任何操作
        }

        chatRecord.setTimestamp(new Date());
        chatRecord.setSender("support"); // 設置發送者為客服
        chatRecordRepository.save(chatRecord); // 儲存到資料庫

        return chatRecord;
    }

    // 處理用戶發送給客服的消息
    @MessageMapping("/sendMessage/customer/{membersId}")
    @SendTo("/topic/customer/{membersId}")
    public ChatRecord sendCustomerMessage(ChatRecord chatRecord) {
        // 檢查訊息是否為空或只有空白
        if (chatRecord.getMessage() == null || chatRecord.getMessage().trim().isEmpty()) {
            return null; // 如果訊息為空或只有空白，則不執行任何操作
        }

        chatRecord.setTimestamp(new Date());
        chatRecord.setSender("user"); // 設置發送者為用戶
        chatRecordRepository.save(chatRecord); // 儲存到資料庫

        return chatRecord;
    }

    // 向特定的客戶端發送消息
    public void sendCustomerMessageToUser(ChatRecord chatRecord) {
        // 檢查訊息是否為空或只有空白
        if (chatRecord.getMessage() == null || chatRecord.getMessage().trim().isEmpty()) {
            return; // 如果訊息為空或只有空白，則不執行任何操作
        }
        System.out.println("消息已發送到: /topic/customer/" + chatRecord.getMember().getMembersId());
        messagingTemplate.convertAndSend("/topic/customer/" + chatRecord.getMember().getMembersId(), chatRecord);
    }

    // 向特定的客服端發送消息
    public void sendSupportMessageToAgent(ChatRecord chatRecord) {
        // 檢查訊息是否為空或只有空白
        if (chatRecord.getMessage() == null || chatRecord.getMessage().trim().isEmpty()) {
            return; // 如果訊息為空或只有空白，則不執行任何操作
        }
        System.out.println("消息已發送到: /topic/support/" + chatRecord.getMember().getMembersId());
        messagingTemplate.convertAndSend("/topic/support/" + chatRecord.getMember().getMembersId(), chatRecord);
    }
}
