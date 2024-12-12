package fs.four.devgang.ojakgyo.view.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@Controller
public class ViewController {

    // index

    @GetMapping("/")
    public String index() {
        System.out.println("index");
        return "index/main";
    }

    // user

    @GetMapping("/login")
    public String login() {
        System.out.println("login");
        return "user/login";
    }

    @GetMapping("/register")
    public String register() {
        System.out.println("register");
        return "user/register/main";
    }

    @GetMapping("/mypage")
    public String myPage() {
        System.out.println("mypage");
        return "user/mypage";
    }

    @GetMapping("/find_password")
    public String findPassword() {
        System.out.println("find_password");
        return "user/find_password";
    }

    // main

    @GetMapping("/main")
    public String mainForm(@CookieValue(value = "token", required = false) String token, @RequestHeader(value = "User-Agent", required = false) String userAgent) {
        // 로그인 토큰이 존재하지 않을 경우 로그인 페이지로 리디렉션
        /*
        if (token != null) {
            System.out.println("token: " + token);
        } else {
            return "redirect:/login";
        }
        */

        System.out.println("main");
        return "main/form/main";
    }

    // community

    @GetMapping("/community")
    public String community() {
        System.out.println("community");
        return "listPost";
    }

    @GetMapping("/community/new")
    public String communityNew() {
        System.out.println("community/new");
        return "community/new";
    }

    @GetMapping("/community/view")
    public String communityView() {
        System.out.println("community/view");
        return "community/view";
    }

    @GetMapping("/community/edit")
    public String communityEdit() {
        System.out.println("community/edit");
        return "community/edit";
    }

    // hotplace

    @GetMapping("/hotplace")
    public String hotPlace() {
        System.out.println("hotplace");
        return "hotplace/hotplace";
    }

    // admin

    @GetMapping("/admin/ads")
    public String ads() {
        System.out.println("ads");
        return "admin/ads";
    }
    @GetMapping("/admin/users")
    public String users() {
        System.out.println("user");
        return "listUser";
    }

    @GetMapping("/admin/reports")
    public String reports() {
        System.out.println("reports");
        return "admin/reports";
    }
}