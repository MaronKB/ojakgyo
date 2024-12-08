package fs.four.devgang.ojakgyo.admin.repository;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.dao.DataAccessException;

import java.util.List;

@Mapper
public interface AdminDAO {

    /**
     * 코드 그룹 관리 조회
     * @return
     * @throws DataAccessException
     */
    public List selectAllUserList() throws DataAccessException;
}
