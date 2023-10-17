package dacn.sgublog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomePageController {
    @GetMapping(value = "")
    public String homePage(){
        return "homePage";
    }
}
