package fs.four.devgang.ojakgyo.post.service;

import fs.four.devgang.ojakgyo.post.vo.PostVO;

import java.util.List;

public interface PostService {

//    게시글 리스트
    public List listPost() throws Exception;

//    게시글 작성
    public int addPost(PostVO postVO) throws Exception;

//    게시글 조회
    PostVO getPostById(int postId) throws Exception;

}