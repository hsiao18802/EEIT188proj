package tw.com.ispan.controller;

import java.util.Base64;
import java.util.HashMap;
import java.util.List;
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
import tw.com.ispan.service.ProductService;

@RestController
@RequestMapping("/rent/product")
@CrossOrigin
public class ProductController {

    @Autowired
    private ProductService productService;

    // 查詢所有 RentBean 資料
    @GetMapping("/find")
    public List<Product> getAllRents() {
        return productService.findAll();
    }
    
    @GetMapping("/{id}")
    public Product getRentById(@PathVariable Integer id) {
        return productService.findById(id); // 直接回傳 RentBean 物件
    }
    
    // 刪除產品
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> deleteProduct(@PathVariable Integer id) {
        System.out.println("收到刪除請求，產品ID: " + id);
        boolean isDeleted = productService.deleteProduct(id);
        Map<String, Object> response = new HashMap<>();
        
        if (isDeleted) {
            System.out.println("產品刪除成功，ID: " + id);
            response.put("success", true);
            response.put("message", "產品刪除成功");
            return ResponseEntity.ok(response);
        } else {
            System.out.println("產品刪除失敗，ID: " + id);
            response.put("success", false);
            response.put("message", "產品不存在，無法刪除");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }
    
    @PostMapping("/add")
    public ResponseEntity<Map<String, Object>> addProduct(@RequestBody Product product) {
        System.out.println("收到新增產品的請求: " + product.getProductName());

        Map<String, Object> response = new HashMap<>();
        try {
            Product savedProduct = productService.addProduct(product);
            if (savedProduct != null) {
                response.put("success", true);
                response.put("message", "產品新增成功");
                response.put("productId", savedProduct.getProductId());
                return ResponseEntity.ok(response);
            } else {
                response.put("success", false);
                response.put("message", "產品新增失敗，請稍後再試");
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
            }
        } catch (Exception e) {
            System.out.println("新增產品時發生錯誤: " + e.getMessage());
            response.put("success", false);
            response.put("message", "新增產品失敗，錯誤訊息: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> updateProduct(@PathVariable("id") Integer productId, @RequestBody Product product) {
    	// 假設這裡進行產品的更新邏輯
    	Product updatedProduct = productService.updateProduct(productId, product);
    	
    	if (updatedProduct != null) {
    		// 回傳成功訊息
    		Map<String, Object> response = new HashMap<>();
    		response.put("success", true);
    		response.put("message", "產品更新成功");
    		response.put("product", updatedProduct);
    		return ResponseEntity.ok(response);
    	} else {
    		// 回傳失敗訊息
    		Map<String, Object> response = new HashMap<>();
    		response.put("success", false);
    		response.put("message", "產品更新失敗");
    		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    	}
    }
    
    // 更新產品圖片
    @PutMapping("/{id}/photo")
    public ResponseEntity<Map<String, Object>> updateProductPhoto(
            @PathVariable Integer id, 
            @RequestBody Map<String, String> request) {

        System.out.println("收到圖片更新請求，產品ID: " + id);

        try {
            // 從請求中提取 base64 格式的圖片
            String base64Photo = request.get("mainPhoto");
            if (base64Photo == null || base64Photo.isEmpty()) {
                System.out.println("圖片數據無效");
                return ResponseEntity.badRequest().body(Map.of("success", false, "message", "圖片數據無效"));
            }

            // 將 base64 字符串轉換為 byte[]
            byte[] decodedPhoto = Base64.getDecoder().decode(base64Photo);

            // 調用 Service 更新圖片
            Product updatedProduct = productService.updateProductPhoto(id, decodedPhoto);

            if (updatedProduct != null) {
                System.out.println("圖片更新成功，產品ID: " + id);
                return ResponseEntity.ok(Map.of("success", true, "message", "圖片更新成功"));
            } else {
                System.out.println("找不到產品，產品ID: " + id);
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(Map.of("success", false, "message", "找不到產品"));
            }
        } catch (Exception e) {
            System.out.println("圖片更新失敗，錯誤：" + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Map.of("success", false, "message", "圖片更新失敗"));
        }
    }

}
