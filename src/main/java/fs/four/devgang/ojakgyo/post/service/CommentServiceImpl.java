package fs.four.devgang.ojakgyo.post.service;

import fs.four.devgang.ojakgyo.post.repository.CommentDAO;
import fs.four.devgang.ojakgyo.post.vo.CommentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("commentService")
@Transactional(propagation = Propagation.REQUIRED)
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentDAO commentDAO;

    @Override
    public List listComment() throws Exception {
        List commentList = null;
        commentList = commentDAO.selectAllCommentList();
        return commentList;
    }

    @Override
    public int addComment(CommentVO comment) throws Exception {
        return commentDAO.insertComment(comment);
    }

    @Override
    public List<CommentVO> listCommentByPostId(int postId) throws Exception {
        return commentDAO.selectCommentsByPostId(postId);
    }

}