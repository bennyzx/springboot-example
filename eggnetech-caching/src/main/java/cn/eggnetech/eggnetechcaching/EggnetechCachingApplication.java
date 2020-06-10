package cn.eggnetech.eggnetechcaching;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * Cache Data with Spring
 */
@SpringBootApplication
@EnableCaching
public class EggnetechCachingApplication {

    public static void main(String[] args) {

        SpringApplication.run(EggnetechCachingApplication.class, args);
    }

}
