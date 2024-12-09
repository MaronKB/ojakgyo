package fs.four.devgang.ojakgyo.mypage.code.service;

import fs.four.devgang.ojakgyo.mypage.code.dao.CodeGroupDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("codeGroupService")
@Transactional(propagation = Propagation.REQUIRED)
public class CodeGroupServiceImpl implements CodeGroupService {

    @Autowired
    private CodeGroupDAO codeGroupDAO;

    @Override
    public List listCodeGroup() throws Exception {
        List codeGroupList = null;
        codeGroupList = codeGroupDAO.selectAllCodeGroupList();
        return codeGroupList;
    }
}
