package fs.four.devgang.ojakgyo.api.poi.service;

import fs.four.devgang.ojakgyo.api.common.service.ApiService;
import fs.four.devgang.ojakgyo.api.local.entity.Coordinate;
import jakarta.servlet.http.HttpServletRequest;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Service;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@Service
public class PoiService {
    private static final ApiService apiService = new ApiService();
    private static final JSONParser jsonParser = new JSONParser();

    private static final String POI_API_URL = "https://apis.openapi.sk.com/tmap/pois/search/around?";
    private static final String POI_API_KEY = "FlBqQ3EMhH4tOxopVXfK1QLIklZrFPz58pAjJJha";
    private static final String VERSION = "1";
    private static final String PAGE = "1";
    private static final String COUNT = "18";
    private static final String REQ_COORD_TYPE = "WGS84GEO";
    private static final String RES_COORD_TYPE = "WGS84GEO";

    private String getJSON(URL url) throws Exception {
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        urlConnection.setRequestMethod("GET");
        urlConnection.setRequestProperty("Accept", "application/json");
        urlConnection.setRequestProperty("appKey", POI_API_KEY);

        return apiService.getDataString(urlConnection);
    }

    public String getPOIData(Coordinate coordinate, String categories, String radius, String sort) throws Exception {
        String[] categoryArr = categories.split(",");
        for (int i = 0; i < categoryArr.length; i++) {
            categoryArr[i] = URLEncoder.encode(categoryArr[i], StandardCharsets.UTF_8);
        }
        categories = String.join(";", categoryArr);

        StringBuilder sb = new StringBuilder();
        sb.append(POI_API_URL);
        sb.append("version=");
        sb.append(VERSION);
        sb.append("&centerLon=");
        sb.append(coordinate.getX());
        sb.append("&centerLat=");
        sb.append(coordinate.getY());
        sb.append("&categories=");
        sb.append(categories);
        sb.append("&page=");
        sb.append(PAGE);
        sb.append("&count=");
        sb.append(COUNT);
        sb.append("&radius=");
        sb.append(radius);
        sb.append("&reqCoordType=");
        sb.append(REQ_COORD_TYPE);
        sb.append("&resCoordType=");
        sb.append(RES_COORD_TYPE);
        sb.append("&sort=");
        sb.append(sort);

        URL url = new URL(sb.toString());
        String result = getJSON(url);
        JSONObject obj = (JSONObject) jsonParser.parse(result);
        JSONObject searchPoiInfo = (JSONObject) obj.get("searchPoiInfo");
        JSONObject pois = (JSONObject) searchPoiInfo.get("pois");
        JSONArray poi = (JSONArray) pois.get("poi");

        return poi.toJSONString();
    }

    public String getPOIData(HttpServletRequest request) throws Exception {
        String x = request.getParameter("x");
        String y = request.getParameter("y");
        String categories = request.getParameter("categories");
        String radius = request.getParameter("radius");
        String sort = request.getParameter("sort");

        Coordinate coordinate = new Coordinate(x, y);

        return getPOIData(coordinate, categories, radius, sort);
    }

    public String getPOIDetail(String id) throws Exception {
        StringBuilder sb = new StringBuilder();
        sb.append("https://apis.openapi.sk.com/tmap/pois/").append(id);
        sb.append("?version=");
        sb.append(VERSION);
        sb.append("findOption=id");
        sb.append("&resCoordType=");
        sb.append(RES_COORD_TYPE);

        URL url = new URL(sb.toString());
        String result = getJSON(url);

        JSONObject obj = (JSONObject) jsonParser.parse(result);
        JSONObject poiDetailInfo = (JSONObject) obj.get("poiDetailInfo");

        return poiDetailInfo.toJSONString();
    }

    public String getPOIDetailsString(String poiData) throws Exception {
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        JSONArray poiDataArray = (JSONArray) jsonParser.parse(poiData);
        for (int i = 0; i < poiDataArray.size(); i++) {
            JSONObject poi = (JSONObject) poiDataArray.get(i);
            String id = (String) poi.get("id");
            sb.append(getPOIDetail(id));
            if (i < poiDataArray.size() - 1) {
                sb.append(",");
            }
        }
        sb.append("]");

        return sb.toString();
    }
}
