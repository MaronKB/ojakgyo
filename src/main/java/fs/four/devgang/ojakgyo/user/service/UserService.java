package fs.four.devgang.ojakgyo.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fs.four.devgang.ojakgyo.user.repository.UserDAO;
import fs.four.devgang.ojakgyo.user.vo.UserVO;

@Service("userService")
public class UserService {

    @Autowired
    private UserDAO userDAO;

    public int addMember(UserVO userVO) throws Exception {
        // 사용자 등록 처리
        return userDAO.insertMember(userVO);
    }

    public int checkDuplication(String type, String str) throws Exception {
        if (type.equals("id")) {
            return userDAO.selectUserId(str);
        } else if (type.equals("email")) {
            return userDAO.selectEmail(str);
        } else {
            return 0;
        }
    }

    public int checkUserId(String type, String userId) throws Exception {

        return userDAO.selectUserId(userId);
    }

    public int checkEmail(String email) throws Exception {
        return userDAO.selectEmail(email);
    }
}