package fs.four.devgang.ojakgyo.post.controller;

import fs.four.devgang.ojakgyo.post.service.CommentService;
import fs.four.devgang.ojakgyo.post.vo.CommentVO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController("commentController")
@RequestMapping(value="/api/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private CommentVO commentVO;

    private static final JSONParser jsonParser = new JSONParser();

    @GetMapping(value= "/list")
    public ModelAndView listComment(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List commentList = commentService.selectAllCommentList();
        ModelAndView mav = new ModelAndView("/community/view");
        mav.addObject("commentList", commentList);
        return mav;
    }

    @PostMapping(value="/add")
    public int addComment(@RequestBody JSONObject jsonObject, HttpServletRequest request) throws Exception {
        HttpSession session = request.getSession();
        if (session.getAttribute("user") == null) {
            return -1;
        }
        JSONObject JSONObjectsession = (JSONObject) session.getAttribute("user");
        String userId = JSONObjectsession.get("userId").toString();
        String userNickname = JSONObjectsession.get("nickname").toString();
        jsonObject.put("authorId", userId);
        jsonObject.put("authorNickname", userNickname);
        return commentService.insertComment(jsonObject);
    }

    @GetMapping(value="/userId/{userId}")
    public String selectCommentListByUserId(@PathVariable String userId) throws Exception {
        return commentService.selectCommentListByUserId(userId).toJSONString();
    }
}
