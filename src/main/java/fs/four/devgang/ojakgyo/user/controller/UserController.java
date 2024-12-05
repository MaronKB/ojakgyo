package fs.four.devgang.ojakgyo.user.controller;

import fs.four.devgang.ojakgyo.user.entity.User;
import fs.four.devgang.ojakgyo.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, Model model) {
        if (userService.validateUser(username, password)) {
            return "redirect:/main";
        } else {
            model.addAttribute("error", "아이디 또는 비밀번호가 잘못되었습니다.");
            return "user/login";
        }
    }

    @PostMapping("/register")
    public String register(@RequestParam String username, @RequestParam String password, @RequestParam String email) {
        userService.registerUser(new User(username, password, email));
        return "redirect:/login";
    }

    @PostMapping("/find_password")
    public String findPassword(@RequestParam String email, Model model) {
        return userService.findPasswordByEmail(email)
                .map(password -> {
                    model.addAttribute("message", "비밀번호는: " + password);
                    return "user/find_password";
                })
                .orElseGet(() -> {
                    model.addAttribute("error", "등록되지 않은 이메일입니다.");
                    return "user/find_password";
                });
    }
}