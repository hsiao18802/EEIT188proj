package tw.com.ispan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.com.ispan.domain.ProductCategory;
import tw.com.ispan.repository.ProductCategoryRepository;

@Service
@Transactional
public class CategoryService {

    @Autowired
    private ProductCategoryRepository categoryRepository;

    public List<ProductCategory> findAllCategories() {
        return categoryRepository.findAll();
    }
}
