package dacn.sgublog.services;

import dacn.sgublog.DTOs.ArticleDTO;
import dacn.sgublog.entities.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IArticleService {
   public List<Article> findAllArticles();
   public Page<ArticleDTO> findAllArticles(Pageable pageable);
   public ArticleDTO findById(int id);
   public boolean save(Article article);

   public boolean update(Article article);
   public boolean delete(int id);
}
