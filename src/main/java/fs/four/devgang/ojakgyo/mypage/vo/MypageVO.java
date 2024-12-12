package fs.four.devgang.ojakgyo.mypage.vo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.sql.Date;

@Setter
@Getter
@Component("MypageVO")
public class MypageVO {

    private String user_id;
    private String user_email;
    private String user_pw;
    private String user_nickname;
    private String user_intro;

    public MypageVO() {

    }

}