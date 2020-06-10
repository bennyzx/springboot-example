package cn.eggnetech.eggnetechspringdataweb.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;;

/**
 * A {@link User} domain object. The primary entity of this example. Basically a combination of a {@link Username} and
 * {@link Password}
 *
 * @author Benny.Zhou
 * @date 2020/3/20
 */
@Entity
@Getter
@RequiredArgsConstructor
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@EqualsAndHashCode(of = "id")
public class User {
    @GeneratedValue @Id
    private Long id;
    private final Username username;
    private final Password password;

    public User() {
        this.username = null;
        this.password = null;
    }

    /**
     * Makes sure only {@link User}s with encrypted {@link Password} can be persisted.
     */
    @PrePersist
    @PreUpdate
    public void assertEncrypted() {
        if (!password.isEncrypted()) {
            throw new IllegalStateException("Tried to persist/load a user with a non-encrypted password!");
        }
    }
}
