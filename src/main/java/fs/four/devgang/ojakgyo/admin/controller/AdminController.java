package fs.four.devgang.ojakgyo.admin.controller;

import fs.four.devgang.ojakgyo.admin.service.AdminService;
import fs.four.devgang.ojakgyo.admin.vo.AdminVO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

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

//    삭제 기능
    @PostMapping("/admin/deleteUsers")
    @ResponseBody
    public ResponseEntity<String> deleteUsers(@RequestParam("userIds") List<String> userIds) {
        try {
            adminService.softDeleteUsers(userIds);
            return ResponseEntity.ok("유저 삭제 성공");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("유저 삭제 실패");
        }
    }

//    수정 기능
    @PostMapping("/admin/updateUser")
    @ResponseBody
    public ResponseEntity<String> updateUser(@RequestBody AdminVO adminVO) {
        try {
            adminService.updateUser(adminVO);
            return ResponseEntity.ok("회원 정보 수정 성공");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("회원 정보 수정 실패");
        }
    }

}