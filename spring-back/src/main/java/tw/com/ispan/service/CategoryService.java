package tw.com.ispan.service;

import java.util.Date;
import java.util.List;
import java.util.Locale.Category;
import java.util.Optional;

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

    // 找全部
    public List<ProductCategory> findAllCategories() {
        return categoryRepository.findAll();
    }
    
    // 刪除
    @Transactional
    public String deleteCategoryAndRearrangeSequence(Integer categoryId) {
        try {
            // 1. 找出該筆資料的 displaySequence 值
            ProductCategory category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new IllegalArgumentException("該 ID 的資料不存在"));
            Integer x = category.getDisplaySequence();

            // 2. 找出所有 displaySequence 大於 x 的資料
            List<ProductCategory> categories = categoryRepository.findByDisplaySequenceGreaterThan(x);

            // 3. 把這些資料的 displaySequence 都減一
            for (ProductCategory c : categories) {
                c.setDisplaySequence(c.getDisplaySequence() - 1);
                categoryRepository.save(c); // 保存更改
            }

            // 4. 最後才真的刪掉該筆資料
            categoryRepository.deleteById(categoryId);

            // 如果成功，回傳成功訊息
//            return "刪除成功，並已重新排列序列！";
            return "刪除成功！";

        } catch (Exception e) {
            // 若有任何錯誤，回滾並拋出錯誤
            throw new RuntimeException("刪除過程中發生錯誤：" + e.getMessage());
        }
    }
    
 // 更新產品資訊
    @Transactional
    public String updateCategoryName(Integer categoryId, String newCategoryName) {
        // 找出指定 categoryId 的分類
        Optional<ProductCategory> categoryOptional = categoryRepository.findById(categoryId);
        if (categoryOptional.isPresent()) {
            ProductCategory category = categoryOptional.get();
            // 更新 categoryName
            category.setCategoryName(newCategoryName);
            // 保存更新後的資料
            categoryRepository.save(category);
            return "更新成功";
        } else {
            throw new RuntimeException("該分類不存在，無法更新");
        }
    }
}
