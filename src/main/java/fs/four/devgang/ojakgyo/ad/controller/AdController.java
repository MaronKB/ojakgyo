package fs.four.devgang.ojakgyo.ad.controller;

import fs.four.devgang.ojakgyo.ad.service.AdService;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class AdController {

    @Autowired
    private AdService adService;

    @GetMapping("/admin/ads")
    public ModelAndView ads() throws Exception {
        JSONObject adList = adService.list();

        ModelAndView mv = new ModelAndView();
        mv.setViewName("admin/ads/ads");
        mv.addObject("ads", adList);

        return mv;
    }

    @GetMapping("/api/ad/list")
    public String list() throws Exception {
        return adService.list().toString();
    }
}
