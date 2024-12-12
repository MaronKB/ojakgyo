package fs.four.devgang.ojakgyo.user.controller;

import fs.four.devgang.ojakgyo.user.service.UserService;

import fs.four.devgang.ojakgyo.user.vo.UserVO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.PrintWriter;

@RestController("userController")
@RequestMapping(value = "/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping(value = "/register")
    public int addMember(@RequestBody UserVO userVO) throws Exception {
        return userService.insert(userVO);
    }

    @GetMapping(value = "/check/{type}/{str}")
    public boolean checkDuplication(@PathVariable String type, @PathVariable String str) throws Exception {
        int count = userService.checkDuplication(type, str);
        return count != 0;
    }
}