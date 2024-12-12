package fs.four.devgang.ojakgyo.user.controller;

import fs.four.devgang.ojakgyo.user.service.UserService;
import fs.four.devgang.ojakgyo.user.vo.UserVO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController("userController")
@RequestMapping(value = "/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping(value = "/register")
    public int register(@RequestBody UserVO userVO) throws Exception {
        System.out.println(userVO.getUser_id());
        return userService.insertUser(userVO);
    }

    @PostMapping(value = "/login")
    public String login(@RequestBody JSONObject jsonObject, HttpServletRequest request) throws Exception {
        JSONObject user = userService.login(jsonObject);

        if (user.get("status").equals(200)) {
            HttpSession session = request.getSession();
            session.setAttribute("user", user.get("token"));
        }
        return user.toJSONString();
    }

    @GetMapping(value = "/logout")
    public String logout(HttpServletRequest request) {
        try {
            HttpSession session = request.getSession();
            session.invalidate();
            return "success";
        } catch (Exception e) {
            return "fail";
        }
    }

    @GetMapping(value = "/check/{type}/{str}")
    public boolean checkDuplication(@PathVariable String type, @PathVariable String str) throws Exception {
        int count = userService.checkDuplication(type, str);
        return count != 0;
    }
}