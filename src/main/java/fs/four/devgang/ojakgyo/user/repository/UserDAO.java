package fs.four.devgang.ojakgyo.user.repository;

import org.apache.ibatis.annotations.Mapper;
import fs.four.devgang.ojakgyo.user.vo.UserVO;
import org.springframework.dao.DataAccessException;

import java.util.List;

@Mapper
public interface UserDAO {
    public List<UserVO> selectAllUserList() throws DataAccessException;
    public UserVO selectUserById(String userId) throws DataAccessException;
    public UserVO selectUserByEmail(String email) throws DataAccessException;

    public int insertUser(UserVO userVO) throws DataAccessException;
    public int updateUser(UserVO userVO) throws DataAccessException;

    public int countUserById(String userId) throws DataAccessException;
    public int countUserByEmail(String email) throws DataAccessException;
}