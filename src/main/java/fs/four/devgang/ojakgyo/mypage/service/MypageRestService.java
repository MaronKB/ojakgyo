package fs.four.devgang.ojakgyo.mypage.service;

import fs.four.devgang.ojakgyo.mypage.dao.MypageDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MypageRestService {

    @Autowired
    private MypageDAO codeGroupDAO;

    public List listAllCodeGroup() throws Exception{

        List mypageListList = null;
        mypageListList = MypageDAO.selectAllMypageList();
        return mypageListList;
    }

    public List listAllMypage() {
        return List.of();
    }
}
