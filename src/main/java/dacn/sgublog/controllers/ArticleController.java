package dacn.sgublog.controllers;

import dacn.sgublog.entities.Article;
import dacn.sgublog.serviceImpl.ArticleServiceImpl;
import dacn.sgublog.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @GetMapping(value = "/article")
    public String listArticles(Model model) {
        List<Article> articles = articleService.findAllArticles();
        model.addAttribute("articles", articles);
        return "homePage";
    }
}
