package fs.four.devgang.ojakgyo.user.vo;

import java.util.Date;

public class LoginVO {
    private String userid;
    private String password;
    private String nickname;
    private String email;
    private String receiveAd;
    private Date userRegDate;

    public LoginVO() {
        this.userRegDate = new Date(); // 기본값
    }

    public LoginVO(String userid, String password) {
        this.userid = userid;
        this.password = password;
    }

    // Getter/Setter
    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getReceiveAd() {
        return receiveAd;
    }

    public void setReceiveAd(String receiveAd) {
        this.receiveAd = receiveAd;
    }

    public Date getUserRegDate() {
        return userRegDate;
    }

    public void setUserRegDate(Date userRegDate) {
        this.userRegDate = userRegDate;
    }

    @Override
    public String toString() {
        return "LoginVO{" +
                "userid='" + userid + '\'' +
                ", password='******'" +
                ", nickname='" + nickname + '\'' +
                ", email='" + email + '\'' +
                ", receiveAd='" + receiveAd + '\'' +
                ", userRegDate=" + userRegDate +
                '}';
    }
}
