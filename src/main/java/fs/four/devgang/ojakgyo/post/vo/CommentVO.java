package fs.four.devgang.ojakgyo.post.vo;

import org.springframework.stereotype.Component;

import java.util.Date;

@Component("commentVO")
public class CommentVO {
    private int comment_id;
    private int comment_post_id;
    private String comment_author_id;
    private String comment_author_nickname;
    private String comment_content;
    private Date comment_reg_date;
    private String comment_reg_by;
    private int comment_parent_id;
    private String comment_is_child;
    private String comment_is_reported;

    public CommentVO() {

    }

    public int getComment_id() {
        return comment_id;
    }

    public void setComment_id(int comment_id) {
        this.comment_id = comment_id;
    }

    public int getComment_post_id() {
        return comment_post_id;
    }

    public void setComment_post_id(int comment_post_id) {
        this.comment_post_id = comment_post_id;
    }

    public String getComment_author_id() {
        return comment_author_id;
    }

    public void setComment_author_id(String comment_author_id) {
        this.comment_author_id = comment_author_id;
    }

    public String getComment_author_nickname() {
        return comment_author_nickname;
    }

    public void setComment_author_nickname(String comment_author_nickname) {
        this.comment_author_nickname = comment_author_nickname;
    }

    public String getComment_content() {
        return comment_content;
    }

    public void setComment_content(String comment_content) {
        this.comment_content = comment_content;
    }

    public Date getComment_reg_date() {
        return comment_reg_date;
    }

    public void setComment_reg_date(Date comment_reg_date) {
        this.comment_reg_date = comment_reg_date;
    }

    public String getComment_reg_by() {
        return comment_reg_by;
    }

    public void setComment_reg_by(String comment_reg_by) {
        this.comment_reg_by = comment_reg_by;
    }

    public int getComment_parent_id() {
        return comment_parent_id;
    }

    public void setComment_parent_id(int comment_parent_id) {
        this.comment_parent_id = comment_parent_id;
    }

    public String getComment_is_child() {
        return comment_is_child;
    }

    public void setComment_is_child(String comment_is_child) {
        this.comment_is_child = comment_is_child;
    }

    public String getComment_is_reported() {
        return comment_is_reported;
    }

    public void setComment_is_reported(String comment_is_reported) {
        this.comment_is_reported = comment_is_reported;
    }
}
