package fs.four.devgang.ojakgyo.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    @Autowired
    public PostDAO postDAO;

    public void createPost(Post post) {
        postDAO.insertPost(post);
    }
}
