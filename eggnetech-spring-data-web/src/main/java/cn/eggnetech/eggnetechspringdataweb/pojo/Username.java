package cn.eggnetech.eggnetechspringdataweb.pojo;

import lombok.EqualsAndHashCode;
import org.springframework.util.StringUtils;

import javax.persistence.Embeddable;

/**
 * Value Object to represent user names.
 *
 * @author Benny.Zhou
 * @date 2020/3/20
 */
@EqualsAndHashCode
@Embeddable
public class Username {
    private final String username;

    public Username() {
        this.username = null;
    }

    /**
     * Creates a new {@link Username}
     *
     * @param username must not be {@literal null} or empty.
     */
    public Username(String username) {
        if (!StringUtils.hasText(username)) {
            throw new IllegalArgumentException("Invalid username");
        }
        this.username = username;
    }

    /**
     * (non-Javadoc)
     * @see java.lang.Object@toString()
     *
     * @return
     */
    @Override
    public String toString() {
        return username;
    }
}
