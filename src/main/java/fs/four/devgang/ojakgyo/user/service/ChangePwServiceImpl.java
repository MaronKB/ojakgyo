package fs.four.devgang.ojakgyo.user.service;

import fs.four.devgang.ojakgyo.user.repository.ChangePwDAO;
import fs.four.devgang.ojakgyo.user.vo.ChangePwVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChangePwServiceImpl implements ChangePwService {

    @Autowired
    private ChangePwDAO changePwDAO;

    @Override
    public boolean changePassword(ChangePwVO changePwVO) {
        int result = changePwDAO.updatePassword(changePwVO);
        return result > 0; // 성공 여부 반환
    }
}
