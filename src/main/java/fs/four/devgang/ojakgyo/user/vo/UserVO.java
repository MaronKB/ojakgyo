package fs.four.devgang.ojakgyo.user.vo;

import java.util.Date;

public class UserVO {
    private String userId;          // 사용자 ID
    private String password;        // 사용자 비밀번호
    private String nickname;        // 사용자 닉네임
    private String email;           // 사용자 이메일
    private String receiveAd;       // 광고 수신 여부
    private Date userRegDate;       // 사용자 등록일

    public UserVO() {
        this.userRegDate = new Date(); // 현재 시간 기본값
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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
        return "UserVO{" +
                "userId='" + userId + '\'' +
                ", password='" + password + '\'' +
                ", nickname='" + nickname + '\'' +
                ", email='" + email + '\'' +
                ", receiveAd='" + receiveAd + '\'' +
                ", userRegDate=" + userRegDate +
                '}';
    }
}
