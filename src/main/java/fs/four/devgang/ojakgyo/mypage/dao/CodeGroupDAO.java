package fs.four.devgang.ojakgyo.mypage.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;
import org.springframework.dao.DataAccessException;

import java.util.List;

@Mapper
public interface CodeGroupDAO {

    /**
     * 코드 그룹 관리 조회
     */
    public List selectAllCodeGroupList() throws DataAccessException;

    // 닉네임 수정
    @Update("UPDATE users SET user_nickname = #{user_nickname} WHERE user_id = #{user_id}")
    public int updateNickname(String codeGroupVO) throws DataAccessException;
}
