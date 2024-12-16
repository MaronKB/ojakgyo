package fs.four.devgang.ojakgyo.admin.repository;

import fs.four.devgang.ojakgyo.admin.vo.AdminVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
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

//    검색 기능
    public List<AdminVO> searchUsers(@Param("category") String category, @Param("keyword") String keyword) throws DataAccessException;

//    삭제
    public void softDeleteUsers(@Param("userIds") List<String> userIds) throws DataAccessException;

//    수정 기능
    public void updateUser(AdminVO adminVO) throws DataAccessException;

}
