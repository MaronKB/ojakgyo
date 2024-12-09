package fs.four.devgang.ojakgyo.api.naver.controller;

import fs.four.devgang.ojakgyo.api.common.service.ApiService;
import fs.four.devgang.ojakgyo.api.naver.entity.Coordinate;
import fs.four.devgang.ojakgyo.api.naver.entity.LocalInfo;
import fs.four.devgang.ojakgyo.api.naver.service.CoordinateService;
import fs.four.devgang.ojakgyo.api.naver.service.LocalService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/local")
public class LocalController {
    @Resource(name = "apiService")
    private final ApiService apiService = new ApiService();

    @Resource(name = "localService")
    private final LocalService localService = new LocalService();

    @Resource(name = "coordinateService")
    private final CoordinateService coordinateService = new CoordinateService();

    @GetMapping("/localInfo")
    public String getLocalInfo(HttpServletRequest request, HttpServletResponse response) throws Exception {
        LocalInfo localInfo = localService.getLocalInfo(request, response);
        return localInfo.toJSONString();
    }

    @GetMapping("/coordinate")
    public String getCoordinate(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Coordinate coordinate = coordinateService.getCoordinate(request, response);
        return coordinate.toJSONString();
    }
}
