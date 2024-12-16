package fs.four.devgang.ojakgyo.user.controller;

import fs.four.devgang.ojakgyo.user.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController("mypageController")
public class MypageController {

    @Autowired
    private UserService userService;

    @GetMapping("/mypage")
    public ModelAndView mypage(HttpServletRequest request) throws Exception {
        HttpSession session = request.getSession();
        JSONObject user = (JSONObject) session.getAttribute("user");
        String userId = (String) user.get("userId");
        JSONObject userData = userService.selectUserById(userId);

        ModelAndView mav = new ModelAndView("/user/mypage");
        mav.addObject("user", userData);
        return mav;
    }

    @GetMapping("/mypage/{userId}")
    public ModelAndView mypage(@PathVariable String userId) throws Exception {
        JSONObject userData = userService.selectUserById(userId);

        ModelAndView mav = new ModelAndView("/user/mypage");
        mav.addObject("user", userData);
        return mav;
    }
}

