package fs.four.devgang.ojakgyo.post.vo;

import org.springframework.stereotype.Component;

import java.util.Date;

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

    public PostVO() {

    }

    public int getPost_id() {
        return post_id;
    }

    public void setPost_id(int post_id) {
        this.post_id = post_id;
    }

    public String getPost_title() {
        return post_title;
    }

    public void setPost_title(String post_title) {
        this.post_title = post_title;
    }

    public String getPost_category() {
        return post_category;
    }

    public void setPost_category(String post_category) {
        this.post_category = post_category;
    }

    public String getPost_author_id() {
        return post_author_id;
    }

    public void setPost_author_id(String post_author_id) {
        this.post_author_id = post_author_id;
    }

    public String getPost_author_nickname() {
        return post_author_nickname;
    }

    public void setPost_author_nickname(String post_author_nickname) {
        this.post_author_nickname = post_author_nickname;
    }

    public String getPost_content() {
        return post_content;
    }

    public void setPost_content(String post_content) {
        this.post_content = post_content;
    }

    public String getPost_image_name() {
        return post_image_name;
    }

    public void setPost_image_name(String post_image_name) {
        this.post_image_name = post_image_name;
    }

    public String getPost_image_path() {
        return post_image_path;
    }

    public void setPost_image_path(String post_image_path) {
        this.post_image_path = post_image_path;
    }

    public int getPost_view_count() {
        return post_view_count;
    }

    public void setPost_view_count(int post_view_count) {
        this.post_view_count = post_view_count;
    }

    public int getPost_vote_count() {
        return post_vote_count;
    }

    public void setPost_vote_count(int post_vote_count) {
        this.post_vote_count = post_vote_count;
    }

    public Date getPost_reg_date() {
        return post_reg_date;
    }

    public void setPost_reg_date(Date post_reg_date) {
        this.post_reg_date = post_reg_date;
    }

    public String getPost_reg_by() {
        return post_reg_by;
    }

    public void setPost_reg_by(String post_reg_by) {
        this.post_reg_by = post_reg_by;
    }

    public Date getPost_mod_date() {
        return post_mod_date;
    }

    public void setPost_mod_date(Date post_mod_date) {
        this.post_mod_date = post_mod_date;
    }

    public String getPost_mod_by() {
        return post_mod_by;
    }

    public void setPost_mod_by(String post_mod_by) {
        this.post_mod_by = post_mod_by;
    }

    public String getPost_is_reported() {
        return post_is_reported;
    }

    public void setPost_is_reported(String post_is_reported) {
        this.post_is_reported = post_is_reported;
    }
}
