package fs.four.devgang.ojakgyo.api.local.service;

import fs.four.devgang.ojakgyo.api.common.service.ApiService;
import fs.four.devgang.ojakgyo.api.local.entity.Coordinate;
import fs.four.devgang.ojakgyo.api.local.entity.Geocode;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Service;

import java.net.HttpURLConnection;
import java.net.URL;

@Service
public class ReverseGeocodingService {
    private static final JSONParser jsonParser = new JSONParser();
    private static final ApiService apiService = new ApiService();

    private static HttpURLConnection getConnection(StringBuilder apiUrl) throws Exception {
        URL url = new URL(apiUrl.toString());

        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        urlConnection.setRequestMethod("GET");
        urlConnection.setRequestProperty("Accept", "application/json");
        urlConnection.setRequestProperty("appKey", "FlBqQ3EMhH4tOxopVXfK1QLIklZrFPz58pAjJJha");

        return urlConnection;
    }
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

        HttpURLConnection urlConnection = getConnection(apiUrl);
        String localJSON = apiService.getDataString(urlConnection);
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
