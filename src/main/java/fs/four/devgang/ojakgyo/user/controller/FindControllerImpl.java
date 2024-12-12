package fs.four.devgang.ojakgyo.user.controller;

import fs.four.devgang.ojakgyo.user.service.FindService;
import fs.four.devgang.ojakgyo.user.vo.FindVO;
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
public class FindControllerImpl implements FindController {

    private static final Logger logger = LoggerFactory.getLogger(FindControllerImpl.class);

    @Autowired
    private FindService findService;

    @Override
    @RequestMapping(value = "/find_password.do", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView findPassword(HttpServletRequest request, HttpServletResponse response) throws Exception {
        logger.info("비밀번호 찾기 요청 시작");

        ModelAndView mav = new ModelAndView();

        if ("GET".equalsIgnoreCase(request.getMethod())) {
            logger.info("GET 요청으로 비밀번호 찾기 폼 반환");
            mav.setViewName("user/find_password");
            return mav;
        }

        String email = request.getParameter("email"); // 사용자 입력값 가져오기
        logger.info("Request parameter email: {}", email);

        FindVO findVO = new FindVO();
        findVO.setEmail(email);

        try {
            boolean emailExists = findService.findPassword(findVO);

            if (emailExists) {
                logger.info("비밀번호 찾기 성공");
                mav.addObject("message", "입력하신 이메일이 존재합니다.");
                mav.setViewName("user/find_password");
            } else {
                logger.warn("비밀번호 찾기 실패: 이메일 없음");
                mav.addObject("message", "입력하신 이메일을 찾을 수 없습니다.");
                mav.setViewName("user/find_password");
            }
        } catch (Exception e) {
            logger.error("비밀번호 찾기 처리 중 오류 발생", e);
            mav.setViewName("error");
            mav.addObject("errorMessage", "시스템 오류가 발생했습니다. 잠시 후 다시 시도해주세요.");
        }

        return mav;
    }
}
