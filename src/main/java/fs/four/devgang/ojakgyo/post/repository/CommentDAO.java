package fs.four.devgang.ojakgyo.post.repository;

import fs.four.devgang.ojakgyo.post.vo.CommentVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.dao.DataAccessException;

import java.util.List;

@Mapper
public interface CommentDAO {

    public List<CommentVO> selectAllCommentList() throws DataAccessException;
    public List<CommentVO> selectCommentListByPostId(int postId) throws DataAccessException;
    public List<CommentVO> selectCommentListByUserId(String userId) throws DataAccessException;

    public int insertComment(CommentVO commentVO) throws DataAccessException;


}
