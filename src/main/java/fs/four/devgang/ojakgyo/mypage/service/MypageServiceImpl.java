package fs.four.devgang.ojakgyo.mypage.service;

import fs.four.devgang.ojakgyo.mypage.repository.MypageDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("codeGroupService")
@Transactional(propagation = Propagation.REQUIRED)
public class MypageServiceImpl implements MypageService {

    @Autowired
    private MypageDAO codeGroupDAO;

    @Override
    public List listMypage() throws Exception {
        return List.of();
    }
}
