package fs.four.devgang.ojakgyo.mypage.vo;

import org.springframework.stereotype.Component;

import java.sql.Date;

@Component("codeGroupVO")
public class CodeGroupVO {

    private String user_id;
    private String user_pw;
    private String user_nickname;
    private Date user_intro;
    private String created_date;
    private Date updated_date;

    public CodeGroupVO() {

    }

    public String getCode_group() {
        return user_id;
    }

    public void setCode_group(String code_group) {
        this.user_id = user_id;
    }

    public String getCode_name() {
        return user_pw;
    }

    public void setCode_name(String code_name) {
        this.user_pw = user_pw;
    }

    public String getUse_yn() {
        return user_nickname;
    }

    public void setUse_yn(String use_yn) {
        this.user_nickname = user_nickname;
    }

    public Date getCreated_date() {
        return user_intro;
    }

    public void setCreated_date(Date created_date) {
        this.user_intro = user_intro;
    }

    public String getCreated_id() {
        return created_date;
    }

    public void setCreated_id(String created_id) {
        this.created_date = created_date;
    }

    public Date getUpdated_date() {
        return updated_date;
    }

    public void setUpdated_date(Date updated_date) {
        this.updated_date = updated_date;
    }

}