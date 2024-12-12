package fs.four.devgang.ojakgyo.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fs.four.devgang.ojakgyo.user.repository.UserDAO;
import fs.four.devgang.ojakgyo.user.vo.UserVO;

@Service("userService")
public class UserService {

    @Autowired
    private UserDAO userDAO;

    public int insert(UserVO userVO) throws Exception {
        return userDAO.insertUser(userVO);
    }

    public int checkDuplication(String type, String str) throws Exception {
        if (type.equals("id")) {
            return userDAO.countUserById(str);
        } else if (type.equals("email")) {
            return userDAO.countUserByEmail(str);
        } else {
            return 0;
        }
    }

    public int checkUserId(String type, String userId) throws Exception {

        return userDAO.countUserById(userId);
    }

    public int checkEmail(String email) throws Exception {
        return userDAO.countUserByEmail(email);
    }
}