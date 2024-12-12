package fs.four.devgang.ojakgyo.mypage.service;

import fs.four.devgang.ojakgyo.mypage.dao.MypageDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("MypageService")
@Transactional(propagation = Propagation.REQUIRED)
public class MypageServiceImpl implements MypageService {

    @Autowired
    private MypageDAO mypageDAO;

    @Override
    public List listCodeGroup() throws Exception {
        List codeGroupList = null;
        codeGroupList = mypageDAO.selectAllCodeGroupList();
        return codeGroupList;
    }
}
