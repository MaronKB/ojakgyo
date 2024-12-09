package fs.four.devgang.ojakgyo.api.naver.service;

import fs.four.devgang.ojakgyo.api.naver.entity.Coordinate;
import fs.four.devgang.ojakgyo.api.naver.entity.LocalInfo;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Service;

@Service
public class CoordinateService {
    public static final LocalService localService = new LocalService();

    public Coordinate getCoordinate(String address) throws Exception {
        String[] addressString = address.split(" ");
        address = addressString[0] + " " + addressString[1];
        LocalInfo localInfo = localService.getLocalInfo(address);
        String x = getPosString(localInfo.getMapx());
        String y = getPosString(localInfo.getMapy());
        return new Coordinate(x, y);
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

    private String getPosString(String str) {
        int strInt = Integer.parseInt(str.substring(0, str.length() - 7));
        int strFloat = Integer.parseInt(str.substring(str.length() - 7));
        return strInt + "." + strFloat;
    }
}