package fs.four.devgang.ojakgyo.user.controller;

import fs.four.devgang.ojakgyo.user.service.LoginService;
import fs.four.devgang.ojakgyo.user.vo.LoginVO;
import fs.four.devgang.ojakgyo.user.vo.UserVO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class LoginControllerImpl implements LoginController {

    private static final Logger logger = LoggerFactory.getLogger(LoginControllerImpl.class);

    @Autowired
    private LoginService loginService;

    @Override
    @RequestMapping(value = "/login.do", method = RequestMethod.POST)
    public ModelAndView login(HttpServletRequest request, HttpServletResponse response) throws Exception {
        logger.info("로그인 요청 시작");

        // 사용자 입력 값 가져오기
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        LoginVO loginVO = new LoginVO(username, password);
        logger.info("로그인 정보: {}", loginVO);

        ModelAndView mav = new ModelAndView();

        try {
            UserVO user = loginService.login(loginVO);

            if (user != null) {
                logger.info("로그인 성공: {}", user);
                request.getSession().setAttribute("user", user);
                mav.setViewName("index/main"); // 성공 시 메인 페이지로 이동
            } else {
                logger.warn("로그인 실패: 사용자 정보 없음");
                mav.setViewName("user/login");
                mav.addObject("error", "아이디 또는 비밀번호가 일치하지 않습니다.");
            }
        } catch (Exception e) {
            logger.error("로그인 처리 중 오류 발생", e);
            mav.setViewName("error");
            mav.addObject("errorMessage", "시스템 오류가 발생했습니다. 잠시 후 다시 시도해주세요.");
        }

        return mav;
    }

    @Override
    @RequestMapping(value = "/logout.do", method = RequestMethod.GET)
    public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) throws Exception {
        logger.info("로그아웃 요청 시작");

        request.getSession().invalidate();

        ModelAndView mav = new ModelAndView("redirect:/login.do");
        logger.info("로그아웃 완료");
        return mav;
    }
}
