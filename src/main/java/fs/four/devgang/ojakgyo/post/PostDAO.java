package fs.four.devgang.ojakgyo.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PostDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insertPost(Post post) {
        String sql = "INSERT INTO POST (POST_ID, POST_TITLE, POST_CATEGORY, POST_AUTHOR_ID, POST_AUTHOR_NICKNAME, POST_CONTENT, POST_IMAGE_NAME, POST_IMAGE_PATH, POST_VIEW_COUNT, POST_VOTE_COUNT, POST_REG_DATE, POST_REG_BY, POST_MOD_DATE, POST_MOD_BY, POST_IS_REPORTED)" +
                     "VALUES (POST_SEQ.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, 0, 0, SYSDATE, 'N')";

        jdbcTemplate.update(sql,
                post.getTitle(),
                post.getCategory(),
                post.getAuthorId(),
                post.getAuthorNickname(),
                post.getContent(),
                post.getImageName(),
                post.getImagePath()
        );
    }
}
