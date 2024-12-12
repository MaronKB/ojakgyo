package fs.four.devgang.ojakgyo.user.vo;

public class FindVO {
    private String email;

    public FindVO() {}

    public FindVO(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "FindVO{" +
                "email='" + email + '\'' +
                '}';
    }
}
