package dacn.sgublog.services.serviceImpl;

import dacn.sgublog.entities.Article;
import dacn.sgublog.repositories.ArticleRepository;
import dacn.sgublog.services.IArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ArticleService implements IArticleService {
    @Autowired
    private ArticleRepository articleRepository;
    @Override
    public List<Article> findAllArticles() {
        return articleRepository.findAll();
    }
}