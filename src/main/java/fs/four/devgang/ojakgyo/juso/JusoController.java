package fs.four.devgang.ojakgyo.juso;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/juso")
@SessionAttributes(types=Juso.class)
public class JusoController {
    @Resource(name = "jusoService")
    private  JusoService jusoService;

    @PostMapping ("/getAddr.do")
    public void getAddr(@ModelAttribute("searchVO") JusoSearch search, HttpServletRequest req, ModelMap model, HttpServletResponse response) throws Exception {

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

        URL url = new URL(apiUrl.toString());

        BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream(),"UTF-8"));
        StringBuffer sb = new StringBuffer();
        String tempStr = null;

        while(true){
            tempStr = br.readLine();
            if(tempStr == null) break;
            sb.append(tempStr);
        }

        br.close();

        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        response.getWriter().write(sb.toString());
    }
}
