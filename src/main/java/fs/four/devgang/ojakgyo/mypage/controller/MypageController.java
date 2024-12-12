package fs.four.devgang.ojakgyo.mypage.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;

public interface MypageController {

    public ModelAndView listMypage(HttpServletRequest request, HttpServletResponse response) throws Exception;
    public ModelAndView mypagePage(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
