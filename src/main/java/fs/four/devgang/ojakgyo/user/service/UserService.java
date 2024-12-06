package fs.four.devgang.ojakgyo.user.service;

import fs.four.devgang.ojakgyo.user.entity.User;
import fs.four.devgang.ojakgyo.user.repository.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserDAO userDAO;

    // 회원가입 처리
    public boolean registerUser(User user) {
        // 중복 아이디 체크
        if (userDAO.checkDuplicateUserId(user.getUserId())) {
            return false; // 중복된 아이디가 있으면 false 리턴
        }
        // 사용자 저장
        return userDAO.save(user); // 사용자 저장 후 성공 여부 리턴
    }
}