package fs.four.devgang.ojakgyo.api.tmap.service;

import fs.four.devgang.ojakgyo.api.common.service.ApiService;
import fs.four.devgang.ojakgyo.api.naver.entity.Coordinate;
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
public class PoiService extends TmapService {
    private static final ApiService apiService = new ApiService();
    private static final JSONParser jsonParser = new JSONParser();

    public JSONArray getPOIData(Coordinate coordinate, String categories, String radius, String sort) throws Exception {
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

        String result = getJSON(sb.toString());
        JSONObject obj = (JSONObject) jsonParser.parse(result);
        JSONObject searchPoiInfo = (JSONObject) obj.get("searchPoiInfo");
        JSONObject pois = (JSONObject) searchPoiInfo.get("pois");
        return (JSONArray) pois.get("poi");
    }

    public JSONArray getPOIData(HttpServletRequest request) throws Exception {
        String x = request.getParameter("x");
        String y = request.getParameter("y");
        String categories = request.getParameter("categories");
        String radius = request.getParameter("radius");
        String sort = request.getParameter("sort");

        Coordinate coordinate = new Coordinate(x, y);

        return getPOIData(coordinate, categories, radius, sort);
    }

    public JSONObject getPOIDetail(String id) throws Exception {
        StringBuilder sb = new StringBuilder();
        sb.append("https://apis.openapi.sk.com/tmap/pois/").append(id);
        sb.append("?version=");
        sb.append(VERSION);
        sb.append("findOption=id");
        sb.append("&resCoordType=");
        sb.append(RES_COORD_TYPE);

        String result = getJSON(sb.toString());

        JSONObject obj = (JSONObject) jsonParser.parse(result);
        return (JSONObject) obj.get("poiDetailInfo");
    }

    public JSONArray getPOIDetails(JSONArray poiData) throws Exception {
        JSONArray poiDetailArray = new JSONArray();

        for (Object object : poiData) {
            JSONObject poi = (JSONObject) object;
            String id = (String) poi.get("id");
            JSONObject poiDetail = getPOIDetail(id);
            poiDetailArray.add(poiDetail);
        }

        return poiDetailArray;
    }

    public String getPOIDetailsString(JSONArray poiData) throws Exception {
        JSONArray poiDetailArray = getPOIDetails(poiData);
        return poiDetailArray.toString();
    }
}
