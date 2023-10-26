package dacn.sgublog.controllers;

import dacn.sgublog.DTOs.ArticleDTO;
import dacn.sgublog.entities.Article;
import dacn.sgublog.services.IArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.jaxb.SpringDataJaxb;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "article")
public class ArticleController {
    @Autowired
    private IArticleService articleService;

    @GetMapping(value = "")
    public String listArticles(Model model, @RequestParam(value = "page", defaultValue = "1") int page, @RequestParam(value = "size", defaultValue = "4") int size) {
        Pageable pageable = PageRequest.of(page - 1, size);
        Page<ArticleDTO> articles = articleService.findAllArticles(pageable);
        model.addAttribute("articles", articles);
        return "home/homePage";
    }

    @GetMapping(value = "/{id}")
    public String viewArticle(Model model, @PathVariable int id){
        model.addAttribute("article", articleService.findById(id));
        return "home/article";
    }

    @GetMapping("/create")
    public String createArticle(Model model) {
        model.addAttribute("article", new Article());
        return "article/create";
    }

    @PostMapping("/create")
    public String createArticle(@ModelAttribute Article article) {
        articleService.save(article);
        return "redirect:/article/" + article.getArticleId();
    }
}
