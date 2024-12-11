package fs.four.devgang.ojakgyo.post.service;


import fs.four.devgang.ojakgyo.post.repository.PostDAO;
import fs.four.devgang.ojakgyo.post.vo.PostVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("postService")
@Transactional(propagation = Propagation.REQUIRED)
public class PostServiceImpl implements PostService {

    @Autowired
    private PostDAO postDAO;

    @Override
    public List listPost() throws Exception {
        List postList = null;
        postList = postDAO.selectAllPostList();
        return postList;
    }

    @Override
    public int addPost(PostVO post) throws Exception {
        return postDAO.insertPost(post);
    }

//    게시글 조회
    @Override
    public PostVO getPostById(int postId) throws Exception {
        return postDAO.selectPostById(postId);
    }

}