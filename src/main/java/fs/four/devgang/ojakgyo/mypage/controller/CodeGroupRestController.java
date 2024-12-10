package fs.four.devgang.ojakgyo.mypage.controller;

import fs.four.devgang.ojakgyo.mypage.service.CodeGroupRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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



}