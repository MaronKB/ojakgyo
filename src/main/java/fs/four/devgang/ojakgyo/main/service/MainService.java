package fs.four.devgang.ojakgyo.main.service;

import fs.four.devgang.ojakgyo.api.local.entity.Coordinate;
import fs.four.devgang.ojakgyo.api.local.entity.Geocode;
import fs.four.devgang.ojakgyo.api.local.service.CoordinateService;
import fs.four.devgang.ojakgyo.api.local.service.LocalService;
import fs.four.devgang.ojakgyo.api.local.service.ReverseGeocodingService;
import org.springframework.stereotype.Service;

@Service
public class MainService {
    private static final LocalService localService = new LocalService();
    public static final CoordinateService coordinateService = new CoordinateService();
    private final ReverseGeocodingService reverseGeocodingService = new ReverseGeocodingService();

    public Coordinate getCenterPos(String myAddress, String yourAddress) throws Exception {
        String[] myAddressString = myAddress.split(" ");
        myAddress = myAddressString[0] + " " + myAddressString[1];
        String[] yourAddressString = yourAddress.split(" ");
        yourAddress = yourAddressString[0] + " " + yourAddressString[1];

        Coordinate myLocation = coordinateService.getCoordinate(myAddress);
        Coordinate yourLocation = coordinateService.getCoordinate(yourAddress);

        return getCenterPos(myLocation, yourLocation);
    }

    public Coordinate getCenterPos(Coordinate myLocation, Coordinate yourLocation) throws Exception {
        long x = (Long.parseLong(myLocation.getX()) + Long.parseLong(yourLocation.getX())) / 2;
        long y = (Long.parseLong(myLocation.getY()) + Long.parseLong(yourLocation.getY())) / 2;

        Coordinate center = new Coordinate();
        center.setX(getPosString(x));
        center.setY(getPosString(y));

        return center;
    }

    private String getPosString(long pos) {
        String str = String.valueOf(pos);
        int strInt = Integer.parseInt(str.substring(0, str.length() - 7));
        int strFloat = Integer.parseInt(str.substring(str.length() - 7));
        return strInt + "." + strFloat;
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
