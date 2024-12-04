package fs.four.devgang.ojakgyo.juso;

import org.springframework.stereotype.Service;

@Service("jusoService")
public class JusoServiceImpl implements JusoService {
    public void searchJuso() {
        System.out.println("주소를 검색합니다.");
    }
}
