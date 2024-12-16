package fs.four.devgang.ojakgyo.user.service;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fs.four.devgang.ojakgyo.user.repository.UserDAO;
import fs.four.devgang.ojakgyo.user.vo.UserVO;

import java.sql.Timestamp;
import java.util.List;

@Service("userService")
public class UserService {

    @Autowired
    private UserDAO userDAO;

    public JSONObject castJSONObject(UserVO userVO) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("userId", userVO.getUser_id());
        jsonObject.put("userPw", userVO.getUser_pw());
        jsonObject.put("nickname", userVO.getUser_nickname());
        jsonObject.put("email", userVO.getUser_email());
        jsonObject.put("intro", userVO.getUser_intro());
        jsonObject.put("profileName", userVO.getUser_profile_name());
        jsonObject.put("profilePath", userVO.getUser_profile_path());
        jsonObject.put("address", userVO.getUser_address());
        jsonObject.put("receiveAdv", userVO.getUser_receive_adv());
        jsonObject.put("regDate", userVO.getUser_reg_date());
        jsonObject.put("regBy", userVO.getUser_reg_by());
        jsonObject.put("modDate", userVO.getUser_mod_date());
        jsonObject.put("modBy", userVO.getUser_mod_by());
        jsonObject.put("resDate", userVO.getUser_res_date());
        jsonObject.put("resBy", userVO.getUser_res_by());
        jsonObject.put("isDeleted", Character.toString(userVO.getUser_is_deleted()));
        jsonObject.put("isAdmin", Character.toString(userVO.getUser_is_admin()));

        return jsonObject;
    }
    public UserVO castUserVO(JSONObject jsonObject) {
        UserVO userVO = new UserVO();
        userVO.setUser_id((String) jsonObject.get("userId"));
        userVO.setUser_pw((String) jsonObject.get("userPw"));
        userVO.setUser_nickname((String) jsonObject.get("nickname"));
        userVO.setUser_email((String) jsonObject.get("email"));
        userVO.setUser_intro((String) jsonObject.get("intro"));
        userVO.setUser_profile_name((String) jsonObject.get("profileName"));
        userVO.setUser_profile_path((String) jsonObject.get("profilePath"));
        userVO.setUser_address((String) jsonObject.get("address"));
        userVO.setUser_receive_adv((String) jsonObject.get("receiveAdv"));
        userVO.setUser_reg_date((Timestamp) jsonObject.get("regDate"));
        userVO.setUser_reg_by((String) jsonObject.get("regBy"));
        userVO.setUser_mod_date((Timestamp) jsonObject.get("modDate"));
        userVO.setUser_mod_by((String) jsonObject.get("modBy"));
        userVO.setUser_res_date((Timestamp) jsonObject.get("resDate"));
        userVO.setUser_res_by((String) jsonObject.get("resBy"));
        userVO.setUser_is_deleted((char) jsonObject.get("isDeleted"));
        userVO.setUser_is_admin((char) jsonObject.get("isAdmin"));

        return userVO;
    }

    public JSONArray selectAllUserList() throws Exception {
        List<UserVO> users = userDAO.selectAllUserList();
        JSONArray jsonArray = new JSONArray();
        for (UserVO user : users) {
            jsonArray.add(castJSONObject(user));
        }
        return jsonArray;
    }
    public JSONObject selectUserById(String userId) throws Exception {
        UserVO userVO = userDAO.selectUserById(userId);
        return castJSONObject(userVO);
    }
    public UserVO selectUserByEmail(String email) throws Exception {
        return userDAO.selectUserByEmail(email);
    }

    public int insertUser(UserVO userVO) throws Exception {
        return userDAO.insertUser(userVO);
    }
    public int insertUser(JSONObject jsonObject) throws Exception {
        UserVO userVO = castUserVO(jsonObject);
        return userDAO.insertUser(userVO);
    }
    public int updateUser(UserVO userVO) throws Exception {
        return userDAO.updateUser(userVO);
    }

    public JSONObject login(JSONObject jsonObject) throws Exception {
        UserVO user = userDAO.selectUserById(jsonObject.get("userId").toString());
        JSONObject loginToken = new JSONObject();
        if (user == null) {
            loginToken.put("status", 401);
            loginToken.put("message", "존재하지 않는 아이디입니다.");
        } else {
            if (user.getUser_pw().equals(jsonObject.get("password").toString())) {
                JSONObject token = new JSONObject();
                token.put("userId", user.getUser_id());
                token.put("nickname", user.getUser_nickname());
                token.put("isAdmin", Character.toString(user.getUser_is_admin()));

                loginToken.put("status", 200);
                loginToken.put("message", "로그인 성공");
                loginToken.put("token", token);
            } else {
                loginToken.put("status", 401);
                loginToken.put("message", "비밀번호가 일치하지 않습니다.");
            }
        }
        return loginToken;
    }

    public int checkDuplication(String type, String str) throws Exception {
        if (type.equals("id")) {
            return userDAO.countUserById(str);
        } else if (type.equals("email")) {
            return userDAO.countUserByEmail(str);
        } else {
            return -1;
        }
    }
}