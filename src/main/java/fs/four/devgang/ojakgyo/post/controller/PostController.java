package fs.four.devgang.ojakgyo.post.controller;

import fs.four.devgang.ojakgyo.post.vo.PostVO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

public interface PostController {
//    게시글 리스트
    public ModelAndView listPost(HttpServletRequest request, HttpServletResponse response) throws Exception;
    public ModelAndView postPage(HttpServletRequest request, HttpServletResponse response) throws Exception;

//    게시글 작성
    public ModelAndView addPost(@ModelAttribute("info") PostVO postVO, HttpServletRequest request, HttpServletResponse response) throws Exception;

//    게시글 조회
    public ModelAndView viewPost(HttpServletRequest request, HttpServletResponse response) throws Exception;

}