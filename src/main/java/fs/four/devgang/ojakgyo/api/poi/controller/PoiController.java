package fs.four.devgang.ojakgyo.api.poi.controller;

import fs.four.devgang.ojakgyo.api.poi.service.PoiService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/poi")
public class PoiController {
    private static final PoiService poiService = new PoiService();

    @GetMapping("/test")
    public String get(HttpServletRequest request) throws Exception {
        return poiService.getPOIData(request);
    }
}
