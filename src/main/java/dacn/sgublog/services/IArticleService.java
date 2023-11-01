package dacn.sgublog.services;

import dacn.sgublog.DTOs.ArticleDTO;
import dacn.sgublog.entities.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public interface IArticleService {
   public List<Article> findAllArticles();
   public Page<ArticleDTO> findAllArticles(Pageable pageable);
   public ArticleDTO findById(int id) throws Exception;
   public boolean save(Article article, MultipartFile file) throws IOException;

   public boolean update(Article article);
   public boolean delete(int id);
}
