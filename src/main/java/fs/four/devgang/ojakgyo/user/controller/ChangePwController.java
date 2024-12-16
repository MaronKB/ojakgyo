package fs.four.devgang.ojakgyo.user.controller;

import fs.four.devgang.ojakgyo.user.service.ChangePwService;
import fs.four.devgang.ojakgyo.user.vo.ChangePwVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/change")
public class ChangePwController {

    @Autowired
    private ChangePwService changePwService;

    @GetMapping
    public String showChangePasswordPage() {
        return "user/change_password"; // JSP 파일 반환
    }

    @PostMapping("/change_password")
    @ResponseBody
    public String changePassword(@RequestBody ChangePwVO changePwVO) {
        boolean success = changePwService.changePassword(changePwVO);
        return success
                ? "{\"success\": true, \"message\": \"비밀번호가 성공적으로 변경되었습니다.\"}"
                : "{\"success\": false, \"message\": \"비밀번호 변경에 실패했습니다.\"}";
    }
}
