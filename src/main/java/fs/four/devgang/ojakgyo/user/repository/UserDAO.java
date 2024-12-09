package fs.four.devgang.ojakgyo.user.repository;

import org.apache.ibatis.annotations.Mapper;
import fs.four.devgang.ojakgyo.user.vo.UserVO;
import org.springframework.dao.DataAccessException;

@Mapper
public interface UserDAO {
    public int insertMember(UserVO userVO) throws DataAccessException;
}