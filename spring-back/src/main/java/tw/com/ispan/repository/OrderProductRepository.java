package tw.com.ispan.repository;

import java.util.List;
import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tw.com.ispan.domain.OrderProduct;

@Repository
public interface OrderProductRepository extends JpaRepository<OrderProduct, Integer> {
	
	@Query("SELECT op FROM OrderProduct op JOIN op.order o WHERE op.product.productId = :productId AND " +
		       "(:dateA BETWEEN o.rentalStartDate AND o.rentalEndDate OR :dateB BETWEEN o.rentalStartDate AND o.rentalEndDate " +
		       "OR o.rentalStartDate BETWEEN :dateA AND :dateB)")
		List<OrderProduct> findByProductIdAndDates(@Param("productId") Integer productId, 
		                                           @Param("dateA") LocalDate dateA, 
		                                           @Param("dateB") LocalDate dateB);
    
    // 根據 product_id 查詢是否存在
    boolean existsByProduct_ProductId(Integer productId);
	
}