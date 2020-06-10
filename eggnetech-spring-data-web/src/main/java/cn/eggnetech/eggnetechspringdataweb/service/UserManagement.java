package cn.eggnetech.eggnetechspringdataweb.service;

import cn.eggnetech.eggnetechspringdataweb.dao.UserRepository;
import cn.eggnetech.eggnetechspringdataweb.pojo.Password;
import cn.eggnetech.eggnetechspringdataweb.pojo.User;
import cn.eggnetech.eggnetechspringdataweb.pojo.Username;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.transaction.Transactional;
import java.util.Optional;

/**
 * @name:
 * @description: Created by Benny Zhou on 2020/3/20
 */
@Transactional
@Service
@RequiredArgsConstructor
public class UserManagement {
    private final UserRepository repository;
    private final PasswordEncoder encoder;

    /**
     * Registers a {@link User} with the given {@link Username} and {@link Password}.
     *
     * @param username must not be {@literal null}.
     * @param password must not be {@literal null}.
     * @return
     */
    public User register(Username username, Password password) {
        Assert.notNull(username, "Username must not be null!");
        Assert.notNull(password, "Password must not be null!");
        repository.findByUsername(username).ifPresent(user -> {
            throw new IllegalArgumentException("User with that name already exists!");
        });
        Password encryptedPassword = Password.encrypted(encoder.encode(password));
        return repository.save(new User(username, encryptedPassword));
    }

    /**
     * Returns a {@link Page} of {@link User} for the given {@link Pageable}.
     *
     * @param pageable must not be {@literal null}.
     * @return
     */
    public Page<User> findAll(Pageable pageable) {
        Assert.notNull(pageable, "Pageable must not be null!");
        return repository.findAll(pageable);
    }

    /**
     * Returns the {@link User} with the given {@link Username}.
     *
     * @param username must not be {@literal null}.
     * @return
     */
    public Optional<User> findByUsername(Username username) {
        Assert.notNull(username, "Username must not be null!");
        return repository.findByUsername(username);
    }
}
