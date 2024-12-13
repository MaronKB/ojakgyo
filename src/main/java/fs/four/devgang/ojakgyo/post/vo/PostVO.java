package fs.four.devgang.ojakgyo.post.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Component("postVO")
public class PostVO {
    private int post_id;
    private String post_title;
    private String post_category;
    private String post_author_id;
    private String post_author_nickname;
    private String post_content;
    private String post_image_name;
    private String post_image_path;
    private int post_view_count;
    private int post_vote_count;
    private Date post_reg_date;
    private String post_reg_by;
    private Date post_mod_date;
    private String post_mod_by;
    private String post_is_reported;
}
