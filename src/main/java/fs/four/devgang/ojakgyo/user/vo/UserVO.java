package fs.four.devgang.ojakgyo.user.vo;

import java.util.Date;

public class UserVO {

    private String user_id;          // 사용자 ID
    private String user_pw;          // 사용자 비밀번호
    private String user_nickname;    // 사용자 닉네임
    private String user_email;       // 사용자 이메일
    private String user_receive_adv; // 광고 수신 여부
    private Date user_reg_date;      // 사용자 등록일

    // 사용자 ID getter, setter
    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    // 사용자 비밀번호 getter, setter
    public String getUser_pw() {
        return user_pw;
    }

    public void setUser_pw(String user_pw) {
        this.user_pw = user_pw;
    }

    // 사용자 닉네임 getter, setter
    public String getUser_nickname() {
        return user_nickname;
    }

    public void setUser_nickname(String user_nickname) {
        this.user_nickname = user_nickname;
    }

    // 사용자 이메일 getter, setter
    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    // 광고 수신 여부 getter, setter
    public String getUser_receive_adv() {
        return user_receive_adv;
    }

    public void setUser_receive_adv(String user_receive_adv) {
        this.user_receive_adv = user_receive_adv;
    }

    // 사용자 등록일 getter, setter
    public Date getUser_reg_date() {
        return user_reg_date;
    }

    public void setUser_reg_date(Date user_reg_date) {
        this.user_reg_date = user_reg_date;
    }

}