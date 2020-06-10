package cn.eggnetech.eggnetechgreeting.restservice;

import cn.eggnetech.eggnetechgreeting.restservice.Greeting;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @name:
 * @description: Created by Benny Zhou on 2020/3/14
 */
@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "Eggnetech") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
}
