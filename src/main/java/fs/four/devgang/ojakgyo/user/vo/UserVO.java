package fs.four.devgang.ojakgyo.user.vo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Component
@Getter
@Setter
public class UserVO {
    private String user_id;
    private String user_pw;
    private String user_nickname;
    private String user_email;
    private String user_intro;
    private String user_profile_name;
    private String user_profile_path;
    private String user_address;
    private String user_receive_adv;
    private Timestamp user_reg_date;
    private String user_reg_by;
    private Timestamp user_mod_date;
    private String user_mod_by;
    private Timestamp user_res_date;
    private String user_res_by;
    private char user_is_deleted;
    private char user_is_admin;
}
