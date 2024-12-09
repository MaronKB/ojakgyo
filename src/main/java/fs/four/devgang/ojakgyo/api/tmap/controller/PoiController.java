package fs.four.devgang.ojakgyo.api.tmap.controller;

import fs.four.devgang.ojakgyo.api.tmap.service.PoiService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/poi")
public class PoiController {
    private static final PoiService poiService = new PoiService();
}
