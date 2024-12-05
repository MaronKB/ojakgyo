package fs.four.devgang.ojakgyo.api.local.controller;

import fs.four.devgang.ojakgyo.api.common.service.ApiService;
import fs.four.devgang.ojakgyo.api.local.entity.Coordinate;
import fs.four.devgang.ojakgyo.api.local.entity.LocalInfo;
import fs.four.devgang.ojakgyo.api.local.service.LocalService;
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

    @GetMapping("/localInfo")
    public String getLocalInfo(HttpServletRequest request, HttpServletResponse response) throws Exception {
        LocalInfo localInfo = localService.getLocal(request, response);
        return localInfo.toJSONString();
    }

    @GetMapping("/coordinate")
    public String getCoordinate(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Coordinate coordinate = localService.getCoordinate(request, response);
        return coordinate.toJSONString();
    }
}
