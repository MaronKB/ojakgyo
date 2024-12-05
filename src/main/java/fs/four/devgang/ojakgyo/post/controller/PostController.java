package fs.four.devgang.ojakgyo.post.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;

public interface PostController {

    public ModelAndView listPost(HttpServletRequest request, HttpServletResponse response) throws Exception;
    public ModelAndView postPage(HttpServletRequest request, HttpServletResponse response) throws Exception;
}