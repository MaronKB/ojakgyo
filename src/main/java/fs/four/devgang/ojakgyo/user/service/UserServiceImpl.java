package fs.four.devgang.ojakgyo.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import fs.four.devgang.ojakgyo.user.repository.UserDAO;
import fs.four.devgang.ojakgyo.user.vo.UserVO;

@Service("userService")
@Transactional(propagation = Propagation.REQUIRED)
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public int addMember(UserVO userVO) throws Exception {
        // 사용자 등록 처리
        return userDAO.insertMember(userVO);
    }
}