package dacn.sgublog.controllers;

import dacn.sgublog.entities.Article;
import dacn.sgublog.services.IArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ArticleController {
    @Autowired
    private IArticleService IArticleService;

    @GetMapping(value = "/article")
    public String listArticles(Model model) {
        List<Article> articles = IArticleService.findAllArticles();
        model.addAttribute("articles", articles);
        return "homePage";
    }
}
