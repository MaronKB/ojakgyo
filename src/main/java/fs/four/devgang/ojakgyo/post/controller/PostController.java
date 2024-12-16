package fs.four.devgang.ojakgyo.post.controller;

import fs.four.devgang.ojakgyo.post.service.CommentService;
import fs.four.devgang.ojakgyo.post.service.PostService;
import fs.four.devgang.ojakgyo.post.vo.PostVO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController("postController")
@RequestMapping("/api/post")
public class PostController {

    @Autowired
    private PostService postService;

    @Autowired
    private CommentService commentService;

    private static final JSONParser parser = new JSONParser();

    @GetMapping("/list")
    public String listPost(HttpServletRequest request) throws Exception {
        int page = Integer.parseInt(request.getParameter("page"));
        if (page < 1) page = 1;
        return postService.selectAllPostList(page).toJSONString();
    }

    @GetMapping("/list/{category}")
    public String listPost(@PathVariable String category, HttpServletRequest request) throws Exception {
        int page = Integer.parseInt(request.getParameter("page"));
        String searchType = request.getParameter("searchType");
        String searchKeyword = request.getParameter("searchKeyword");

        if (category == null) category = "전체";
        if (page < 1) page = 1;

        if (searchType != null && searchKeyword != null) {
            return postService.searchPostListByCategory(category, searchType, searchKeyword, page).toJSONString();
        }
        return postService.selectPostListByCategory(category, page).toJSONString();
    }

    @GetMapping("/id/{userId}")
    public String listPostByUserId(@PathVariable String userId, HttpServletRequest request) throws Exception {
        int page = Integer.parseInt(request.getParameter("page"));
        if (page < 1) page = 1;

        return postService.selectPostListByUserId(userId, page).toJSONString();
    }

    @GetMapping("/reported/{category}")
    public String listReportedPost(@PathVariable String category, HttpServletRequest request) throws Exception {
        int page = Integer.parseInt(request.getParameter("page"));
        if (category == null) category = "전체";
        if (page < 1) page = 1;

        return postService.selectReportedPostListByCategory(category, page).toJSONString();
    }

    @GetMapping("/id/{postId}")
    public String viewPost(@PathVariable int postId) throws Exception {
        postService.increasePostViewCount(postId);
        return postService.selectPostById(postId).toJSONString();
    }

    @PostMapping("/add")
    public int addPost(@RequestBody String body, HttpServletRequest request) throws Exception {
        HttpSession session = request.getSession();
        JSONObject user = (JSONObject) session.getAttribute("user");
        if (user == null) return -1;

        JSONObject jsonObject = (JSONObject) parser.parse(body);
        PostVO post = new PostVO();
        post.setPost_title(jsonObject.get("title").toString());
        post.setPost_content(jsonObject.get("content").toString());
        post.setPost_category(jsonObject.get("category").toString());
        post.setPost_author_id(user.get("userId").toString());
        post.setPost_author_nickname(user.get("nickname").toString());

        return postService.addPost(post);
    }

    @PatchMapping("/edit/{postId}")
    public int editPost(@PathVariable int postId, @RequestBody String body, HttpServletRequest request) throws Exception {
        HttpSession session = request.getSession();
        JSONObject user = (JSONObject) session.getAttribute("user");
        if (user == null) return -1;

        JSONObject jsonObject = (JSONObject) parser.parse(body);
        PostVO post = new PostVO();
        post.setPost_id(postId);
        post.setPost_title(jsonObject.get("title").toString());
        post.setPost_content(jsonObject.get("content").toString());
        post.setPost_category(jsonObject.get("category").toString());
        post.setPost_author_id(user.get("userId").toString());
        post.setPost_author_nickname(user.get("nickname").toString());

        return postService.updatePost(post);
    }

    @DeleteMapping("/delete/{postId}")
    public int deletePost(@PathVariable int postId) throws Exception {
        return postService.deletePost(postId);
    }

    @PostMapping("/report/{postId}")
    public int reportPost(@PathVariable int postId) throws Exception {
        return postService.reportPost(postId);
    }
}
