package fs.four.devgang.ojakgyo.user.repository;

import fs.four.devgang.ojakgyo.deprecated.LoginVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.dao.DataAccessException;

@Mapper
public interface LoginDAO {

    /**
     * 사용자 로그인 처리
     *
     * @param loginVO 로그인 정보 (아이디, 비밀번호)
     * @return 로그인 성공 시 LoginVO 객체 반환
     * @throws DataAccessException 데이터베이스 오류 발생 시 예외 발생
     */
    LoginVO login(LoginVO loginVO) throws DataAccessException;
}