package dacn.sgublog.services;

import dacn.sgublog.entities.Category;
import org.springframework.stereotype.Service;

@Service
public interface ICategoryService {
    public Iterable<Category> findAll();
}
