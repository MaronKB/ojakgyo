package fs.four.devgang.ojakgyo.api.tmap.service;

import fs.four.devgang.ojakgyo.api.naver.entity.Coordinate;
import org.springframework.stereotype.Service;

import java.net.URL;

@Service
public class StaticMapService extends TmapService {
    public String getStaticMapImage(Coordinate coordinate) throws Exception {
        StringBuilder sb = new StringBuilder();
        sb.append("https://apis.openapi.sk.com/tmap/staticMap?");
        sb.append("version=");
        sb.append(VERSION);
        sb.append("&appKey=");
        sb.append(API_KEY);
        sb.append("&coordType=");
        sb.append(REQ_COORD_TYPE);
        sb.append("&width=512");
        sb.append("&height=512");
        sb.append("&zoom=15");
        sb.append("&format=png");
        sb.append("&longitude=");
        sb.append(coordinate.getX());
        sb.append("&latitude=");
        sb.append(coordinate.getY());
        sb.append("&markers=");
        sb.append(coordinate.getX()).append(",").append(coordinate.getY());

        String result = getJSON(sb.toString());

        return result;
    }
}
