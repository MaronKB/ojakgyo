package fs.four.devgang.ojakgyo.post.service;

import fs.four.devgang.ojakgyo.post.repository.PostDAO;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class PostRestService {

    @Autowired
    private PostDAO postDAO;

    public List listAllPost() throws Exception {

        List postList = null;
        postList = postDAO.selectAllPostList();
        return postList;
    }
}
