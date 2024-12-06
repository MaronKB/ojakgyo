package fs.four.devgang.ojakgyo.main.service;

import fs.four.devgang.ojakgyo.api.local.entity.Coordinate;
import fs.four.devgang.ojakgyo.api.local.service.LocalService;
import org.springframework.stereotype.Service;

@Service
public class MainService {
    private static final LocalService localService = new LocalService();

    public Coordinate getCenter(String myAddress, String yourAddress) throws Exception {
        Coordinate myLocation = localService.getCoordinate(myAddress);
        Coordinate yourLocation = localService.getCoordinate(yourAddress);

        Coordinate center = new Coordinate();
        int x = (Integer.parseInt(myLocation.getX()) + Integer.parseInt(yourLocation.getX())) / 2;
        int y = (Integer.parseInt(myLocation.getY()) + Integer.parseInt(yourLocation.getY())) / 2;
        center.setX(String.valueOf(x));
        center.setY(String.valueOf(y));

        return center;
    }
}
