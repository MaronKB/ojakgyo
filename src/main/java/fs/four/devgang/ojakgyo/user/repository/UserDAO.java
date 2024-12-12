package fs.four.devgang.ojakgyo.user.repository;

import org.apache.ibatis.annotations.Mapper;
import fs.four.devgang.ojakgyo.user.vo.UserVO;
import org.springframework.dao.DataAccessException;

@Mapper
public interface UserDAO {
    public int insertUser(UserVO userVO) throws DataAccessException;

    public int countUserById(String userId) throws DataAccessException;
    public int countUserByEmail(String email) throws DataAccessException;
}