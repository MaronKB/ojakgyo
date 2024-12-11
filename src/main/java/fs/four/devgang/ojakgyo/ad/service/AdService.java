package fs.four.devgang.ojakgyo.ad.service;

import fs.four.devgang.ojakgyo.ad.entity.Ad;
import fs.four.devgang.ojakgyo.ad.repository.AdDAO;
import fs.four.devgang.ojakgyo.ad.vo.AdVO;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service("adService")
public class AdService {

    @Autowired
    private AdDAO adDAO;

    public JSONObject list() throws Exception {
        List<AdVO> ads = adDAO.selectAllAdList();
        JSONObject adObject = new JSONObject();
        JSONArray activeArray = new JSONArray();
        JSONArray inactiveArray = new JSONArray();
        for (AdVO ad : ads) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("id", ad.getAdv_id());
            jsonObject.put("title", ad.getAdv_title());
            jsonObject.put("category", ad.getAdv_category());
            jsonObject.put("regDate", parseTimestamp(ad.getAdv_reg_date()));
            jsonObject.put("expDate", parseTimestamp(ad.getAdv_exp_date()));
            if (ad.getAdv_is_valid() == 'Y' || ad.getAdv_is_valid() == 'y') {
                activeArray.add(jsonObject);
            } else {
                inactiveArray.add(jsonObject);
            }
        }
        adObject.put("active", activeArray);
        adObject.put("inactive", inactiveArray);
        return adObject;
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
