package tw.com.ispan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;


//@EnableScheduling // 啟用定時任務 for 逾期取消訂單
@SpringBootApplication
public class LabbootHibernateApplication {
	public static void main(String[] args) {
		SpringApplication.run(LabbootHibernateApplication.class, args);
	}
	
	
	
}
