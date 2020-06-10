package cn.eggnetech.eggnetechspringdataweb.dao;

import cn.eggnetech.eggnetechspringdataweb.pojo.User;
import cn.eggnetech.eggnetechspringdataweb.pojo.Username;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

/**
 * A Spring Data respository to persist {@link User}s.
 *
 * @author Benny.Zhou
 * @date 2020/3/20
 */
public interface UserRepository extends PagingAndSortingRepository<User, Long> {

    /**
     * Returns the user with the given {@link Username}.
     *
     * @param username can be {@literal null}.
     * @return
     */
    Optional<User> findByUsername(Username username);
}
