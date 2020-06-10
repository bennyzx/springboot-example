package cn.eggnetech.eggnetechspringdataweb.pojo;

import lombok.Getter;
import lombok.EqualsAndHashCode;
import lombok.AllArgsConstructor;
import lombok.AccessLevel;
import lombok.experimental.Delegate;

import javax.persistence.Embeddable;

import static lombok.AccessLevel.PRIVATE;

/**
 * A value object to represent {@link Password}s in encrypted and unencrypted state.
 * Now how the methods to create a {@link Password} in encrypted state are restricted to package scope.
 * So that only the user subsystem is actually able to encrypted passwords.
 *
 * @author Benny.Zhou
 * @date 2020/3/20
 */

@EqualsAndHashCode
@AllArgsConstructor(access = PRIVATE)
@Getter(AccessLevel.PACKAGE)
@Embeddable
public class Password implements CharSequence {

    @Delegate
    private final String password;
    @Getter
    private transient boolean encrypted;

    public Password() {
        this.password = null;
        this.encrypted = true;
    }

    /**
     * Creates a new raw {@link Password} for the given source {@link String}.
     *
     * @param password must not be {@literal null} or empty.
     * @return
     */
    public static Password raw(String password) {
       return new Password(password, false);
    }

    /**
     * Creates a new encrypted {@link Password} for the given {@link String}.
     * Note how this method is package protected.
     * So that encrypted passwords can only created by components in this package
     * and not accidentally by clients using the type from other packages.
     *
     * @param password must not be {@literal null} or empty.
     * @return
     */
    public static Password encrypted(String password) {
        return new Password(password, true);
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return encrypted ? password : "********";
    }
}
