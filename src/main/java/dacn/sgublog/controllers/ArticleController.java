package dacn.sgublog.controllers;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
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
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(path = "article")
public class ArticleController {
    @Autowired
    private IArticleService articleService;


    @GetMapping(value = "/view")
    public String listArticles(Model model, @RequestParam(value = "page", defaultValue = "1") int page, @RequestParam(value = "size", defaultValue = "4") int size) {
        Sort sort = Sort.by(Sort.Direction.DESC, "articleId");
        Pageable pageable = PageRequest.of(page - 1, size, sort);
        Page<ArticleDTO> articles = articleService.findAllArticles(pageable);
        model.addAttribute("articles", articles);
        return "home/homePage";
    }

    @GetMapping(value = "/view/{id}")
    public String viewArticle(Model model, @PathVariable int id) throws Exception {
        model.addAttribute("article", articleService.findById(id));
        return "home/article";
    }

    @GetMapping("/create")
    public String createArticle(Model model) {
        model.addAttribute("article", new Article());
        return "admin/createArticle";
    }

    @PostMapping("/create")
    public String createArticle(@ModelAttribute Article article, @RequestParam("file") MultipartFile file) throws IOException {
        articleService.save(article, file);
        return "redirect:/article/view/" + article.getArticleId();
    }

    @GetMapping("/edit/{id}")
    public String updateArticle(@PathVariable int id, Model model) throws Exception {
        model.addAttribute("article", articleService.findById(id));
        return "admin/editArticle";
    }

    @PostMapping("/edit/{id}")
    public String updateArticle(@PathVariable int id, @ModelAttribute Article article){
        articleService.update(article);
        return "redirect:/article/view/" + article.getArticleId();
    }

    @PostMapping(value = "/delete/{id}")
    public String deleteArticle(@PathVariable int id){
        articleService.delete(id);
        return "redirect:/admin/article";
    }
}
