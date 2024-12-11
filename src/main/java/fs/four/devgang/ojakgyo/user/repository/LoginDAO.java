package fs.four.devgang.ojakgyo.user.repository;

import fs.four.devgang.ojakgyo.user.vo.LoginVO;
import fs.four.devgang.ojakgyo.user.vo.UserVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginDAO {
    UserVO login(LoginVO loginVO);
}
