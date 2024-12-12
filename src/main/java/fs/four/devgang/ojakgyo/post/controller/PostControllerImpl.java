package fs.four.devgang.ojakgyo.post.controller;

import fs.four.devgang.ojakgyo.post.service.PostService;
import fs.four.devgang.ojakgyo.post.vo.PostVO;
import fs.four.devgang.ojakgyo.user.vo.LoginVO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller("postController")
public class PostControllerImpl implements PostController {

    @Autowired
    private PostService postService;

    @Autowired
    private PostVO postVO;

    @Override
    @GetMapping("/post/listPost")
    public ModelAndView listPost(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List postList = postService.listPost();
        ModelAndView mav = new ModelAndView("/community/listPost");
        mav.addObject("postList", postList);
        return mav;
    }

    @Override
    @GetMapping("/post/post.do")
    public ModelAndView postPage(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mav = new ModelAndView("/post/post");
        return mav;
    }

//    게시글 작성
    @Override
    @RequestMapping(value="/post/addPost.do" ,method = RequestMethod.POST)
    public ModelAndView addPost(@ModelAttribute("post") PostVO post,
                                  HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.setCharacterEncoding("utf-8");

        // 로그인 글 작성 연동 부분
        LoginVO loginUser = (LoginVO) request.getSession().getAttribute("user");

        if (loginUser != null) {

            post.setPost_author_id(loginUser.getUserid());
            post.setPost_author_nickname(loginUser.getUsernickname());
        }

        int result = postService.addPost(post);

        ModelAndView mav = new ModelAndView("redirect:/post/listPost");
        return mav;
    }

//    게시글 조회
    @Override
    @GetMapping("/post/view.do")
    public ModelAndView viewPost(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String postId = request.getParameter("postId");
        PostVO post = postService.getPostById(Integer.parseInt(postId));
        ModelAndView mav = new ModelAndView("/community/view");
        mav.addObject("post", post);
        return mav;
    }

}
