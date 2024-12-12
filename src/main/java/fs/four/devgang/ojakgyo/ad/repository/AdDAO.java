package fs.four.devgang.ojakgyo.ad.repository;

import fs.four.devgang.ojakgyo.ad.entity.Ad;
import java.util.List;

import fs.four.devgang.ojakgyo.ad.vo.AdVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdDAO{
    public List<AdVO> selectAllAdList() throws Exception;
    public List<AdVO> selectAdListByValid(char adv_is_valid) throws Exception;
    public AdVO selectAdById(int adv_id) throws Exception;
    public int insertAd(AdVO ad) throws Exception;
    public int updateAd(AdVO ad) throws Exception;
    public int deleteAd(int adv_id) throws Exception;
}