package fs.four.devgang.ojakgyo.post.controller;

import fs.four.devgang.ojakgyo.post.service.CommentService;
import fs.four.devgang.ojakgyo.post.service.PostService;
import fs.four.devgang.ojakgyo.post.vo.CommentVO;
import fs.four.devgang.ojakgyo.post.vo.PostVO;
import fs.four.devgang.ojakgyo.deprecated.LoginVO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController("postController")
@RequestMapping("/api/post")
public class PostController {

    @Autowired
    private PostService postService;

    @Autowired
    private CommentService commentService;

    @GetMapping("/list")
    public String listPost(HttpServletRequest request) throws Exception {
        int page = Integer.parseInt(request.getParameter("page"));
        if (page < 1) page = 1;
        return postService.selectAllPostList(page).toJSONString();
    }

    @GetMapping("/list/{category}")
    public String listPost(@PathVariable String category, HttpServletRequest request) throws Exception {
        int page = Integer.parseInt(request.getParameter("page"));
        if (category.equals("전체")) {
            return postService.selectAllPostList(page).toJSONString();
        } else {
            return postService.selectPostByCategory(category, page).toJSONString();
        }
    }

    @GetMapping("/id/{postId}")
    public String viewPost(@PathVariable int postId) throws Exception {
        postService.increasePostViewCount(postId);
        return postService.selectPostById(postId).toJSONString();
    }

    @RequestMapping(value="/add" ,method = RequestMethod.POST)
    public ModelAndView addPost(@ModelAttribute("post") PostVO post, HttpServletRequest request, HttpServletResponse response) throws Exception {
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
}
