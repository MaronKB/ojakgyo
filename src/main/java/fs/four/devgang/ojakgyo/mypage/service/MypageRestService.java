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
    private MypageDAO mypageDAO;

    public List listAllCodeGroup() throws Exception{

        List codeGroupList = null;
        codeGroupList = mypageDAO.selectAllCodeGroupList();
        return codeGroupList;
    }
}