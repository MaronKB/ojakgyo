package fs.four.devgang.ojakgyo.post.repository;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.dao.DataAccessException;

import java.util.List;

@Mapper
public interface PostDAO {

    /**
     * 코드 그룹 관리 조회
     * @return
     * @throws DataAccessException
     */
    public List selectAllPostList() throws DataAccessException;
}
