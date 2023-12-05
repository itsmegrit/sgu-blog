package dacn.sgublog.controllers;

import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "login")
public class LoginController {
    @GetMapping(name = "")
    public String loginPage(Model model){
        return "/login";
    }
}
