package fs.four.devgang.ojakgyo.api.juso.controller;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import fs.four.devgang.ojakgyo.api.common.service.ApiService;
import fs.four.devgang.ojakgyo.api.juso.service.JusoService;
import fs.four.devgang.ojakgyo.api.juso.service.JusoServiceImpl;
import fs.four.devgang.ojakgyo.api.juso.entity.Juso;
import fs.four.devgang.ojakgyo.api.juso.entity.JusoSearch;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/juso")
@SessionAttributes(types= Juso.class)
public class JusoController {
    @Resource(name = "jusoService")
    private final JusoService jusoService = new JusoServiceImpl();

    @Resource(name = "apiService")
    private final ApiService apiService = new ApiService();

    @PostMapping ("/getAddr.do")
    public void getAddr(@ModelAttribute("searchVO") JusoSearch search, HttpServletRequest req, HttpServletResponse response) throws Exception {

        String currentPage = req.getParameter("currentPage");
        String countPerPage = req.getParameter("countPerPage");
        String keyword = req.getParameter("keyword");

        StringBuilder apiUrl = new StringBuilder("https://business.juso.go.kr/addrlink/addrLinkApi.do?");

        apiUrl.append("currentPage=");
        apiUrl.append(currentPage);
        apiUrl.append("&countPerPage=");
        apiUrl.append(countPerPage);
        apiUrl.append("&keyword=");
        apiUrl.append(URLEncoder.encode(keyword, StandardCharsets.UTF_8));
        apiUrl.append("&confmKey=devU01TX0FVVEgyMDI0MTIwNDEwMjU1NTExNTI5NDk%3D");
        apiUrl.append("&resultType=json");

        apiService.getApi(new URL(apiUrl.toString()), response);
    }
}
