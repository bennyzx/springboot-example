package cn.eggnetech.eggnetechspringdataweb;

import cn.eggnetech.eggnetechspringdataweb.pojo.Password;
import cn.eggnetech.eggnetechspringdataweb.pojo.Username;
import cn.eggnetech.eggnetechspringdataweb.service.UserManagement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.PostConstruct;
import java.util.stream.IntStream;

/**
 * Central Spring Boot application class to bootstrap the application. Excludes Spring Security auto-configuration as we
 * don't need it for the example but only want to use a {@link PasswordEncoder} (see {@link #passwordEncoder()}).
 * <p>
 * Spring Data web support is transparently activated by Boot for you. In case you want to manually activate it, use
 * {@link EnableSpringDataWebSupport}. The core aspects of the enabled functionality shown in this example are:
 * <ol>
 * <li>Automatic population of a {@link Pageable} instances from request parameters (see
 * {@link cn.eggnetech.eggnetechspringdataweb.controller.UserController#users(Pageable)})</li>
 * <li>The ability to use proxy-backed interfaces to bind request payloads (see
 * {@link cn.eggnetech.eggnetechspringdataweb.controller.UserController.UserForm})</li>
 * </ol>
 */

@SpringBootApplication
public class EggnetechSpringDataWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(EggnetechSpringDataWebApplication.class, args);
    }

    @Autowired
    UserManagement userManagement;

    /**
     * Creates a few sample users.
     */
    @PostConstruct
    public void init() {
        IntStream.range(0, 41).forEach(index -> {
            userManagement.register(new Username("user" + index), Password.raw("COVID-19"));
        });
    }

    /**
     * A Spring Security {@link PasswordEncoder} to encrypt passwords for newly created users, used in
     * {@link UserManagement}.
     *
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
