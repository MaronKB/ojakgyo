package fs.four.devgang.ojakgyo.main.controller;

import fs.four.devgang.ojakgyo.api.local.entity.Coordinate;
import fs.four.devgang.ojakgyo.main.service.MainService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/main")
public class MainController {
    private static final MainService mainService = new MainService();

    @PostMapping("/result")
    public ModelAndView form(HttpServletRequest request) throws Exception {
        String myLocation = request.getParameter("my-location");
        String yourLocation = request.getParameter("your-location");
        String tags = request.getParameter("location-tags");

        Coordinate center = mainService.getCenter(myLocation, yourLocation);

        ModelAndView mv = new ModelAndView();
        mv.setViewName("main/result");
        mv.addObject("myLocation", myLocation);
        mv.addObject("yourLocation", yourLocation);
        mv.addObject("tags", tags);
        mv.addObject("centerPos", center.toJSONString());

        return mv;
    }
}
