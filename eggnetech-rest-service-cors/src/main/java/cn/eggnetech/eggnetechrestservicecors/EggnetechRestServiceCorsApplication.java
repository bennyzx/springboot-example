package cn.eggnetech.eggnetechrestservicecors;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Enabling Cross Origin Requests for a RESTful Web Service
 */

@SpringBootApplication
public class EggnetechRestServiceCorsApplication {

    public static void main(String[] args) {
        SpringApplication.run(EggnetechRestServiceCorsApplication.class, args);
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/greeting-javaconfig").allowedOrigins("http://eggnetech.cn:9000");
            }
        };
    }
}
