package fs.four.devgang.ojakgyo.ad.controller;

import fs.four.devgang.ojakgyo.ad.service.AdService;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AdController {

    @Autowired
    private AdService adService;

    @GetMapping("/api/ad/{adId}")
    public String selectById(@PathVariable int adId) throws Exception {
        return adService.selectAdById(adId).toJSONString();
    }

    @PostMapping("/api/ad")
    public int insert(@RequestBody String body) throws Exception {
        JSONParser jsonParser = new JSONParser();
        JSONObject adJSON = (JSONObject) jsonParser.parse(body);
        return adService.insert(adJSON);
    }

    @PatchMapping("/api/ad/{adId}")
    public int update(@PathVariable int adId, @RequestBody String body) throws Exception {
        JSONParser jsonParser = new JSONParser();
        JSONObject adJSON = (JSONObject) jsonParser.parse(body);
        return adService.update(adId, adJSON);
    }

    @DeleteMapping("/api/ad/{adId}")
    public int delete(@PathVariable int adId) throws Exception {
        return adService.delete(adId);
    }

    @GetMapping("/api/ads")
    public String selectAll() throws Exception {
        return adService.selectAllAdList().toJSONString();
    }

    @GetMapping("/api/ads/{valid}")
    public String selectByValid(@PathVariable char valid) throws Exception {
        return adService.selectAdListByValid(valid).toJSONString();
    }
}
