package dacn.sgublog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "user")
public class UserController {
    @GetMapping(value = "")
    public String userPage(){
        return "user/userPage";
    }
}
