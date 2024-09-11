package tw.com.ispan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import tw.com.ispan.interceptor.JsonWebTokenInterceptor;

@Configuration
@EnableTransactionManagement
public class SpringBootConfig implements WebMvcConfigurer {
    @Autowired
    private JsonWebTokenInterceptor jsonWebTokenInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(jsonWebTokenInterceptor).addPathPatterns(
				"/ajax/pages/products/**",
				"/rent/product/**",
				"/rent/member/info"
				);
    }
}
