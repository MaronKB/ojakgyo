package fs.four.devgang.ojakgyo.admin.service;


import fs.four.devgang.ojakgyo.admin.repository.AdminDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("adminService")
@Transactional(propagation = Propagation.REQUIRED)
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminDAO adminDAO;

    @Override
    public List listUser() throws Exception {
        List userList = null;
        userList = adminDAO.selectAllUserList();
        return userList;
    }
}