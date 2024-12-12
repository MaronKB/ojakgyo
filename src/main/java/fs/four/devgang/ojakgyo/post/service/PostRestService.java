package fs.four.devgang.ojakgyo.post.service;

import fs.four.devgang.ojakgyo.post.repository.PostDAO;
import fs.four.devgang.ojakgyo.post.vo.PostVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PostRestService {

    @Autowired
    private PostDAO postDAO;


    public List listAllPost() throws Exception {

        List postList = null;
        postList =postDAO.selectAllPostList();
        return postList;
    }

//    게시글 카테고리 탭
    public List<PostVO> listPostByCategory(String category) throws Exception {
        return postDAO.selectPostByCategory(category);
    }

//    게시글 조회수 증가
    public void increasePostViewCount(int postId) throws Exception {
        postDAO.updatePostViewCount(postId);
    }

    public PostVO getPostById(int postId) throws Exception {
        return postDAO.selectPostById(postId);
    }


}
