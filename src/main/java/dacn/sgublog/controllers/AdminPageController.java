package dacn.sgublog.controllers;

import dacn.sgublog.entities.Article;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "admin")
public class AdminPageController {
    @GetMapping(value = "")
    public String adminPage(){
        return  "admin/adminPage";
    }

    @GetMapping(value = "/blog")
    public String blogCrud(Model model){
        model.addAttribute("article", new Article());
        return "admin/adminPage";
    }
}
