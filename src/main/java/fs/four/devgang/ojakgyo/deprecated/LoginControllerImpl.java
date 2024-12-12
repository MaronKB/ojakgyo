package fs.four.devgang.ojakgyo.deprecated;

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
    @RequestMapping(value = "/user/login.do", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView login(HttpServletRequest request, HttpServletResponse response) throws Exception {
        logger.info("로그인 요청 시작");

        ModelAndView mav = new ModelAndView();

        if ("GET".equalsIgnoreCase(request.getMethod())) {
            logger.info("GET 요청으로 로그인 폼 반환");
            mav.setViewName("user/login");
            return mav;
        }

        // 사용자 입력 값 가져오기
        String userid = request.getParameter("userid");
        String password = request.getParameter("password");

        logger.info("Request parameter userid: {}", userid);
        logger.info("Request parameter password: {}", password);

        // LoginVO 객체 생성
        LoginVO loginVO = new LoginVO();
        loginVO.setUserid(userid);
        loginVO.setPassword(password);

        logger.info("로그인 정보: {}", loginVO);

        try {
            // 로그인 처리
            LoginVO loggedInUser = loginService.login(loginVO);

            if (loggedInUser != null) {
                logger.info("로그인 성공: {}", loggedInUser);
                request.getSession().setAttribute("user", loggedInUser); // LoginVO를 세션에 저장

                // 관리자인지 확인
                if ("Y".equals(loggedInUser.getIsAdmin())) {
                    logger.info("관리자 로그인");
                    // 관리자 페이지로 리다이렉트 등의 처리를 할 수 있습니다.
                }

                mav.setViewName("redirect:/"); // 성공 시 메인 페이지로 이동
            } else {
                logger.warn("로그인 실패: 사용자 정보 없음");
                mav.setViewName("redirect:/login");
                mav.addObject("error", "아이디 또는 비밀번호가 일치하지 않습니다.");
            }
        } catch (Exception e) {
            logger.error("로그인 처리 중 오류 발생", e);
            mav.setViewName("error");
            mav.addObject("errorMessage", "시스템 오류가 발생했습니다. 잠시 후 다시 시도해주세요.");
        }

        return mav;
    }

    // 로그아웃 처리 메서드 추가
    @Override
    @RequestMapping(value = "/logout.do", method = RequestMethod.GET)
    public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) throws Exception {
        logger.info("로그아웃 요청 시작");

        // 세션 무효화
        request.getSession().invalidate();

        ModelAndView mav = new ModelAndView("redirect:/login.do"); // 로그아웃 후 로그인 페이지로 리다이렉트
        logger.info("로그아웃 완료");

        return mav;
    }
}