package fs.four.devgang.ojakgyo.user.vo;

public class LoginVO {
    private String userid;
    private String password;
    private String isAdmin; // 관리자 여부 추가 (Y 또는 N로 저장)

    // 기본 생성자
    public LoginVO() {}

    // 사용자명과 비밀번호를 받는 생성자
    public LoginVO(String userid, String password) {
        this.userid = userid;
        this.password = password;
    }

    // Getter and Setter
    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(String isAdmin) {
        this.isAdmin = isAdmin;
    }

    // toString() 메서드 (비밀번호는 숨김 처리)
    @Override
    public String toString() {
        return "LoginVO{" +
                "userid='" + userid + '\'' +
                ", password='******'" +  // 비밀번호는 실제 값을 숨깁니다.
                ", isAdmin='" + isAdmin + '\'' +
                '}';
    }
}