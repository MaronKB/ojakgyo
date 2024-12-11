package fs.four.devgang.ojakgyo.post.repository;

import fs.four.devgang.ojakgyo.post.vo.PostVO;
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
//    게시글 리스트
    public List selectAllPostList() throws DataAccessException;

//    게시글 작성
    public int insertPost(PostVO postVO) throws DataAccessException ;

//    게시글 조회
    PostVO selectPostById(int postId) throws DataAccessException;

}
