package cn.eggnetech.eggnetechgreeting.restservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *  Building a RESTful Web Service
 *  Usage: http://localhost:8080/greeting
 * @name:
 * @description: Created by Benny Zhou on 2020/3/15
 */
@SpringBootApplication
public class RestServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestServiceApplication.class, args);
    }


}
