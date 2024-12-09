package fs.four.devgang.ojakgyo.api.naver.service;

import fs.four.devgang.ojakgyo.api.naver.entity.Coordinate;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Service;

@Service
public class LocateService extends NaverService {
    public JSONObject getLocate(String start, String goal) throws Exception {
        StringBuilder apiUrl = new StringBuilder("https://naveropenapi.apigw.ntruss.com/map-direction/v1/driving?");
        apiUrl.append("start=");
        apiUrl.append(start);
        apiUrl.append("&goal=");
        apiUrl.append(goal);

        JSONObject jsonObject = (JSONObject) jsonParser.parse(getNCloudConnection(apiUrl.toString()));
        JSONObject route = (JSONObject) jsonObject.get("route");
        JSONArray traoptimal = (JSONArray) route.get("traoptimal");
        return (JSONObject) traoptimal.get(0);
    }
    public JSONObject getLocate(Coordinate start, Coordinate goal) throws Exception {
        String startStr = start.getX() + "," + start.getY();
        String goalStr = goal.getX() + "," + goal.getY();
        return getLocate(startStr, goalStr);
    }
}
