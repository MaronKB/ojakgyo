package fs.four.devgang.ojakgyo.user.repository;

import fs.four.devgang.ojakgyo.user.vo.ChangePwVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ChangePwDAO {
    // 비밀번호 변경 메서드
    int updatePassword(ChangePwVO changePwVO);
}
