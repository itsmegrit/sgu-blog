package dacn.sgublog.serviceImpl;

import dacn.sgublog.entities.Article;
import dacn.sgublog.repositories.ArticleRepository;
import dacn.sgublog.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleRepository articleRepository;
    @Override
    public List<Article> findAllArticles() {
        return articleRepository.findAll();
    }
}
