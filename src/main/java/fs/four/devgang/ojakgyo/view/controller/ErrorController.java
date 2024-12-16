package fs.four.devgang.ojakgyo.view.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/error")
public class ErrorController {
    @GetMapping("/common")
    public String common() {
        return "error/common";
    }
    @GetMapping("/401")
    public String error401() {
        return "error/401";
    }
    @GetMapping("/403")
    public String error403() {
        return "error/403";
    }
    @GetMapping("/404")
    public String error404() {
        return "error/404";
    }
    @GetMapping("/500")
    public String error500() {
        return "error/500";
    }
}
