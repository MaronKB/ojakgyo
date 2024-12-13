package fs.four.devgang.ojakgyo.view.controller;

import fs.four.devgang.ojakgyo.post.service.CommentService;
import fs.four.devgang.ojakgyo.post.service.PostService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ViewController {

    @Autowired
    private PostService postService;

    @Autowired
    private CommentService commentService;

    // index

    @GetMapping("/")
    public String index() {
        return "index/main";
    }

    // user

    @GetMapping("/login")
    public String login() {
        return "user/login";
    }

    @GetMapping("/register")
    public String register() {
        return "user/register/main";
    }

    @GetMapping("/mypage")
    public String myPage() {
        return "user/mypage";
    }

    @GetMapping("/find_password")
    public String findPassword() {
        return "user/find_password";
    }

    // main

    @GetMapping("/main")
    public String mainForm(HttpServletRequest request) {
        // 로그인 토큰이 존재하지 않을 경우 로그인 페이지로 리디렉션
        HttpSession session = request.getSession();
        String token = (String) session.getAttribute("user");

        if (token != null) {
            System.out.println("token: " + token);
        } else {
            return "redirect:/login";
        }
        return "main/form/main";
    }

    // community

    @GetMapping("/community")
    public String community() {
        return "community/list";
    }

    @GetMapping("/community/new")
    public String communityNew() {
        return "community/new";
    }

    @GetMapping("/community/v/{postId}")
    public ModelAndView communityView(@PathVariable int postId) throws Exception {
        JSONObject post = postService.selectPostById(postId);
        JSONArray comments = commentService.selectCommentByPostId(postId);
        ModelAndView mav = new ModelAndView("community/view");
        mav.addObject("post", post);
        mav.addObject("comments", comments);
        return mav;
    }

    @GetMapping("/community/edit")
    public String communityEdit() {
        return "community/edit";
    }

    // hotplace

    @GetMapping("/hotplace")
    public String hotPlace() {
        return "hotplace/hotplace";
    }

    // admin

    @GetMapping("/admin/ads")
    public String ads() {
        return "admin/ads";
    }
    /*
    @GetMapping("/admin/users")
    public String users() {
        return "listUser";
    }
    */
    @GetMapping("/admin/reports")
    public String reports() {
        return "admin/reports";
    }
}