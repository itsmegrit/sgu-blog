package dacn.sgublog.services.serviceImpl;

import com.cloudinary.api.ApiResponse;
import dacn.sgublog.DTOs.ArticleDTO;
import dacn.sgublog.entities.Article;
import dacn.sgublog.entities.Category;
import dacn.sgublog.entities.User;
import dacn.sgublog.repositories.ArticleRepository;
import dacn.sgublog.repositories.CategoryRepository;
import dacn.sgublog.repositories.UserRepository;
import dacn.sgublog.services.IArticleService;
import dacn.sgublog.services.IImageService;
import dacn.sgublog.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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
    @Autowired
    private IImageService imageService;

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
            dto.setCreateDate(article.getCreateDate());
            dto.setViewCount(article.getViewCount());
            return dto;
        });

        return articleDTOPage;
    }

    @Override
    public ArticleDTO findById(int id) throws Exception {
        Optional<Article> article = articleRepository.findById(id);

        Article articleEntity =  article.get();
        articleEntity.setViewCount(articleEntity.getViewCount() + 1);
        articleRepository.save(articleEntity);

        ArticleDTO dto = new ArticleDTO();
        dto.setArticleId(article.get().getArticleId());
        dto.setAuthorId(article.get().getAuthorId());
        dto.setTitle(article.get().getTitle());
        dto.setContent(article.get().getContent());
        dto.setAuthorName(userService.findUserById(article.get().getAuthorId()).get().getFirstName());
        dto.setCreateDate(article.get().getCreateDate());
        dto.setViewCount(article.get().getViewCount());
        dto.setUpdateDate(article.get().getUpdateDate());
        dto.setStatus(article.get().getStatus());

        String imgUrl = imageService.getFile("210002.jpeg").get("url").toString();

        dto.setImgUrl(imgUrl);
        return dto;
    }

    @Override
    public boolean save(Article article, MultipartFile file) throws IOException {
        Date currentDate = new Date();
        article.setCreateDate(currentDate);

        String originalFileName = file.getOriginalFilename();
        String extension = originalFileName.substring(originalFileName.lastIndexOf("."));
        articleRepository.save(article);
        String fileName = article.getArticleId() + extension;
        imageService.upload(file, fileName);
        return true;
    }

    @Override
    public boolean update(Article article) {
        Date currentDate = new Date();
        article.setUpdateDate(currentDate);
        Optional<Article> articleEntity = articleRepository.findById(article.getArticleId());
        article.setCreateDate(articleEntity.get().getCreateDate());
        articleRepository.save(article);
        return true;
    }

    @Override
    public boolean delete(int id) {
        articleRepository.deleteById(id);
        return true;
    }
}