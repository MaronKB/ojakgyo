package fs.four.devgang.ojakgyo.user.service;

import fs.four.devgang.ojakgyo.user.repository.FindDAO;
import fs.four.devgang.ojakgyo.user.vo.FindVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FindServiceImpl implements FindService {

    @Autowired
    private FindDAO findDAO;

    @Override
    public boolean findPassword(FindVO findVO) throws Exception {
        findVO.setEmail(findVO.getEmail().trim()); // 입력 값 트리밍
        FindVO result = findDAO.findPassword(findVO); // DAO 호출
        return result != null; // 조회 결과가 존재하면 true
    }
}
