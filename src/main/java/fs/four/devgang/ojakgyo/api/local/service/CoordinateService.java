package fs.four.devgang.ojakgyo.api.local.service;

import fs.four.devgang.ojakgyo.api.local.entity.Coordinate;
import fs.four.devgang.ojakgyo.api.local.entity.LocalInfo;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Service;

@Service
public class CoordinateService {
    public static final LocalService localService = new LocalService();

    public Coordinate getCoordinate(String address) throws Exception {
        LocalInfo localInfo = localService.getLocalInfo(address);
        return new Coordinate(localInfo.getMapx(), localInfo.getMapy());
    }

    public Coordinate getCoordinate(HttpServletRequest req) throws Exception {
        LocalInfo localInfo = localService.getLocalInfo(req);
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