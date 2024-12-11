package fs.four.devgang.ojakgyo.user.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;

public interface LoginController {
    ModelAndView login(HttpServletRequest request, HttpServletResponse response) throws Exception;
    ModelAndView logout(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
