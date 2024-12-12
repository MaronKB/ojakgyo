package fs.four.devgang.ojakgyo.post.repository;

import fs.four.devgang.ojakgyo.post.vo.CommentVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.dao.DataAccessException;

import java.util.List;

@Mapper
public interface CommentDAO {

    public List selectAllCommentList() throws DataAccessException;
    public int insertComment(CommentVO commentVO) throws DataAccessException;
}
