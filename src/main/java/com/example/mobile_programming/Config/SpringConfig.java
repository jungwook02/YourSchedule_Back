package com.example.mobile_programming.Config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SpringConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // 모든 엔드포인트에 대해 CORS를 허용합니다.
                .allowedOrigins("*") // 모든 출처를 허용합니다. 필요한 경우 출처를 구체적으로 지정할 수 있습니다.
                .allowedMethods("GET", "POST", "PUT", "DELETE") // 허용할 HTTP 메서드를 지정합니다.
                .allowedHeaders("*"); // 모든 헤더를 허용합니다. 필요한 경우 특정 헤더를 지정할 수 있습니다.
    }
}