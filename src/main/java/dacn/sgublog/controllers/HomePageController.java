package dacn.sgublog.controllers;

import dacn.sgublog.DTOs.ArticleDTO;
import dacn.sgublog.entities.Article;
import dacn.sgublog.services.IArticleService;
import dacn.sgublog.services.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class HomePageController {

    @Autowired
    private IArticleService IArticleService;

    @GetMapping(value = {"home", "/"})
    public String homePage(Model model, @RequestParam(value = "page", defaultValue = "1") int page, @RequestParam(value = "size", defaultValue = "4") int size) {
        Sort sort = Sort.by(Sort.Direction.DESC, "articleId");
        Pageable pageable = PageRequest.of(page - 1, size, sort);
        Page<ArticleDTO> articles = IArticleService.findAllArticles(pageable);
        model.addAttribute("articles", articles);
        return "home/homePage";
    }
}
