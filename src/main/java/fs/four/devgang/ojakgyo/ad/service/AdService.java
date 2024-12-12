package fs.four.devgang.ojakgyo.ad.service;

import fs.four.devgang.ojakgyo.ad.repository.AdDAO;
import fs.four.devgang.ojakgyo.ad.vo.AdVO;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service("adService")
public class AdService {

    @Autowired
    private AdDAO adDAO;

    private String stringify(Object obj) {
        return obj == null ? null : obj.toString();
    }

    public JSONArray selectAllAdList() throws Exception {
        List<AdVO> ads = adDAO.selectAllAdList();
        JSONArray jsonArray = new JSONArray();
        for (AdVO ad : ads) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("id", ad.getAdv_id());
            jsonObject.put("title", ad.getAdv_title());
            jsonObject.put("category", ad.getAdv_category());
            jsonObject.put("regDate", parseTimestamp(ad.getAdv_reg_date()));
            jsonObject.put("expDate", parseTimestamp(ad.getAdv_exp_date()));
            jsonObject.put("isValid", ad.getAdv_is_valid());
            jsonArray.add(jsonObject);
        }
        return jsonArray;
    }

    public JSONArray selectAdListByValid(char valid) throws Exception {
        List<AdVO> ads = adDAO.selectAdListByValid(valid);
        JSONArray jsonArray = new JSONArray();
        for (AdVO ad : ads) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("id", ad.getAdv_id());
            jsonObject.put("title", ad.getAdv_title());
            jsonObject.put("category", ad.getAdv_category());
            jsonObject.put("regDate", parseTimestamp(ad.getAdv_reg_date()));
            jsonObject.put("expDate", parseTimestamp(ad.getAdv_exp_date()));
            jsonObject.put("isValid", String.valueOf(ad.getAdv_is_valid()));
            jsonArray.add(jsonObject);
        }
        return jsonArray;
    }

    public JSONObject selectAdById(int adId) throws Exception {
        AdVO ad = adDAO.selectAdById(adId);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", ad.getAdv_id());
        jsonObject.put("title", ad.getAdv_title());
        jsonObject.put("category", ad.getAdv_category());
        jsonObject.put("regDate", parseTimestamp(ad.getAdv_reg_date()));
        jsonObject.put("expDate", parseTimestamp(ad.getAdv_exp_date()));
        jsonObject.put("isValid", String.valueOf(ad.getAdv_is_valid()));
        return jsonObject;
    }

    public int insert(JSONObject ad) throws Exception {
        String title = stringify(ad.get("title"));
        String category = stringify(ad.get("category"));
        String expDate = stringify(ad.get("expDate"));
        String valid = stringify(ad.get("isValid"));

        AdVO adVO = new AdVO();
        if (title != null) adVO.setAdv_title(title);
        if (category != null) adVO.setAdv_category(category);
        if (expDate != null) adVO.setAdv_exp_date(Timestamp.valueOf(expDate));
        if (valid != null) adVO.setAdv_is_valid(valid.charAt(0));

        return adDAO.insertAd(adVO);
    }

    public int update(int adId, JSONObject ad) throws Exception {
        String title = stringify(ad.get("title"));
        String category = stringify(ad.get("category"));
        String expDate = stringify(ad.get("expDate"));
        String valid = stringify(ad.get("isValid"));

        AdVO adVO = adDAO.selectAdById(adId);
        if (title != null) adVO.setAdv_title(title);
        if (category != null) adVO.setAdv_category(category);
        if (expDate != null) adVO.setAdv_exp_date(Timestamp.valueOf(expDate));
        if (valid != null) adVO.setAdv_is_valid(valid.charAt(0));

        System.out.println(adVO.getAdv_exp_date());

        return adDAO.updateAd(adVO);
    }

    public int delete(int adId) throws Exception {
        JSONObject jsonObject = new JSONObject();
        return adDAO.deleteAd(adId);
    }

    private static String parseTimestamp(Timestamp timestamp) {
        if (timestamp == null) {
            return "";
        }
        try {
            Date date = new Date(timestamp.getTime());
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
        } catch (Exception e) {
            return "";
        }
    }
}
