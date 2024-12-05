package fs.four.devgang.ojakgyo.user.repository;

import fs.four.devgang.ojakgyo.user.entity.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class UserDAO {
    private final Map<String, User> userTable = new HashMap<>(); // 메모리 기반 저장소

    public Optional<User> findByUsername(String username) {
        return Optional.ofNullable(userTable.get(username));
    }

    public Optional<User> findByEmail(String email) {
        return userTable.values().stream()
                .filter(user -> user.getEmail().equals(email))
                .findFirst();
    }

    public void saveUser(User user) {
        userTable.put(user.getUsername(), user);
    }

    public void deleteUser(String username) {
        userTable.remove(username);
    }
}