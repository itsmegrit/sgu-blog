package dacn.sgublog.services;

import dacn.sgublog.entities.Article;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IArticleService {
   public List<Article> findAllArticles();
}
