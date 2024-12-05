package fs.four.devgang.ojakgyo.api.local.controller;

import fs.four.devgang.ojakgyo.api.common.service.ApiService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URL;

@RestController
@RequestMapping("api/local")
public class LocalController {
    @Resource(name = "apiService")
    private final ApiService apiService = new ApiService();

    @GetMapping("/naver")
    public void naver(HttpServletRequest req, HttpServletResponse response) throws Exception {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Host", "openapi.naver.com");
        headers.add("User-Agent", "curl/7.49.1");
        headers.add("Accept", "*/*");
        headers.add("X-Naver-Client-Id", "Xs8udJjhMhH_I_6pLk3F");
        headers.add("X-Naver-Client-Secret", "hMAAjvehvN");

        String query = req.getParameter("query");
        String display = req.getParameter("display");
        String start = req.getParameter("start");
        String sort = req.getParameter("sort");

        StringBuilder apiUrl = new StringBuilder("https://openapi.naver.com/v1/search/local.json?");
        apiUrl.append("query=");
        apiUrl.append(query);
        apiUrl.append("&display=");
        apiUrl.append(display);
        apiUrl.append("&start=");
        apiUrl.append(start);
        apiUrl.append("&sort=");
        apiUrl.append(sort);

        apiService.getApi(new URL(apiUrl.toString()), response);
    }
}
