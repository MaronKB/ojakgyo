package fs.four.devgang.ojakgyo.user.service;

import fs.four.devgang.ojakgyo.user.vo.UserVO;

public interface UserService {
    // 사용자 등록 메서드
    public int addMember(UserVO userVO) throws Exception;


}