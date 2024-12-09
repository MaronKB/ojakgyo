package fs.four.devgang.ojakgyo.post.service;

import fs.four.devgang.ojakgyo.post.vo.PostVO;

import java.util.List;

public interface PostService {

    public List listPost() throws Exception;
    public int addPost(PostVO postVO) throws Exception;
}