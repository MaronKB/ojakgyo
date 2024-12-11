package fs.four.devgang.ojakgyo.ad.repository;

import fs.four.devgang.ojakgyo.ad.entity.Ad;
import java.util.List;

import fs.four.devgang.ojakgyo.ad.vo.AdVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdDAO{
    public List<AdVO> selectAllAdList() throws Exception;
}
