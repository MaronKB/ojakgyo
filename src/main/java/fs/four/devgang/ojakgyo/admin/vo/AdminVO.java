package fs.four.devgang.ojakgyo.admin.vo;

import org.springframework.stereotype.Component;

import java.util.Date;

@Component("adminVO")
public class AdminVO {
    private String user_id;
    private String user_pw;
    private String user_nickname;
    private String user_email;
    private String user_intro;
    private String user_profile_name;
    private String user_profile_path;
    private String user_address;
    private String user_receive_adv;
    private Date user_reg_date;
    private String user_reg_by;
    private Date user_mod_date;
    private String user_mod_by;
    private Date user_res_date;
    private String user_res_by;
    private String user_is_deleted;

    public AdminVO() {

    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_pw() {
        return user_pw;
    }

    public void setUser_pw(String user_pw) {
        this.user_pw = user_pw;
    }

    public String getUser_nickname() {
        return user_nickname;
    }

    public void setUser_nickname(String user_nickname) {
        this.user_nickname = user_nickname;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getUser_intro() {
        return user_intro;
    }

    public void setUser_intro(String user_intro) {
        this.user_intro = user_intro;
    }

    public String getUser_profile_name() {
        return user_profile_name;
    }

    public void setUser_profile_name(String user_profile_name) {
        this.user_profile_name = user_profile_name;
    }

    public String getUser_profile_path() {
        return user_profile_path;
    }

    public void setUser_profile_path(String user_profile_path) {
        this.user_profile_path = user_profile_path;
    }

    public String getUser_address() {
        return user_address;
    }

    public void setUser_address(String user_address) {
        this.user_address = user_address;
    }

    public String getUser_receive_adv() {
        return user_receive_adv;
    }

    public void setUser_receive_adv(String user_receive_adv) {
        this.user_receive_adv = user_receive_adv;
    }

    public Date getUser_reg_date() {
        return user_reg_date;
    }

    public void setUser_reg_date(Date user_reg_date) {
        this.user_reg_date = user_reg_date;
    }

    public String getUser_reg_by() {
        return user_reg_by;
    }

    public void setUser_reg_by(String user_reg_by) {
        this.user_reg_by = user_reg_by;
    }

    public Date getUser_mod_date() {
        return user_mod_date;
    }

    public void setUser_mod_date(Date user_mod_date) {
        this.user_mod_date = user_mod_date;
    }

    public String getUser_mod_by() {
        return user_mod_by;
    }

    public void setUser_mod_by(String user_mod_by) {
        this.user_mod_by = user_mod_by;
    }

    public Date getUser_res_date() {
        return user_res_date;
    }

    public void setUser_res_date(Date user_res_date) {
        this.user_res_date = user_res_date;
    }

    public String getUser_res_by() {
        return user_res_by;
    }

    public void setUser_res_by(String user_res_by) {
        this.user_res_by = user_res_by;
    }

    public String getUser_is_deleted() {
        return user_is_deleted;
    }

    public void setUser_is_deleted(String user_is_deleted) {
        this.user_is_deleted = user_is_deleted;
    }
}
