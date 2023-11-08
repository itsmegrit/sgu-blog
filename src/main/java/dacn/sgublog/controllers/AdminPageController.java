package dacn.sgublog.controllers;

import dacn.sgublog.DTOs.ArticleDTO;
import dacn.sgublog.DTOs.UserDTO;
import dacn.sgublog.entities.Article;
import dacn.sgublog.entities.User;
import dacn.sgublog.services.IArticleService;
import dacn.sgublog.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(path = "admin")
public class AdminPageController {
    @Autowired
    private IArticleService articleService;
    @Autowired
    private IUserService userService;
    @GetMapping(value = "")
    public String adminPage(){
        return  "admin/adminPage";
    }

    @GetMapping(value = "/article")
    public String blogCrud(Model model, @RequestParam(value = "page", defaultValue = "1") int page, @RequestParam(value = "size", defaultValue = "5") int size){
        Sort sort = Sort.by(Sort.Direction.DESC, "articleId");
        Pageable pageable = PageRequest.of(page - 1, size, sort);
        Page<ArticleDTO> articles = articleService.findAllArticles(pageable);
        model.addAttribute("articles", articles);
        return "admin/adminPage";
    }

    @GetMapping(value = "/user")
    public String userCrud(Model model, @RequestParam(value = "page", defaultValue = "1") int page, @RequestParam(value = "size", defaultValue = "5") int size){
        Sort sort = Sort.by(Sort.Direction.DESC, "userId");
        Pageable pageable = PageRequest.of(page - 1, size, sort);
        Page<UserDTO> users = userService.findAll(pageable);
        model.addAttribute("users", users);
        return  "admin/adminPage";
    }
}
