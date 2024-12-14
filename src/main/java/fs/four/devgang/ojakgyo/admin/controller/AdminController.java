package fs.four.devgang.ojakgyo.admin.controller;

import fs.four.devgang.ojakgyo.admin.service.AdminService;
import fs.four.devgang.ojakgyo.admin.vo.AdminVO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class AdminController {
    @Autowired
    private AdminService adminService;

    @Autowired
    private AdminVO adminVO;

    @GetMapping("/admin/users")
    public ModelAndView listUser(HttpServletRequest request, HttpServletResponse response) throws Exception {

        List userList = adminService.listUser();
        ModelAndView mav = new ModelAndView("/admin/listUser");
        mav.addObject("userList", userList);
        return mav;
    }

//    검색 기능
    @GetMapping("/admin/searchUsers")
    @ResponseBody
    public List<AdminVO> searchUsers(
            @RequestParam("category") String category,
            @RequestParam("keyword") String keyword) throws Exception {

        return adminService.searchUsers(category, keyword);
    }
}