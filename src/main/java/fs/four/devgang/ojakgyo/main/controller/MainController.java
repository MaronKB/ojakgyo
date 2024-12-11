package fs.four.devgang.ojakgyo.main.controller;

import fs.four.devgang.ojakgyo.api.naver.entity.Coordinate;
import fs.four.devgang.ojakgyo.api.naver.entity.Geocode;
import fs.four.devgang.ojakgyo.api.naver.service.CoordinateService;
import fs.four.devgang.ojakgyo.api.naver.service.LocalService;
import fs.four.devgang.ojakgyo.api.naver.service.LocateService;
import fs.four.devgang.ojakgyo.api.tmap.service.ReverseGeocodingService;
import fs.four.devgang.ojakgyo.api.tmap.service.PoiService;
import fs.four.devgang.ojakgyo.api.tmap.service.StaticMapService;
import fs.four.devgang.ojakgyo.main.service.MainService;
import jakarta.servlet.http.HttpServletRequest;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/main")
public class MainController {
    private static final MainService mainService = new MainService();
    private static final LocalService localService = new LocalService();
    private static final LocateService locateService = new LocateService();
    private static final CoordinateService coordinateService = new CoordinateService();
    private static final PoiService poiService = new PoiService();
    private static final ReverseGeocodingService reverseGeocodingService = new ReverseGeocodingService();
    private static final StaticMapService staticMapService = new StaticMapService();

    @PostMapping("/result")
    public ModelAndView form(HttpServletRequest request) throws Exception {
        String myLocation = request.getParameter("my-location");
        String yourLocation = request.getParameter("your-location");
        String categories = request.getParameter("categories");
        if (categories == null || categories.isEmpty()) {
            categories = "목욕탕,숙박,쇼핑,미용실,대형마트,공원,커피,레저,호텔,마트,TV맛집,카페,한식,중식,일식,패밀리레스토랑,전문음식점,피자,치킨,디저트,제과점,패스트푸드,교통,버스정류장,지하철,주유소,충전소,주차장,정비소,영화관,노래방,PC방,공연장,문화시설";
        }
        String radius = request.getParameter("radius");
        if (radius == null) {
            radius = "10";
        }
        String sort = request.getParameter("sort");
        if (sort == null) {
            sort = "price";
        }

        Coordinate myPos = coordinateService.getCoordinate(myLocation);
        Coordinate yourPos = coordinateService.getCoordinate(yourLocation);
        Coordinate centerPos = mainService.getCenterPos(myLocation, yourLocation);

        Geocode centerGeocode = reverseGeocodingService.getGeocode(centerPos);

        String centerAddress = mainService.getCenterAddress(myLocation, yourLocation);
        System.out.println("centerAddress : " + centerAddress);

        Coordinate centerLocation = coordinateService.getCoordinate(centerGeocode.getAddress() + " 터미널");

        JSONArray poiData = poiService.getPOIData(centerLocation, categories, radius, sort);
        JSONArray poiDetails = poiService.getPOIDetails(poiData);
        //String mapImage = staticMapService.getStaticMapImage(centerPos);
        JSONObject myRoute = locateService.getLocate(myPos, centerLocation);
        JSONObject yourRoute = locateService.getLocate(yourPos, centerLocation);

        ModelAndView mv = new ModelAndView();
        mv.setViewName("main/result/result");

        mv.addObject("categories", categories);
        mv.addObject("myLocation", myLocation);
        mv.addObject("yourLocation", yourLocation);
        mv.addObject("centerLocation", centerLocation.toJSONString());
        mv.addObject("poiData", poiDetails);
        mv.addObject("myRoute", myRoute);
        mv.addObject("yourRoute", yourRoute);

        return mv;
    }
}
