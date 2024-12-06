package fs.four.devgang.ojakgyo.user.controller;

import fs.four.devgang.ojakgyo.user.entity.User;
import fs.four.devgang.ojakgyo.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    // 회원가입 처리
    @PostMapping("/user/register")
    public ModelAndView registerUser(@RequestParam("userId") String userId,
                                     @RequestParam("password") String password,
                                     @RequestParam("passwordCheck") String passwordCheck,
                                     @RequestParam("nickname") String nickname,
                                     @RequestParam("email") String email,
                                     @RequestParam(value = "receiveAd", required = false) String receiveAd,
                                     @RequestParam(value = "terms", required = false) String termsAccepted) {

        ModelAndView modelAndView = new ModelAndView();

        // 이용약관 및 개인정보 취급방침 체크 여부 확인
        if (termsAccepted == null) {
            modelAndView.addObject("message", "이용약관과 개인정보 취급방침에 동의해야 가입할 수 있습니다.");
            modelAndView.setViewName("register");
            return modelAndView;
        }

        // 비밀번호 확인
        if (!password.equals(passwordCheck)) {
            modelAndView.addObject("message", "비밀번호가 일치하지 않습니다.");
            modelAndView.setViewName("register");
            return modelAndView;
        }

        // User 객체 생성
        User user = new User();
        user.setUserId(userId);
        user.setUserPw(password);
        user.setUserNickname(nickname);
        user.setUserEmail(email);
        user.setUserReceiveAdv(receiveAd != null ? "Y" : "N");

        // 사용자 등록 서비스 호출
        boolean isRegistered = userService.registerUser(user);
        if (isRegistered) {
            modelAndView.addObject("message", "회원가입 성공");
        } else {
            modelAndView.addObject("message", "회원가입 실패");
        }

        modelAndView.setViewName("register"); // 회원가입 페이지로 이동
        return modelAndView;
    }
}