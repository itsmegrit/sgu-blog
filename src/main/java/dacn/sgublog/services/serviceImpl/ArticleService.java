package dacn.sgublog.services.serviceImpl;

import dacn.sgublog.DTOs.ArticleDTO;
import dacn.sgublog.entities.Article;
import dacn.sgublog.entities.Category;
import dacn.sgublog.entities.User;
import dacn.sgublog.repositories.ArticleRepository;
import dacn.sgublog.repositories.CategoryRepository;
import dacn.sgublog.repositories.UserRepository;
import dacn.sgublog.services.IArticleService;
import dacn.sgublog.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Component
public class ArticleService implements IArticleService {
    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private IUserService userService;

    @Override
    public List<Article> findAllArticles() {
        return articleRepository.findAll();
    }


    @Override
    public Page<ArticleDTO> findAllArticles(Pageable pageable) {
        Page<Article> articles = articleRepository.findAll(pageable);
        int totalPages;

        // Chuyển từ Entity Article sang DTO ArticleDTO
        Page<ArticleDTO> articleDTOPage = articles.map(article -> {
            ArticleDTO dto = new ArticleDTO();
            dto.setArticleId(article.getArticleId());
            dto.setTitle(article.getTitle());
            dto.setContent(article.getContent());
            dto.setAuthorName(userService.findUserById(article.getAuthorId()).get().getFirstName());
//            Optional<Category> optionalCategory = categoryRepository.findById(article.getCategoryId());
//            if (optionalCategory.isPresent()) {
//                Category category = optionalCategory.get();
//                dto.setCategoryName(category.getCategoryName());
//            }
            dto.setCreateDate(article.getCreateDate());
            dto.setViewCount(article.getViewCount());
            return dto;
        });

        return articleDTOPage;
    }

    @Override
    public ArticleDTO findById(int id) {
        Optional<Article> article = articleRepository.findById(id);

        Article articleEntity =  article.get();
        articleEntity.setViewCount(articleEntity.getViewCount() + 1);
        articleRepository.save(articleEntity);

        ArticleDTO dto = new ArticleDTO();
        dto.setArticleId(article.get().getArticleId());
        dto.setTitle(article.get().getTitle());
        dto.setContent(article.get().getContent());
        dto.setAuthorName(userService.findUserById(article.get().getAuthorId()).get().getFirstName());
//            Optional<Category> optionalCategory = categoryRepository.findById(article.getCategoryId());
//            if (optionalCategory.isPresent()) {
//                Category category = optionalCategory.get();
//                dto.setCategoryName(category.getCategoryName());
//            }
        dto.setCreateDate(article.get().getCreateDate());
        dto.setViewCount(article.get().getViewCount());
        return dto;
    }

    @Override
    public boolean save(Article article) {
        Date currentDate = new Date();
        article.setCreateDate(currentDate);
        articleRepository.save(article);
        return true;
    }
}