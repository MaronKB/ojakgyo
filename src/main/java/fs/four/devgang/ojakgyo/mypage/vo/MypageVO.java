package fs.four.devgang.ojakgyo.mypage.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MypageVO {

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setUserPw(String userPw) {
        this.userPw = userPw;
    }

    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public void setUserIntro(String userIntro) {
        this.userIntro = userIntro;
    }

    private String userId; // USER_ID
    private String userPw; // USER_PW
    private String userNickname; // USER_NICKNAME
    private String userEmail; // USER_EMAIL
    private String userIntro; // USER_INTRO

    // Getters and Setters

}
