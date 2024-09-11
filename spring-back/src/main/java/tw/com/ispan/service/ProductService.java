package tw.com.ispan.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.com.ispan.domain.Product;
import tw.com.ispan.repository.ProductRepository;

@Service
@Transactional
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    // 查詢所有資料
    public List<Product> findAll() {
        return productRepository.findAll();
    }
    
    // 根據 ID 查詢
    public Product findById(Integer id) {
        Optional<Product> rentBean = productRepository.findById(id);
        return rentBean.orElse(null); // 如果找不到，返回 null
    }
    // 更新產品資訊
    public Product updateProduct(Integer productId, Product updatedProduct) {
        // 根據 productId 查詢產品
        Optional<Product> optionalProduct = productRepository.findById(productId);

        if (optionalProduct.isPresent()) {
            Product existingProduct = optionalProduct.get();

            // 更新產品資訊
            existingProduct.setProductName(updatedProduct.getProductName());
            existingProduct.setDailyFeeOriginal(updatedProduct.getDailyFeeOriginal());
            existingProduct.setMaxAvailableQuantity(updatedProduct.getMaxAvailableQuantity());
            existingProduct.setDescription(updatedProduct.getDescription());
            existingProduct.setCategoryId(updatedProduct.getCategoryId());
            
         // 設定最後更新時間為當前時間
            existingProduct.setLastUpdateDatetime(new Date());

            // 將更新後的產品儲存至資料庫
            return productRepository.save(existingProduct);
        } else {
            return null; // 找不到產品則回傳 null
        }
    }
    // 刪除產品
    public boolean deleteProduct(Integer productId) {
        try {
            Optional<Product> optionalProduct = productRepository.findById(productId);
            if (optionalProduct.isPresent()) {
                productRepository.deleteById(productId);
                System.out.println("產品刪除成功，ID: " + productId);
                return true;
            } else {
                System.out.println("找不到產品，ID: " + productId);
                return false;
            }
        } catch (Exception e) {
            System.err.println("刪除產品時發生錯誤: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
    
    public Product addProduct(Product product) {
        System.out.println("準備新增產品: " + product.getProductName());
        try {
            // 儲存產品
        	product.setAddDatetime(new Date());
            Product savedProduct = productRepository.save(product);
            System.out.println("產品新增成功: " + savedProduct.getProductId());
            return savedProduct;
        } catch (Exception e) {
            System.out.println("產品新增失敗: " + e.getMessage());
            return null;
        }
    }
    
    public Product updateProductPhoto(Integer productId, byte[] newPhoto) {
        // 根據 productId 查詢產品
        Optional<Product> optionalProduct = productRepository.findById(productId);

        if (optionalProduct.isPresent()) {
            Product existingProduct = optionalProduct.get();

            // 更新圖片
            existingProduct.setMainPhoto(newPhoto);
            Product updatedProduct = productRepository.save(existingProduct);

            System.out.println("產品圖片更新成功，產品ID: " + productId);

            return updatedProduct;
        } else {
            System.out.println("產品圖片更新失敗，找不到該產品，ID: " + productId);
            return null; // 找不到產品，回傳 null
        }
    }
}
