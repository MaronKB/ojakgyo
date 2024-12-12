package fs.four.devgang.ojakgyo.user.service;

import fs.four.devgang.ojakgyo.user.vo.FindVO;

public interface FindService {
    boolean findPassword(FindVO findVO) throws Exception;
}
