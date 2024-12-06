package fs.four.devgang.ojakgyo.user.repository;

import fs.four.devgang.ojakgyo.user.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAO {

    // 사용자 정보를 저장하는 메소드 (실제로는 DB에 저장하는 코드가 들어가야 합니다)
    public boolean save(User user) {
        // 예시로 콘솔에 출력하는 코드로 대신합니다.
        System.out.println("User saved: " + user.getUserId());
        return true;  // 저장 성공 시 true 리턴
    }

    // 사용자 정보가 중복되는지 체크하는 메소드
    public boolean checkDuplicateUserId(String userId) {
        // 실제 DB에서 사용자 아이디가 중복되는지 확인하는 로직이 필요합니다.
        return false; // 예시로 중복이 없다고 가정
    }
}