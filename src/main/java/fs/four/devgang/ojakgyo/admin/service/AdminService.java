package fs.four.devgang.ojakgyo.admin.service;


import fs.four.devgang.ojakgyo.admin.repository.AdminDAO;
import fs.four.devgang.ojakgyo.admin.vo.AdminVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("adminService")
public class AdminService {

    @Autowired
    private AdminDAO adminDAO;

    public List listUser() throws Exception {
        List userList = null;
        userList = adminDAO.selectAllUserList();
        return userList;
    }

//    검색 기능
    public List<AdminVO> searchUsers(String category, String keyword) throws Exception {
        return adminDAO.searchUsers(category, keyword);
    }

//    삭제 기능
    public void softDeleteUsers(List<String> userIds) throws Exception {
        adminDAO.softDeleteUsers(userIds);
    }

//    수정 기능
    public void updateUser(AdminVO adminVO) throws Exception {
        adminDAO.updateUser(adminVO);
    }

}