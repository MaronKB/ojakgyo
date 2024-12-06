package fs.four.devgang.ojakgyo.user.entity;

public class User {

    private String userId;            // 아이디
    private String userPw;            // 비밀번호
    private String userNickname;      // 닉네임
    private String userEmail;         // 이메일
    private String userIntro;         // 자기소개
    private String userReceiveAdv;    // 광고성 이메일 수신 여부 (Y 또는 N)

    // Getter & Setter 메소드
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserPw() {
        return userPw;
    }

    public void setUserPw(String userPw) {
        this.userPw = userPw;
    }

    public String getUserNickname() {
        return userNickname;
    }

    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserIntro() {
        return userIntro;
    }

    public void setUserIntro(String userIntro) {
        this.userIntro = userIntro;
    }

    public String getUserReceiveAdv() {
        return userReceiveAdv;
    }

    public void setUserReceiveAdv(String userReceiveAdv) {
        this.userReceiveAdv = userReceiveAdv;
    }
}