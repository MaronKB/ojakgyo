package fs.four.devgang.ojakgyo.api.local.service;

import fs.four.devgang.ojakgyo.api.common.service.ApiService;
import fs.four.devgang.ojakgyo.api.local.entity.Coordinate;
import fs.four.devgang.ojakgyo.api.local.entity.LocalInfo;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@Service
public class LocalService {
    private static final ApiService apiService = new ApiService();
    private static final JSONParser jsonParser = new JSONParser();

    private static HttpURLConnection getHttpURLConnection(StringBuilder apiUrl) throws IOException {
        URL url = new URL(apiUrl.toString());

        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        urlConnection.setRequestMethod("GET");
        urlConnection.setRequestProperty("Host", "openapi.naver.com");
        urlConnection.setRequestProperty("User-Agent", "curl/7.49.1");
        urlConnection.setRequestProperty("Accept", "*/*");
        urlConnection.setRequestProperty("X-Naver-Client-Id", "Xs8udJjhMhH_I_6pLk3F");
        urlConnection.setRequestProperty("X-Naver-Client-Secret", "hMAAjvehvN");

        return urlConnection;
    }

    public LocalInfo getLocal(StringBuilder apiUrl) throws Exception {
        HttpURLConnection urlConnection = getHttpURLConnection(apiUrl);

        String localJSON = apiService.getApi(urlConnection);
        System.out.println(localJSON);
        Object obj = jsonParser.parse(localJSON);
        JSONObject jsonObject = (JSONObject) obj;
        JSONArray items = (JSONArray) jsonObject.get("items");
        JSONObject item = (JSONObject) items.get(0);

        System.out.println(items);

        LocalInfo localInfo = new LocalInfo();
        localInfo.setTitle((String) item.get("title"));
        localInfo.setLink((String) item.get("link"));
        localInfo.setCategory((String) item.get("category"));
        localInfo.setDescription((String) item.get("description"));
        localInfo.setTelephone((String) item.get("telephone"));
        localInfo.setAddress((String) item.get("address"));
        localInfo.setRoadAddress((String) item.get("roadAddress"));
        localInfo.setMapx((String) item.get("mapx"));
        localInfo.setMapy((String) item.get("mapy"));

        return localInfo;
    }

    public LocalInfo getLocal(String address) throws Exception {
        StringBuilder apiUrl = new StringBuilder("https://openapi.naver.com/v1/search/local.json?");
        apiUrl.append("query=");
        apiUrl.append(URLEncoder.encode(address, StandardCharsets.UTF_8));
        apiUrl.append("&display=1");
        apiUrl.append("&start=1");
        apiUrl.append("&sort=random");

        return getLocal(apiUrl);
    }

    public LocalInfo getLocal(HttpServletRequest req) throws Exception {
        String query = req.getParameter("query");
        String display = req.getParameter("display");
        String start = req.getParameter("start");
        String sort = req.getParameter("sort");

        StringBuilder apiUrl = new StringBuilder("https://openapi.naver.com/v1/search/local.json?");
        apiUrl.append("query=");
        apiUrl.append(query != null ? URLEncoder.encode(query, StandardCharsets.UTF_8) : "%EC%A3%BC%EC%8B%9D");
        apiUrl.append("&display=");
        apiUrl.append(display != null ? display : "1");
        apiUrl.append("&start=");
        apiUrl.append(start != null ? start : "1");
        apiUrl.append("&sort=");
        apiUrl.append(sort != null ? sort : "random");

        return getLocal(apiUrl);
    }

    public LocalInfo getLocal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        LocalInfo localInfo = getLocal(request);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().print(localInfo.toString());

        return localInfo;
    }

    public Coordinate getCoordinate(String address) throws Exception {
        LocalInfo localInfo = getLocal(address);
        return new Coordinate(localInfo.getMapx(), localInfo.getMapy());
    }

    public Coordinate getCoordinate(HttpServletRequest req) throws Exception {
        LocalInfo localInfo = getLocal(req);
        return new Coordinate(localInfo.getMapx(), localInfo.getMapy());
    }

    public Coordinate getCoordinate(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Coordinate coordinate = getCoordinate(request);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().print(coordinate.toString());

        return coordinate;
    }
}
