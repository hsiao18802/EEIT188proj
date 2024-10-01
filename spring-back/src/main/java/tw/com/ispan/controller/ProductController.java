package tw.com.ispan.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
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
    
    // 帶分頁的複雜搜尋
    @PostMapping("/find-advanced")
    public ResponseEntity<Map<String, Object>> findProducts(@RequestBody String json) {
        // 打印收到的前端 JSON
        System.out.println("Received JSON from frontend: " + json);

        try {
            JSONObject obj = new JSONObject(json);

            // 打印解析出的查詢條件
            System.out.println("Parsed 'name' from JSON: " + obj.optString("name"));
            System.out.println("Parsed 'categoryId' from JSON: " + obj.optInt("categoryId", -1));
            System.out.println("Parsed 'start' from JSON: " + obj.optInt("start"));
            System.out.println("Parsed 'max' from JSON: " + obj.optInt("max"));

            // 查詢產品列表和總數
            List<Product> products = productService.findProducts(obj);
            Long count = productService.countProducts(obj);

            // 打印查詢結果
            System.out.println("Products found: " + products.size());
            System.out.println("Total count: " + count);

            Map<String, Object> response = new HashMap<>();
            response.put("list", products);
            response.put("count", count);

            return ResponseEntity.ok(response);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error occurred while processing the request.");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
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
    
    // 下架商品
    @PutMapping("/{id}/discontinue")
    public ResponseEntity<?> discontinueProduct(@PathVariable("id") Integer productId) {
    	Product discontinueProduct = productService.discontinueProduct(productId);
    	
    	if (discontinueProduct != null) {
    		// 回傳成功訊息
    		Map<String, Object> response = new HashMap<>();
    		response.put("success", true);
    		response.put("message", "產品更新成功");
    		response.put("product", discontinueProduct);
    		return ResponseEntity.ok(response);
    	} else {
    		// 回傳失敗訊息
    		Map<String, Object> response = new HashMap<>();
    		response.put("success", false);
    		response.put("message", "產品更新失敗");
    		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
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
    
    // ------
    
    // 接收前端傳來的日期和 productId
    @PostMapping("/check-availability")
    public ResponseEntity<Integer> checkAvailability(@RequestBody CheckAvailabilityRequest request) {
    	
    	System.out.println("查詢 啟動");
        System.out.println("前端傳來的 DateA: " + request.getDateA());
        System.out.println("前端傳來的 DateB: " + request.getDateB());
        System.out.println("前端傳來的 ProductId: " + request.getProductId());
    	
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        
        // 將字串日期轉換為 LocalDate
        LocalDate dateA = LocalDate.parse(request.getDateA(), formatter);
        LocalDate dateB = LocalDate.parse(request.getDateB(), formatter);
        Integer productId = request.getProductId();

        // 使用 System.out.println 進行除錯
        System.out.println("Received check-availability request - DateA: " + dateA + ", DateB: " + dateB + ", ProductId: " + productId);

        // 調用 Service 來計算可用庫存
        Integer availableQuantity = productService.calculateAvailableQuantity(productId, dateA, dateB);

        // 使用 System.out.println 打印計算出的可用庫存
        System.out.println("Available quantity for ProductId " + productId + " between " + dateA + " and " + dateB + ": " + availableQuantity);

        // 回傳剩餘庫存
        return ResponseEntity.ok(availableQuantity);
    }

    // 用來接收前端傳來的資料
    public static class CheckAvailabilityRequest {
        private String dateA;
        private String dateB;
        private Integer productId;

        // Getters and Setters
        public String getDateA() {
            return dateA;
        }

        public void setDateA(String dateA) {
            this.dateA = dateA;
        }

        public String getDateB() {
            return dateB;
        }

        public void setDateB(String dateB) {
            this.dateB = dateB;
        }

        public Integer getProductId() {
            return productId;
        }

        public void setProductId(Integer productId) {
            this.productId = productId;
        }
    }
    
    // 根據 categoryId 查找產品
    @GetMapping("/findByCategory/{categoryId}")
    public ResponseEntity<List<Product>> getProductsByCategoryId(@PathVariable Integer categoryId) {
        List<Product> products = productService.findByCategoryId(categoryId);
        return ResponseEntity.ok(products);
    }
    
    // 根據 categoryId 計算產品數量
    @GetMapping("/countByCategory/{categoryId}")
    public ResponseEntity<Long> countProductsByCategoryId(@PathVariable Integer categoryId) {
        Long count = productService.countByCategoryId(categoryId);
        return ResponseEntity.ok(count);
    }

}
