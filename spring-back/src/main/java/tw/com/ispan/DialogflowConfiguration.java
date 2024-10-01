//package tw.com.ispan;
//
//
//
//import java.io.IOException;
//import java.io.InputStream;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.io.ClassPathResource;
//import org.springframework.core.io.FileSystemResource;
//import org.springframework.core.io.Resource;
//
//import com.google.auth.oauth2.GoogleCredentials;
//import com.google.cloud.dialogflow.v2.SessionsClient;
//import com.google.cloud.dialogflow.v2.SessionsSettings;
//
//@Configuration // 改為配置類，來創建 Beans
//public class DialogflowConfiguration {
//
//    @Value("${spring.cloud.gcp.credentials.location}")
//    private String credentialsLocation;
//
//    @Value("${dialogflow.project-id}")
//    private String projectId;
//
//    @Bean
//    public SessionsClient sessionsClient() throws IOException {
//        Resource resource;
//        if (credentialsLocation.startsWith("file:")) {
//            resource = new FileSystemResource(credentialsLocation.substring(5));
//        } else {
//            resource = new ClassPathResource(credentialsLocation);
//        }
//
//        InputStream inputStream = resource.getInputStream();
//        GoogleCredentials credentials = GoogleCredentials.fromStream(inputStream);
//
//        SessionsSettings sessionsSettings = SessionsSettings.newBuilder()
//            .setCredentialsProvider(() -> credentials)
//            .build();
//
//        return SessionsClient.create(sessionsSettings);
//    }
//
//    public String getProjectId() {
//        return projectId;
//    }
//}
