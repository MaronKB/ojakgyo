package fs.four.devgang.ojakgyo.post.controller;

import fs.four.devgang.ojakgyo.post.service.PostService;
import fs.four.devgang.ojakgyo.post.vo.PostVO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller("postController")
public class PostControllerImpl implements PostController {

    @Autowired
    private PostService postService;

    @Autowired
    private PostVO postVO;

    @Override
    @GetMapping("/post/listPost.do")
    public ModelAndView listPost(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("============================");
        List postList = postService.listPost();
        ModelAndView mav = new ModelAndView("/community/listPost");
        mav.addObject("postList", postList);
        System.out.println("postList"+postList.size());
        return mav;
    }

    @Override
    @GetMapping("/post/post.do")
    public ModelAndView postPage(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mav = new ModelAndView("/post/post");
        return mav;
    }
}
