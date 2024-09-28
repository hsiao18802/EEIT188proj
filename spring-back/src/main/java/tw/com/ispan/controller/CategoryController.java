package tw.com.ispan.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Locale.Category;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.com.ispan.domain.Product;
import tw.com.ispan.domain.ProductCategory;
import tw.com.ispan.service.CategoryService;

@RestController
@RequestMapping("/rent/category")
@CrossOrigin
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    // 查詢所有 category 資料
    @GetMapping("/find")
    public ResponseEntity<List<ProductCategory>> getAllCategories() {
        List<ProductCategory> categories = categoryService.findAllCategories();
        return ResponseEntity.ok(categories);
    }
    
    // 刪除
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> deleteProductCategory(@PathVariable Integer id) {
        Map<String, Object> response = new HashMap<>();
        try {
            // 呼叫 Service 刪除並重新排列順序
            String result = categoryService.deleteCategoryAndRearrangeSequence(id);
            
            // 構建成功的回應
            response.put("success", true);
            response.put("message", result);
            return ResponseEntity.ok(response);
        } catch (RuntimeException e) {
            // 構建失敗的回應
            response.put("success", false);
            response.put("message", e.getMessage());
            return ResponseEntity.status(500).body(response);
        }
    }
    
    // 修改
    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> updateCategory(@PathVariable Integer id, @RequestBody Map<String, String> updateData) {
    	Map<String, Object> response = new HashMap<>();
    	try {
            String newCategoryName = updateData.get("categoryName");
            String result = categoryService.updateCategoryName(id, newCategoryName);
            response.put("success", true);
            response.put("message", result);
            return ResponseEntity.ok(response);
        } catch (RuntimeException e) {
        	response.put("success", false);
            response.put("message", e.getMessage());
            return ResponseEntity.status(500).body(response);
        }
    }
}
