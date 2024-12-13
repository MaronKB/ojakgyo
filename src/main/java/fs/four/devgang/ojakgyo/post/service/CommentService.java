package fs.four.devgang.ojakgyo.post.service;

import fs.four.devgang.ojakgyo.post.repository.CommentDAO;
import fs.four.devgang.ojakgyo.post.vo.CommentVO;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service("commentService")
@Transactional(propagation = Propagation.REQUIRED)
public class CommentService {

    @Autowired
    private CommentDAO commentDAO;

    private String parseTimestampToString(String timestamp) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss ZZZ yyyy", java.util.Locale.US);
        Date date = sdf.parse(timestamp);

        SimpleDateFormat newSdf = new SimpleDateFormat("MM-dd HH:mm");
        return newSdf.format(date);
    }

    private JSONObject parseCommentVOToJSONObject(CommentVO comment) throws Exception {
        JSONObject commentObject = new JSONObject();
        commentObject.put("commentId", comment.getComment_id());
        commentObject.put("postId", comment.getComment_post_id());
        commentObject.put("authorId", comment.getComment_author_id());
        commentObject.put("authorNickname", comment.getComment_author_nickname());
        commentObject.put("content", comment.getComment_content());
        commentObject.put("regDate", parseTimestampToString(String.valueOf(comment.getComment_reg_date())));
        commentObject.put("parentId", comment.getComment_parent_id());
        commentObject.put("isChild", comment.getComment_is_child());
        commentObject.put("isReported", comment.getComment_is_reported());
        return commentObject;
    }

    private JSONArray parseCommentListToJSONArray(List<CommentVO> comments) throws Exception {
        JSONArray commentArray = new JSONArray();
        for (CommentVO comment : comments) {
            commentArray.add(parseCommentVOToJSONObject(comment));
        }
        return commentArray;
    }

    public List selectAllCommentList() throws Exception {
        return commentDAO.selectAllCommentList();
    }

    public int insertComment(JSONObject jsonObject) throws Exception {
        CommentVO comment = new CommentVO();
        comment.setComment_post_id(Integer.parseInt(jsonObject.get("postId").toString()));
        comment.setComment_author_id(jsonObject.get("authorId").toString());
        comment.setComment_author_nickname(jsonObject.get("authorNickname").toString());
        comment.setComment_content(jsonObject.get("content").toString());

        return commentDAO.insertComment(comment);
    }

    public JSONArray selectCommentByPostId(int postId) throws Exception {
        List<CommentVO> comments = commentDAO.selectCommentsByPostId(postId);
        return parseCommentListToJSONArray(comments);
    }

}
