package tw.com.ispan.controller;

import com.linecorp.bot.client.LineMessagingClient;
import com.linecorp.bot.model.ReplyMessage;
import com.linecorp.bot.model.event.MessageEvent;
import com.linecorp.bot.model.event.message.TextMessageContent;
import com.linecorp.bot.model.message.TextMessage;
import com.linecorp.bot.spring.boot.annotation.EventMapping;
import com.linecorp.bot.spring.boot.annotation.LineMessageHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.concurrent.ExecutionException;

import tw.com.ispan.service.DialogflowService;

@LineMessageHandler
@RestController
public class LineBotController {

    private static final Logger logger = LoggerFactory.getLogger(LineBotController.class);

    @Autowired
    private LineMessagingClient lineMessagingClient;

    @Autowired
    private DialogflowService dialogflowService;

    @EventMapping
    public void handleTextMessageEvent(MessageEvent<TextMessageContent> event) {
        String replyToken = event.getReplyToken(); // 獲取 replyToken
        String userMessage = event.getMessage().getText();
        String userId = event.getSource().getUserId();

        try {
            // 調用 Dialogflow API 獲取回應
            String responseText = dialogflowService.getDialogflowResponse(userId, userMessage);

            // 在這裡加上 System.out.println 來調試
            System.out.println("Dialogflow Response: " + responseText);
            System.out.println("Reply Token: " + replyToken);
            System.out.println("Response Text: " + responseText);

            // 檢查並處理 Dialogflow 回應，如果是 JSON 格式，進行相應解析
            if (responseText != null && responseText.startsWith("{")) {
                responseText = "這是來自 Dialogflow 的回應，請檢查格式"; // 示例固定回應
            }

            // 發送回應訊息
            TextMessage textMessage = new TextMessage(responseText);
            ReplyMessage replyMessage = new ReplyMessage(replyToken, textMessage);

            // 使用同步方式發送訊息
            lineMessagingClient.replyMessage(replyMessage).get();
        } catch (InterruptedException | ExecutionException e) {
            logger.error("Error sending reply message to LINE", e);
        } catch (Exception e) {
            logger.error("Unexpected error occurred", e);
        }
    }


}
