package fs.four.devgang.ojakgyo.post.service;

import fs.four.devgang.ojakgyo.post.vo.CommentVO;

import java.util.List;

public interface CommentService {

    public List listComment() throws Exception;
    public int addComment(CommentVO commentVO) throws Exception;
}
