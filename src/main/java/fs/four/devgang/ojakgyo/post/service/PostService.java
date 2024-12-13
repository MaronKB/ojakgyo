package fs.four.devgang.ojakgyo.post.service;


import fs.four.devgang.ojakgyo.post.repository.PostDAO;
import fs.four.devgang.ojakgyo.post.vo.PostVO;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service("postService")
@Transactional(propagation = Propagation.REQUIRED)
public class PostService {
    private static final int POST_LIST_SIZE = 15;

    @Autowired
    private PostDAO postDAO;

    private static String parseTimestampToString(String timestamp) throws Exception {
        if (timestamp == null || timestamp.isEmpty() || timestamp.equals("null")) return "";

        SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss ZZZ yyyy", java.util.Locale.US);
        Date date = sdf.parse(timestamp);

        SimpleDateFormat newSdf = new SimpleDateFormat("MM-dd HH:mm");
        return newSdf.format(date);
    }

    private static JSONObject parseVOToJSON(PostVO post) throws Exception {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("postId", post.getPost_id());
        jsonObject.put("title", post.getPost_title());
        jsonObject.put("category", post.getPost_category());
        jsonObject.put("authorId", post.getPost_author_id());
        jsonObject.put("authorNickname", post.getPost_author_nickname());
        jsonObject.put("content", post.getPost_content());
        jsonObject.put("imageName", post.getPost_image_name());
        jsonObject.put("imagePath", post.getPost_image_path());
        jsonObject.put("viewCount", post.getPost_view_count());
        jsonObject.put("voteCount", post.getPost_vote_count());
        jsonObject.put("regDate", parseTimestampToString(String.valueOf(post.getPost_reg_date())));
        jsonObject.put("regBy", post.getPost_reg_by());
        jsonObject.put("modDate", parseTimestampToString(String.valueOf(post.getPost_mod_date())));
        jsonObject.put("modBy", post.getPost_mod_by());
        jsonObject.put("isReported", post.getPost_is_reported());
        return jsonObject;
    }

    private static JSONArray parseListToJSON(List<PostVO> postList, int page) throws Exception {
        int start = (page - 1) * POST_LIST_SIZE;
        int end = start + POST_LIST_SIZE;
        if (end > postList.size()) end = postList.size();

        List<PostVO> subList = (postList.size() >= POST_LIST_SIZE) ? new ArrayList<>(postList.subList(start, end)) : postList;

        JSONArray jsonArray = new JSONArray();
        for (PostVO post : subList) {
            jsonArray.add(parseVOToJSON(post));
        }
        return jsonArray;
    }

    public JSONObject selectAllPostList(int page) throws Exception {
        List<PostVO> postList = postDAO.selectAllPostList();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("totalPage", (postList.size() / POST_LIST_SIZE) + 1);
        jsonObject.put("posts", parseListToJSON(postList, page));
        return jsonObject;
    }

    public JSONObject selectPostById(int postId) throws Exception {
        return parseVOToJSON(postDAO.selectPostById(postId));
    }

    public JSONObject selectPostByCategory(String category, int page) throws Exception {
        List<PostVO> postList = postDAO.selectPostByCategory(category);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("totalPage", (postList.size() / POST_LIST_SIZE) + 1);
        jsonObject.put("posts", parseListToJSON(postList, page));
        return jsonObject;
    }

    public int addPost(PostVO post) throws Exception {
        return postDAO.insertPost(post);
    }

    public void increasePostViewCount(int postId) throws Exception {
        postDAO.updatePostViewCount(postId);
    }
}