package indi.programmer.core.pojo;

/**user表对应的bean类*/
public class User {
    private Integer id;
    private String username;
    private String password;
    private String telephone;
    private String avatar;
    private String email;

    /**构造方法*/
    public User() {
    }

    public User(Integer id, String username, String password, String telephone, String avatar, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.telephone = telephone;
        this.avatar = avatar;
        this.email = email;
    }

    /**setter和getter*/
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    /**toString*/
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", telephone='" + telephone + '\'' +
                ", avatar='" + avatar + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
