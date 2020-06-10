package cn.eggnetech.eggnetechrestservicecors;



import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @name:
 * @description: Created by Benny Zhou on 2020/3/16
 */
@RestController
public class GreetingController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @CrossOrigin(origins = "http://eggnetech.cn:9000")
    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(required = false, defaultValue = "Eggnetech") String name) {
        System.out.println("================ in greeting ==============");
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    @RequestMapping("/greeting-javaconfig")
    public Greeting greetingWithJavaconfig(@RequestParam(required = false, defaultValue = "World") String name){
        System.out.println("================ in greeting CORS ==============");
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
}
