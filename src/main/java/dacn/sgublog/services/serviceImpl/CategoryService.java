package dacn.sgublog.services.serviceImpl;

import dacn.sgublog.entities.Category;
import dacn.sgublog.repositories.CategoryRepository;
import dacn.sgublog.services.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CategoryService implements ICategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public Iterable<Category> findAll() {
        return categoryRepository.findAll();
    }
}
