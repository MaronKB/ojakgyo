package fs.four.devgang.ojakgyo.mypage.controller;

import fs.four.devgang.ojakgyo.mypage.service.CodeGroupRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/mypage"})

public class CodeGroupRestController {

    // 서비스 autowiredvlfdy
    // "/list"

    @Autowired
    private CodeGroupRestService codeGroupRestService;



    @GetMapping("/nickname")
    public ResponseEntity<List> list() throws Exception{
        System.out.println("리턴");
        return new ResponseEntity<>(codeGroupRestService.listAllCodeGroup(), HttpStatus.OK);
    }

    // GET 요청에 대한 다른 메서드 예시 (닉네임 수정 등)
    @GetMapping("/updatenickname")
    public ResponseEntity<String> updateNickname(@RequestParam String newNickname) throws Exception {
        System.out.println("================");
        //boolean result = codeGroupRestService.updateNickname(newNickname);
        System.out.println("전송");
        //if (result) {
            return new ResponseEntity<>("닉네임이 성공적으로 수정되었습니다.", HttpStatus.OK);
        //} else {
       //     return new ResponseEntity<>("닉네임 수정 실패", HttpStatus.BAD_REQUEST);
        //}
    }

}