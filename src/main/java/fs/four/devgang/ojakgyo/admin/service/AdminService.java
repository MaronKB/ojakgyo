package fs.four.devgang.ojakgyo.admin.service;


import fs.four.devgang.ojakgyo.admin.repository.AdminDAO;
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
}