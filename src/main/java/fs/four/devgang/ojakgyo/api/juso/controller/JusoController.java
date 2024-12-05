package fs.four.devgang.ojakgyo.api.juso.controller;

import fs.four.devgang.ojakgyo.api.juso.service.JusoService;
import fs.four.devgang.ojakgyo.api.juso.entity.Juso;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/juso")
@SessionAttributes(types = Juso.class)
public class JusoController {
    private static final JusoService jusoService = new JusoService();

    @PostMapping ("/getAddr.do")
    public String getAddr(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String juso = jusoService.getJuso(request);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().print(juso);

        return juso;
    }
}
