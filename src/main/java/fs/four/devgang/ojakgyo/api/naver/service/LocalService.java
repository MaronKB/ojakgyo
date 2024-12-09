package fs.four.devgang.ojakgyo.api.naver.service;

import fs.four.devgang.ojakgyo.api.common.service.ApiService;
import fs.four.devgang.ojakgyo.api.naver.entity.LocalInfo;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Service;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Service
public class LocalService extends NaverService{
    private static final JSONParser jsonParser = new JSONParser();
    private static LocalInfo parseLocalInfoFromJSON(JSONObject item) {
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

    public LocalInfo getLocalInfo(StringBuilder apiUrl) throws Exception {
        String localJSON = getOpenConnection(apiUrl.toString());
        Object obj = jsonParser.parse(localJSON);
        JSONObject jsonObject = (JSONObject) obj;
        JSONArray items = (JSONArray) jsonObject.get("items");
        JSONObject item = (JSONObject) items.get(0);

        return parseLocalInfoFromJSON(item);
    }

    public LocalInfo getLocalInfo(String address) throws Exception {
        StringBuilder apiUrl = new StringBuilder("https://openapi.naver.com/v1/search/local.json?");
        apiUrl.append("query=");
        apiUrl.append(URLEncoder.encode(address, StandardCharsets.UTF_8));
        apiUrl.append("&display=1");
        apiUrl.append("&start=1");
        apiUrl.append("&sort=random");

        return getLocalInfo(apiUrl);
    }

    public LocalInfo getLocalInfo(HttpServletRequest req) throws Exception {
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

        return getLocalInfo(apiUrl);
    }

    public LocalInfo getLocalInfo(HttpServletRequest request, HttpServletResponse response) throws Exception {
        LocalInfo localInfo = getLocalInfo(request);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().print(localInfo.toString());

        return localInfo;
    }

    public List<LocalInfo> getLocalInfos(String keyword, String display, String sort) throws Exception {
        StringBuilder apiUrl = new StringBuilder("https://openapi.naver.com/v1/search/local.json?");
        apiUrl.append("query=");
        apiUrl.append(URLEncoder.encode(keyword, StandardCharsets.UTF_8));
        apiUrl.append("&display=5");
        apiUrl.append("&start=1");
        apiUrl.append("&sort=");
        apiUrl.append(sort);

        String localJSON = getOpenConnection(apiUrl.toString());
        Object obj = jsonParser.parse(localJSON);
        JSONObject jsonObject = (JSONObject) obj;
        JSONArray items = (JSONArray) jsonObject.get("items");

        ArrayList<LocalInfo> localInfos = new ArrayList<>();

        for (Object item : items) {
            LocalInfo localInfo = parseLocalInfoFromJSON((JSONObject) item);
            localInfos.add(localInfo);
        }

        return localInfos;
    }

    public List<LocalInfo> getLocalInfos(HttpServletRequest req) throws Exception {
        String query = req.getParameter("query");
        String display = req.getParameter("display");
        String sort = req.getParameter("sort");

        return getLocalInfos(query, display, sort);
    }
}
