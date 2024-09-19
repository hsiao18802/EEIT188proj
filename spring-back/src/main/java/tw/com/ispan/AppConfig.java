package tw.com.ispan;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tw.com.ispan.DTO.ConvertCartToDTO;

@Configuration
public class AppConfig {

    @Bean
    public ConvertCartToDTO convertCartToDTO() {
        return new ConvertCartToDTO();
    }
}
