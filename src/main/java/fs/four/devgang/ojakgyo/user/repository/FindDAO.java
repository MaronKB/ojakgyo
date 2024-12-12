package fs.four.devgang.ojakgyo.user.repository;

import fs.four.devgang.ojakgyo.user.vo.FindVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class FindDAO {

    @Autowired
    private SqlSession sqlSession;

    public FindVO findPassword(FindVO findVO) {
        // MyBatis XML에서 매핑된 쿼리 호출
        return sqlSession.selectOne("FindMapper.findEmail", findVO);
    }
}
