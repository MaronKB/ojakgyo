package fs.four.devgang.ojakgyo.user.controller;

import fs.four.devgang.ojakgyo.user.service.UserService;

import fs.four.devgang.ojakgyo.user.vo.UserVO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller("userController")
public class UserControllerImpl implements UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserControllerImpl.class);

    @Autowired
    private UserService userService;

    @Override
    @RequestMapping(value = "/user/register.do", method = RequestMethod.POST)
    public ModelAndView addMember(@ModelAttribute("user") UserVO user,
                                  HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.setCharacterEncoding("utf-8");

        logger.info("addMember 호출됨");
        logger.info("입력된 사용자 정보: {}", user);

        int result = userService.addMember(user);
        logger.info("회원 등록 결과: {}", result > 0 ? "성공" : "실패");

        String success = result > 0 ? "true" : "false";
        ModelAndView mav = new ModelAndView("redirect:/register?success=" + success);
        return mav;
    }
        @Override
        @RequestMapping(value = "/user/checkUserId.do", method = RequestMethod.POST)
        public ModelAndView checkUserId(HttpServletRequest request, HttpServletResponse response) throws Exception {
            String userId = request.getParameter("userId");
            logger.info("아이디 중복 체크: {}", userId);

            int count = userService.checkUserId(userId);
            ModelAndView mav = new ModelAndView("jsonView");
            mav.addObject("result", count == 0 ? "available" : "unavailable");
            return mav;
        }
        @Override
        @RequestMapping(value = "/user/checkEmail.do", method = RequestMethod.POST)
        public ModelAndView checkEmail(HttpServletRequest request, HttpServletResponse response) throws Exception {
            String email = request.getParameter("email");
            logger.info("이메일 중복 체크: {}", email);

            int count = userService.checkEmail(email);
            ModelAndView mav = new ModelAndView("jsonView");
            mav.addObject("result", count == 0 ? "available" : "unavailable");
            return mav;
        }
}