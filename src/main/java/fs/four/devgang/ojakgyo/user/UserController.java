package fs.four.devgang.ojakgyo.user;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/user")
public class UserController {
    @RequestMapping("login")
    public String login() {
        return "login";
    }

    @RequestMapping("logout")
    public String logout() {
        return "logout";
    }
}
