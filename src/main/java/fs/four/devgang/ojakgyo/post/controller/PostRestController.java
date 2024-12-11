package fs.four.devgang.ojakgyo.post.controller;


import fs.four.devgang.ojakgyo.post.service.PostRestService;
import fs.four.devgang.ojakgyo.post.vo.PostVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping({"/post"})
public class PostRestController {

    // 서비스 Autowired
    //"/list"

    @Autowired
    private PostRestService postRestService;

    @GetMapping("/list")
    public ResponseEntity<List<PostVO>> list(@RequestParam(value = "category", required = false) String category) throws Exception {
        List<PostVO> postList;
        if (category == null || category.equals("전체")) {
            postList = postRestService.listAllPost();
        } else {
            postList = postRestService.listPostByCategory(category);
        }
        return new ResponseEntity<>(postList, HttpStatus.OK);
    }

}
