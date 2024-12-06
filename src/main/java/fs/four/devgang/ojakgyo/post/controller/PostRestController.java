package fs.four.devgang.ojakgyo.post.controller;

import fs.four.devgang.ojakgyo.post.service.PostRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping
public class PostRestController {

    // 서비스 autowired
    // "/list"

    @Autowired
    private PostRestService postRestService;

    @GetMapping("/list")
    public ResponseEntity<List> list() throws Exception{
        return new ResponseEntity<>(postRestService.listAllPost(), HttpStatus.OK);
    }
}
