package tw.com.ispan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.cloud.dialogflow.v2.DetectIntentResponse;
import com.google.cloud.dialogflow.v2.QueryInput;
import com.google.cloud.dialogflow.v2.QueryResult;
import com.google.cloud.dialogflow.v2.SessionName;
import com.google.cloud.dialogflow.v2.SessionsClient;
import com.google.cloud.dialogflow.v2.TextInput;

import tw.com.ispan.DialogflowConfiguration;

@Service
public class DialogflowService {

    @Autowired
    private SessionsClient sessionsClient;

    @Autowired
    private DialogflowConfiguration dialogflowConfiguration;

    // 原有的方法，處理文字輸入的對話
    public String getDialogflowResponse(String sessionId, String message) {
        try {
            SessionName session = SessionName.of(dialogflowConfiguration.getProjectId(), sessionId);
            TextInput.Builder textInput = TextInput.newBuilder().setText(message).setLanguageCode("zh-TW");
            QueryInput queryInput = QueryInput.newBuilder().setText(textInput).build();
            return getDialogflowResponse(session, queryInput);
        } catch (Exception e) {
            e.printStackTrace();
            return "抱歉，我無法理解您的意思。";
        }
    }

    
    public boolean checkForHumanAgentIntent(String sessionId, String message) {
        try {
            SessionName session = SessionName.of(dialogflowConfiguration.getProjectId(), sessionId);
            TextInput.Builder textInput = TextInput.newBuilder().setText(message).setLanguageCode("zh-TW");
            QueryInput queryInput = QueryInput.newBuilder().setText(textInput).build();
            DetectIntentResponse response = sessionsClient.detectIntent(session, queryInput);
            QueryResult queryResult = response.getQueryResult();

            // 檢查是否匹配人工客服的 Intent
            String intentDisplayName = queryResult.getIntent().getDisplayName();
            if ("SwitchToHuman".equals(intentDisplayName)) { // 將這裡替換為你在 Dialogflow 設定的 Intent 名稱
                return true; // 轉接到人工客服
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    
    
    
    
    
    
    
    
    
    
    // 新增的方法，處理不同類型的 QueryInput（例如 EventInput）
    public String getDialogflowResponse(String sessionId, QueryInput queryInput) {
        try {
            SessionName session = SessionName.of(dialogflowConfiguration.getProjectId(), sessionId);
            return getDialogflowResponse(session, queryInput);
        } catch (Exception e) {
            e.printStackTrace();
            return "抱歉，目前無法處理您的請求。";
        }
    }

    // 核心方法，處理所有的 Dialogflow 請求
    private String getDialogflowResponse(SessionName session, QueryInput queryInput) {
        try {
            DetectIntentResponse response = sessionsClient.detectIntent(session, queryInput);
            QueryResult queryResult = response.getQueryResult();

            // 打印原始的 queryResult 以調試
            System.out.println("Dialogflow QueryResult: " + queryResult.toString());

            // 直接返回原始的 fulfillment_text
            String fulfillmentText = queryResult.getFulfillmentText();
            System.out.println("Fulfillment Text (Original): " + fulfillmentText);

            return fulfillmentText;
        } catch (Exception e) {
            e.printStackTrace();
            return "抱歉，目前無法處理您的請求。";
        }
    }

    public String getProjectId() {
        return dialogflowConfiguration.getProjectId();
    }
}
