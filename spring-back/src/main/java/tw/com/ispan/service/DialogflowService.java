package tw.com.ispan.service;

import java.io.IOException;
import java.io.InputStream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.dialogflow.v2.DetectIntentResponse;
import com.google.cloud.dialogflow.v2.QueryInput;
import com.google.cloud.dialogflow.v2.QueryResult;
import com.google.cloud.dialogflow.v2.SessionName;
import com.google.cloud.dialogflow.v2.SessionsClient;
import com.google.cloud.dialogflow.v2.SessionsSettings;
import com.google.cloud.dialogflow.v2.TextInput;

@Service
public class DialogflowService {

    @Value("${spring.cloud.gcp.credentials.location}")
    private String credentialsLocation;

    @Value("${dialogflow.project-id}")
    private String projectId;

    private SessionsClient sessionsClient;

    @PostConstruct
    public void init() {
        try {
            // 加載憑證，支持 file: 和 classpath: 前綴
            Resource resource;
            if (credentialsLocation.startsWith("file:")) {
                // 使用文件系統中的文件
                resource = new FileSystemResource(credentialsLocation.substring(5)); // 移除 file: 前綴
            } else {
                // 默認從 classpath 中加載
                resource = new ClassPathResource(credentialsLocation);
            }

            InputStream inputStream = resource.getInputStream();
            GoogleCredentials credentials = GoogleCredentials.fromStream(inputStream);
            System.out.println("Credentials loaded successfully: " + credentials);

            // 使用手動設置的憑證初始化 SessionsClient
            sessionsClient = SessionsClient.create(
                SessionsSettings.newBuilder()
                    .setCredentialsProvider(() -> credentials)
                    .build()
            );

            System.out.println("SessionsClient initialized successfully.");
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Failed to load credentials from " + credentialsLocation);
        }
    }

    public String getDialogflowResponse(String sessionId, String message) {
        try {
            // 創建 Dialogflow Session
            SessionName session = SessionName.of(projectId, sessionId);

            // 設置文本輸入（用戶消息）
            TextInput.Builder textInput = TextInput.newBuilder().setText(message).setLanguageCode("zh-TW");
            QueryInput queryInput = QueryInput.newBuilder().setText(textInput).build();

            // 發送請求到 Dialogflow，獲取回應
            DetectIntentResponse response = sessionsClient.detectIntent(session, queryInput);
            QueryResult queryResult = response.getQueryResult();

            // 返回 Dialogflow 的回應文本
            return queryResult.getFulfillmentText();
        } catch (Exception e) {
            e.printStackTrace();
            return "抱歉，我無法理解您的意思。";
        }
    }
}
