package fs.four.devgang.ojakgyo.main.service;

import fs.four.devgang.ojakgyo.api.naver.entity.Coordinate;
import fs.four.devgang.ojakgyo.api.naver.entity.Geocode;
import fs.four.devgang.ojakgyo.api.naver.service.CoordinateService;
import fs.four.devgang.ojakgyo.api.naver.service.LocalService;
import fs.four.devgang.ojakgyo.api.tmap.service.ReverseGeocodingService;
import org.springframework.stereotype.Service;

@Service
public class MainService {
    private static final LocalService localService = new LocalService();
    public static final CoordinateService coordinateService = new CoordinateService();
    private final ReverseGeocodingService reverseGeocodingService = new ReverseGeocodingService();

    private String getPosString(long pos) {
        String str = String.valueOf(pos);
        int strInt = Integer.parseInt(str.substring(0, str.length() - 7));
        int strFloat = Integer.parseInt(str.substring(str.length() - 7));
        return strInt + "." + strFloat;
    }

    public Coordinate getCenterPos(String myAddress, String yourAddress) throws Exception {
        Coordinate myLocation = coordinateService.getCoordinate(myAddress);
        Coordinate yourLocation = coordinateService.getCoordinate(yourAddress);

        return getCenterPos(myLocation, yourLocation);
    }

    public Coordinate getCenterPos(Coordinate myLocation, Coordinate yourLocation) throws Exception {
        String myX = myLocation.getX().replace(".", "");
        String myY = myLocation.getY().replace(".", "");
        String yourX = yourLocation.getX().replace(".", "");
        String yourY = yourLocation.getY().replace(".", "");

        long x = (Long.parseLong(myX) + Long.parseLong(yourX)) / 2;
        long y = (Long.parseLong(myY) + Long.parseLong(yourY)) / 2;

        Coordinate center = new Coordinate();
        center.setX(getPosString(x));
        center.setY(getPosString(y));

        return center;
    }

    public String getCenterAddress(Coordinate center) throws Exception {
        Geocode geocode = reverseGeocodingService.getGeocode(center);
        return geocode.toJSONString();
    }

    public String getCenterAddress(String myAddress, String yourAddress) throws Exception {
        Coordinate center = getCenterPos(myAddress, yourAddress);
        return getCenterAddress(center);
    }

    public String getCenterAddress(Coordinate myLocation, Coordinate yourLocation) throws Exception {
        Coordinate center = getCenterPos(myLocation, yourLocation);
        return getCenterAddress(center);
    }
}
