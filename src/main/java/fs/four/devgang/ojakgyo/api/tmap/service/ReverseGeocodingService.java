package fs.four.devgang.ojakgyo.api.tmap.service;

import fs.four.devgang.ojakgyo.api.common.service.ApiService;
import fs.four.devgang.ojakgyo.api.naver.entity.Coordinate;
import fs.four.devgang.ojakgyo.api.naver.entity.Geocode;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Service;

import java.net.HttpURLConnection;

@Service
public class ReverseGeocodingService extends TmapService {
    private static final JSONParser jsonParser = new JSONParser();

    public Geocode getGeocode(String x, String y) throws Exception {
        StringBuilder apiUrl = new StringBuilder("https://apis.openapi.sk.com/tmap/geo/reversegeocoding?");
        apiUrl.append("version=");
        apiUrl.append("1");
        apiUrl.append("&lat=");
        apiUrl.append(y);
        apiUrl.append("&lon=");
        apiUrl.append(x);
        apiUrl.append("&coordType=");
        apiUrl.append("WGS84GEO");
        apiUrl.append("&addressType=");
        apiUrl.append("A00");

        String localJSON = getJSON(apiUrl.toString());
        JSONObject obj = (JSONObject) jsonParser.parse(localJSON);
        JSONObject addressInfo = (JSONObject) obj.get("addressInfo");

        Geocode geocode = new Geocode();
        geocode.setX(x);
        geocode.setY(y);
        geocode.setCity_do((String) addressInfo.get("city_do"));
        geocode.setGu_gun((String) addressInfo.get("gu_gun"));

        return geocode;
    }
    public Geocode getGeocode(Coordinate coordinate) throws Exception {
        return getGeocode(coordinate.getX(), coordinate.getY());
    }
}
