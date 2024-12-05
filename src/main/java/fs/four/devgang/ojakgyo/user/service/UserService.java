package fs.four.devgang.ojakgyo.user.service;

import fs.four.devgang.ojakgyo.user.repository.UserDAO;
import fs.four.devgang.ojakgyo.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserDAO userDAO;

    public boolean validateUser(String username, String password) {
        Optional<User> user = userDAO.findByUsername(username);
        return user.map(u -> u.getPassword().equals(password)).orElse(false);
    }

    public Optional<String> findPasswordByEmail(String email) {
        return userDAO.findByEmail(email).map(User::getPassword);
    }

    public void registerUser(User user) {
        userDAO.saveUser(user);
    }
}