package fs.four.devgang.ojakgyo.user.repository;

import org.apache.ibatis.annotations.Mapper;
import fs.four.devgang.ojakgyo.user.vo.UserVO;
import org.springframework.dao.DataAccessException;

@Mapper
public interface UserDAO {
    public int insertMember(UserVO userVO) throws DataAccessException;

    // 아이디 중복 체크
    public int selectUserId(String userId) throws DataAccessException;

    // 이메일 중복 체크
    public int selectEmail(String email) throws DataAccessException;
}