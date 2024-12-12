package fs.four.devgang.ojakgyo.deprecated;

import fs.four.devgang.ojakgyo.user.repository.LoginDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("loginService")
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginDAO loginDAO;

    @Override
    public LoginVO login(LoginVO loginVO) throws Exception {
        // DAO에서 LoginVO를 반환하도록 호출
        return loginDAO.login(loginVO);
    }
}
