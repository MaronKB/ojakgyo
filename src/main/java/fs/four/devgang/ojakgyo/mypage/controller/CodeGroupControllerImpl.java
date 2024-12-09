package fs.four.devgang.ojakgyo.mypage.controller;

import fs.four.devgang.ojakgyo.mypage.service.CodeGroupService;
import fs.four.devgang.ojakgyo.mypage.vo.CodeGroupVO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller("codeGroupController")
public class CodeGroupControllerImpl implements CodeGroupController {

    @Autowired
    private CodeGroupService codeGroupService;

    @Autowired
    private CodeGroupVO codeGroupVO;

    @Override
    @GetMapping("/code/listCodeGroup.do")
    public ModelAndView listCodeGroup(HttpServletRequest request, HttpServletResponse response) throws Exception {

        List codeGroupList = codeGroupService.listCodeGroup();
        ModelAndView mav = new ModelAndView("/code/listCodeGroup");
        mav.addObject("codeGroupList", codeGroupList);
        return mav;
    }

    @Override
    @GetMapping("/code/codeGroup.do")
    public ModelAndView codeGroupPage(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mav = new ModelAndView("/code/codeGroup");
        return mav;
    }

}
