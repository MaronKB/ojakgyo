//package fs.four.devgang.ojakgyo.user.controller;
//
//import fs.four.devgang.ojakgyo.post.vo.PostVO;
//import fs.four.devgang.ojakgyo.user.service.UserService;
//import fs.four.devgang.ojakgyo.user.vo.UserVO;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.servlet.ModelAndView;
//import org.springframework.web.servlet.mvc.support.RedirectAttributes;
//
//@Controller("userController")
//public class UserControllerImpl implements UserController {
//
//    @Autowired
//    private UserService userService;
//
//    @Autowired
//    private UserVO userVO;
//
//    @Override
//    @RequestMapping(value = "/user/register.do", method = RequestMethod.POST)
//    public ModelAndView addMember(@ModelAttribute("user") UserVO user,
//                                  HttpServletRequest request, HttpServletResponse response) throws Exception {
//        request.setCharacterEncoding("utf-8");
//        int result = userService.addMember(user); // 사용자 등록 서비스 호출
////        result = userService.addMember(user);
//        ModelAndView mav = new ModelAndView("redirect:/user/register");  // 리디렉션 경로 확인 필요
//        return mav;
//    }
//}