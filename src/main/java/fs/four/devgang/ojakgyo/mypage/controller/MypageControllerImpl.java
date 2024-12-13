package fs.four.devgang.ojakgyo.mypage.controller;

import fs.four.devgang.ojakgyo.mypage.service.MypageService;
import fs.four.devgang.ojakgyo.mypage.vo.MypageVO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller("mypageController")
public class MypageControllerImpl implements MypageController {

    @Autowired
    private MypageService mypageService;

    @Autowired
    private MypageVO mypageVO;

    @Override
    @GetMapping("/user/updatenickname")
    public ModelAndView listMypage(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List mypageList = mypageService.listMypage();
        ModelAndView mav = new ModelAndView("/user/updatenickname");
        mav.addObject("mypageList", mypageList);
        return mav;

    }

    @Override
    @GetMapping("/user/myPage.do")

    public ModelAndView mypagePage(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mav = new ModelAndView("/code/codeGroup");
        return mav;
    }

}

