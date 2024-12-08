package fs.four.devgang.ojakgyo.admin.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;

public interface AdminController {

    public ModelAndView listUser(HttpServletRequest request, HttpServletResponse response) throws Exception;
    public ModelAndView userPage(HttpServletRequest request, HttpServletResponse response) throws Exception;
}