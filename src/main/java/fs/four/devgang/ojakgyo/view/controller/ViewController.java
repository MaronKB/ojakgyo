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

    private static boolean userIsNotLoggedIn(HttpSession session) {
        JSONObject token = (JSONObject) session.getAttribute("user");
        return token == null;
    }

    private static boolean userIsNotAdmin(HttpSession session) {
        JSONObject token = (JSONObject) session.getAttribute("user");
        return token == null || !"Y".equals(token.get("isAdmin"));
    }

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

    @GetMapping("/register/result")
    public String registerResult() {
        return "user/register/result";
    }

    /*
    @GetMapping("/mypage")
    public String myPage(HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (userIsNotLoggedIn(session)) return "redirect:/error/401";
        return "user/mypage";
    }

     */

    @GetMapping("/find_password")
    public String findPassword() {
        return "user/find_password";
    }

    // main

    @GetMapping("/main")
    public String mainForm(HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (userIsNotLoggedIn(session)) return "redirect:/login";
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
    public ModelAndView communityView(@PathVariable int postId, HttpServletRequest request) throws Exception {
        HttpSession session = request.getSession();
        JSONObject user = (JSONObject) session.getAttribute("user");
        String userId = user == null ? null : user.get("userId").toString();

        JSONObject post = postService.selectPostById(postId);
        JSONArray comments = commentService.selectCommentListByPostId(postId);
        ModelAndView mav = new ModelAndView("community/view");
        mav.addObject("post", post);
        mav.addObject("comments", comments);
        mav.addObject("isOwner", (postService.isPostOwner(postId, userId) || !userIsNotAdmin(session)));
        return mav;
    }

    @GetMapping("/community/edit/{postId}")
    public ModelAndView communityEdit(@PathVariable int postId, HttpServletRequest request) throws Exception {
        HttpSession session = request.getSession();
        if (userIsNotLoggedIn(session)) return new ModelAndView("error/401");
        if (postService.isPostOwner(postId, session.getAttribute("user").toString()) || !userIsNotAdmin(session)) {
            ModelAndView mav = new ModelAndView("community/edit");
            mav.addObject("post", postService.selectPostById(postId));
            return mav;
        } else {
            return new ModelAndView("error/403");
        }
    }

    // hotplace

    /*
    @GetMapping("/hotplace")
    public String hotPlace() {
        return "hotplace/hotplace";
    }
    */

    // admin

    @GetMapping("/admin/ads")
    public String ads(HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (userIsNotLoggedIn(session)) return "redirect:/error/401";
        if (userIsNotAdmin(session)) return "redirect:/error/403";
        return "admin/ads";
    }
    /*
    @GetMapping("/admin/users")
    public String users() {
        return "listUser";
    }
    */
    @GetMapping("/admin/reports")
    public String reports(HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (userIsNotLoggedIn(session)) return "redirect:/error/401";
        if (userIsNotAdmin(session)) return "redirect:/error/403";
        return "admin/reports";
    }
}