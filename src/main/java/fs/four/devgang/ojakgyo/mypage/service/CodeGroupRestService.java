package fs.four.devgang.ojakgyo.mypage.service;

import fs.four.devgang.ojakgyo.mypage.dao.CodeGroupDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CodeGroupRestService {

    @Autowired
    private CodeGroupDAO codeGroupDAO;

    public List listAllCodeGroup() throws Exception{

        List codeGroupList = null;
        codeGroupList = codeGroupDAO.selectAllCodeGroupList();
        return codeGroupList;
    }
}