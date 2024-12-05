package fs.four.devgang.ojakgyo.api.juso.service;

import fs.four.devgang.ojakgyo.api.common.service.ApiService;
import fs.four.devgang.ojakgyo.api.juso.entity.Juso;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Service;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@Service
public class JusoService {
    private static final ApiService apiService = new ApiService();

    public String getJuso(HttpServletRequest request) throws Exception {
        String currentPage = request.getParameter("currentPage");
        String countPerPage = request.getParameter("countPerPage");
        String keyword = request.getParameter("keyword");

        StringBuilder apiUrl = new StringBuilder("https://business.juso.go.kr/addrlink/addrLinkApi.do?");

        apiUrl.append("currentPage=");
        apiUrl.append(currentPage);
        apiUrl.append("&countPerPage=");
        apiUrl.append(countPerPage);
        apiUrl.append("&keyword=");
        apiUrl.append(URLEncoder.encode(keyword, StandardCharsets.UTF_8));
        apiUrl.append("&confmKey=devU01TX0FVVEgyMDI0MTIwNDEwMjU1NTExNTI5NDk%3D");
        apiUrl.append("&resultType=json");

        URL url = new URL(apiUrl.toString());
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

        return apiService.getApi(urlConnection);
    }
}
