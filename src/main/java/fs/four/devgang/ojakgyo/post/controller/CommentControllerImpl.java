package fs.four.devgang.ojakgyo.post.controller;

import fs.four.devgang.ojakgyo.post.service.CommentService;
import fs.four.devgang.ojakgyo.post.vo.CommentVO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller("commentController")
public class CommentControllerImpl implements CommentController{

    @Autowired
    private CommentService commentService;

    @Autowired
    private CommentVO commentVO;

    @Override
    @RequestMapping(value= "/post/listComment", method = RequestMethod.GET)
    public ModelAndView listComment(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List commentList = commentService.listComment();
        ModelAndView mav = new ModelAndView("/community/view");
        mav.addObject("commentList", commentList);
        return mav;
    }

    @Override
    @RequestMapping(value="/post/addComment.do" ,method = RequestMethod.POST)
    public ModelAndView addComment(@ModelAttribute("comment") CommentVO comment,
                                  HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.setCharacterEncoding("utf-8");
        int result = 0;
        result = commentService.addComment(comment);
        ModelAndView mav = new ModelAndView("redirect:/post/listComment");
        return mav;
    }
}
