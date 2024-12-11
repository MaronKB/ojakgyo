package fs.four.devgang.ojakgyo.user.service;

import fs.four.devgang.ojakgyo.user.vo.LoginVO;

public interface LoginService {
    LoginVO login(LoginVO loginVO) throws Exception;
}
