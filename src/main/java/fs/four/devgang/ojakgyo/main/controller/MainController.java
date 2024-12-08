package fs.four.devgang.ojakgyo.main.controller;

import fs.four.devgang.ojakgyo.api.local.entity.Coordinate;
import fs.four.devgang.ojakgyo.api.local.entity.Geocode;
import fs.four.devgang.ojakgyo.api.local.service.LocalService;
import fs.four.devgang.ojakgyo.api.local.service.ReverseGeocodingService;
import fs.four.devgang.ojakgyo.api.poi.service.PoiService;
import fs.four.devgang.ojakgyo.main.service.MainService;
import jakarta.servlet.http.HttpServletRequest;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

@Controller
@RequestMapping("/main")
public class MainController {
    private static final MainService mainService = new MainService();
    private static final LocalService localService = new LocalService();
    private static final PoiService poiService = new PoiService();
    private static final ReverseGeocodingService reverseGeocodingService = new ReverseGeocodingService();

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
            sort = "distance";
        }

        Coordinate centerPos = mainService.getCenterPos(myLocation, yourLocation);
        Geocode centerGeocode = reverseGeocodingService.getGeocode(centerPos);

        String poiData = poiService.getPOIData(centerPos, categories, radius, sort);
        String poiDetailString = poiService.getPOIDetailsString(poiData);

        ModelAndView mv = new ModelAndView();
        mv.setViewName("main/result");

        mv.addObject("myLocation", myLocation);
        mv.addObject("yourLocation", yourLocation);
        mv.addObject("categories", categories);
        mv.addObject("centerGeocode", centerGeocode.toJSONString());
        mv.addObject("poiData", poiDetailString);

        return mv;
    }
}
