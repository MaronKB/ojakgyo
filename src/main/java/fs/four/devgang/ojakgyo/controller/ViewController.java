package fs.four.devgang.ojakgyo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {

    // index

    @GetMapping("/")
    public String index() {
        System.out.println("index");
        return "index";
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
        return "user/register";
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
    public String mainForm() {
        System.out.println("main");
        return "main/form";
    }

    @GetMapping("main/result")
    public String result() {
        System.out.println("result");
        return "main/result";
    }

    // community

    @GetMapping("/community")
    public String community() {
        System.out.println("community");
        return "community/main";
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

    @GetMapping("/admin/ad")
    public String ads() {
        System.out.println("ads");
        return "admin/ads";
    }

    @GetMapping("/admin/users")
    public String users() {
        System.out.println("user");
        return "admin/users";
    }

    @GetMapping("/admin/reports")
    public String reports() {
        System.out.println("reports");
        return "admin/reports";
    }
}