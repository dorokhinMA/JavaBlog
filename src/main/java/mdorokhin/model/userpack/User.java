package mdorokhin.model.userpack;

import mdorokhin.model.BaseEntity;

/**
 * @author Maxim Dorokhin
 *         17.05.2016.
 */
public class User extends BaseEntity {

    private String fullName;
    private String login;
    private String password;
    private Role role;

    public User() {
    }

    public User(String fullName, String login, String password, Role role) {
        super();
        this.fullName = fullName;
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "fullName='" + fullName + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }
}
