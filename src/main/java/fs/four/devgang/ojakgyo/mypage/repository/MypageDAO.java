package fs.four.devgang.ojakgyo.mypage.repository;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.dao.DataAccessException;

import java.util.List;

@Mapper
public interface MypageDAO {

    static List selectAllMypageList() {
        return List.of();
    }

    /**
     * 코드 그룹 관리 조회
     * @return
     * @throws DataAccessException
     */
    public List selectAllCodeGroupList() throws DataAccessException;
}