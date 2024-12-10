package fs.four.devgang.ojakgyo.user.controller;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import fs.four.devgang.ojakgyo.user.vo.UserVO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface UserController {

    // 사용자 등록
    public ModelAndView addMember(@ModelAttribute("info") UserVO userVO,
                                  HttpServletRequest request,
                                  HttpServletResponse response) throws Exception;
    // 아이디 중복 체크
    public ModelAndView checkUserId(HttpServletRequest request, HttpServletResponse response) throws Exception;

    // 이메일 중복 체크
    public ModelAndView checkEmail(HttpServletRequest request, HttpServletResponse response) throws Exception;
}