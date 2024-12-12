package fs.four.devgang.ojakgyo.user.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Getter
@Setter
public class UserVO {
    private String userId;          // 사용자 ID
    private String password;        // 사용자 비밀번호
    private String nickname;        // 사용자 닉네임
    private String email;           // 사용자 이메일
    private String receiveAd;       // 광고 수신 여부
    private Date userRegDate;       // 사용자 등록일
}
