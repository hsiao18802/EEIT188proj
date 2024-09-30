package tw.com.ispan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import tw.com.ispan.domain.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
	
    // 查詢對應 productId 的 maxAvailableQuantity
    @Query("SELECT p.maxAvailableQuantity FROM Product p WHERE p.productId = :productId")
    Integer findMaxAvailableQuantity(@Param("productId") Integer productId);
    
}
