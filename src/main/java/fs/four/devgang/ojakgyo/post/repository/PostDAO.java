package fs.four.devgang.ojakgyo.post.repository;

import fs.four.devgang.ojakgyo.post.vo.PostVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.dao.DataAccessException;

import java.util.List;

@Mapper
public interface PostDAO {
    public PostVO selectPostById(int postId) throws DataAccessException;

    public List<PostVO> selectAllPostList() throws DataAccessException;

    public List<PostVO> selectPostByCategory(String category);

    public int insertPost(PostVO postVO) throws DataAccessException ;

    public void updatePostViewCount(int postId) throws DataAccessException;

}
