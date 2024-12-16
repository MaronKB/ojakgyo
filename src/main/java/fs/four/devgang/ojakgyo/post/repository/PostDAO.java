package fs.four.devgang.ojakgyo.post.repository;

import fs.four.devgang.ojakgyo.post.vo.PostVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.dao.DataAccessException;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface PostDAO {
    public PostVO selectPostById(int postId) throws DataAccessException;

    public List<PostVO> selectAllPostList() throws DataAccessException;

    public List<PostVO> selectPostListByCategory(String category);

    public List<PostVO> searchAllPostList(HashMap<String, String> param) throws DataAccessException;

    public List<PostVO> searchPostListByCategory(HashMap<String, String> param) throws DataAccessException;

    public List<PostVO> selectReportedPostListByCategory(String category) throws DataAccessException;

    public int insertPost(PostVO postVO) throws DataAccessException ;

    public int updatePost(PostVO postVO) throws DataAccessException;

    public int deletePost(int postId) throws DataAccessException;

    public void updatePostViewCount(int postId) throws DataAccessException;

    public int updatePostReported(int postId) throws DataAccessException;

}
