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

    @GetMapping(value = "/register")
    public int addMember(@ModelAttribute("user") UserVO user, HttpServletRequest request) throws Exception {
        request.setCharacterEncoding("utf-8");
        return userService.addMember(user);
    }

    @GetMapping(value = "/check/{type}/{str}")
    public boolean checkDuplication(@PathVariable String type, @PathVariable String str) throws Exception {
        int count = userService.checkDuplication(type, str);
        return count == 0;
    }

    @RequestMapping(value = "/user/checkEmail.do", method = RequestMethod.POST)
    public ModelAndView checkEmail(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String email = request.getParameter("email");

        // 중복 체크 로직
        int count = userService.checkEmail(email); // 중복 체크 서비스 호출

        // JSON 형식으로 결과 반환
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        String result = (count == 0) ? "available" : "unavailable";
        out.print("{\"result\": \"" + result + "\"}");
        out.flush();
        return null;
    }
}