package dacn.sgublog.controllers;

import dacn.sgublog.entities.Article;
import dacn.sgublog.services.IArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "admin")
public class AdminPageController {
    @Autowired
    private IArticleService articleService;
    @GetMapping(value = "")
    public String adminPage(){
        return  "admin/adminPage";
    }

    @GetMapping(value = "/article")
    public String blogCrud(Model model){
        model.addAttribute("articles", articleService.findAllArticles());
        return "admin/adminPage";
    }
}
