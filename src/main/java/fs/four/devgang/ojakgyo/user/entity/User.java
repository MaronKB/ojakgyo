package fs.four.devgang.ojakgyo.user.entity;

public class User {
    private String username; // 아이디
    private String password; // 비밀번호
    private String email;    // 이메일

    // 기본 생성자
    public User() {
    }

    // 전체 필드를 포함하는 생성자
    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    // Getters and Setters
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}