package fs.four.devgang.ojakgyo.api.common.service;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;

@Service("apiService")
public class ApiService {
    public void getApi(URL url, HttpServletResponse response) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream(), StandardCharsets.UTF_8));
        StringBuilder sb = new StringBuilder();
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
