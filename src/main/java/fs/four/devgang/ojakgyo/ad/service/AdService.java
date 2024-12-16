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

    private JSONObject parseAdVOToJSONObject(AdVO ad) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", ad.getAdv_id());
        jsonObject.put("title", ad.getAdv_title());
        jsonObject.put("category", ad.getAdv_category());
        jsonObject.put("image", ad.getAdv_image_name());
        jsonObject.put("link", ad.getAdv_link());
        jsonObject.put("regDate", parseTimestamp(ad.getAdv_reg_date()));
        jsonObject.put("expDate", parseTimestamp(ad.getAdv_exp_date()));
        jsonObject.put("isValid", Character.toString(ad.getAdv_is_valid()));
        return jsonObject;
    }

    private AdVO parseJSONObjectToAdVO(JSONObject jsonObject) {
        AdVO ad = new AdVO();
        ad.setAdv_id(Integer.parseInt(stringify(jsonObject.get("id"))));
        ad.setAdv_title(stringify(jsonObject.get("title")));
        ad.setAdv_category(stringify(jsonObject.get("category")));
        ad.setAdv_image_name(stringify(jsonObject.get("image")));
        ad.setAdv_link(stringify(jsonObject.get("link")));
        ad.setAdv_reg_date(Timestamp.valueOf(stringify(jsonObject.get("regDate"))));
        ad.setAdv_exp_date(Timestamp.valueOf(stringify(jsonObject.get("expDate"))));
        ad.setAdv_is_valid(stringify(jsonObject.get("isValid")).charAt(0));
        return ad;
    }

    public JSONArray selectAllAdList() throws Exception {
        List<AdVO> ads = adDAO.selectAllAdList();
        JSONArray jsonArray = new JSONArray();
        for (AdVO ad : ads) {
            jsonArray.add(parseAdVOToJSONObject(ad));
        }
        return jsonArray;
    }

    public JSONArray selectAdListByValid(char valid) throws Exception {
        List<AdVO> ads = adDAO.selectAdListByValid(valid);
        JSONArray jsonArray = new JSONArray();
        for (AdVO ad : ads) {
            jsonArray.add(parseAdVOToJSONObject(ad));
        }
        return jsonArray;
    }

    public JSONObject selectAdById(int adId) throws Exception {
        AdVO ad = adDAO.selectAdById(adId);
        return parseAdVOToJSONObject(ad);
    }

    public int insert(JSONObject ad) throws Exception {
        String title = stringify(ad.get("title"));
        String category = stringify(ad.get("category"));
        String image = stringify(ad.get("image"));
        String link = stringify(ad.get("link"));
        String desc = stringify(ad.get("desc"));
        String expDate = stringify(ad.get("expDate"));
        String valid = stringify(ad.get("isValid"));

        AdVO adVO = adDAO.selectAdById(Integer.parseInt(stringify(ad.get("id"))));
        if (title != null) adVO.setAdv_title(title);
        if (category != null) adVO.setAdv_category(category);
        if (image != null) adVO.setAdv_image_name(image);
        if (link != null) adVO.setAdv_link(link);
        if (desc != null) adVO.setAdv_desc(desc);
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
