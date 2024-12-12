package fs.four.devgang.ojakgyo.post.controller;

import fs.four.devgang.ojakgyo.post.vo.CommentVO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

public interface CommentController {
    public ModelAndView listComment(HttpServletRequest request, HttpServletResponse response) throws Exception;
    public ModelAndView addComment(@ModelAttribute("info") CommentVO commentVO, HttpServletRequest request, HttpServletResponse response) throws Exception;
}
