package fs.four.devgang.ojakgyo.user.repository;

import fs.four.devgang.ojakgyo.user.vo.LoginVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginDAO {
    LoginVO login(LoginVO loginVO);
}