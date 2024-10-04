package tw.com.ispan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import tw.com.ispan.domain.ProductCategory;

@Repository
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Integer> {
	
    // 查詢出 displaySequence 大於 x 的資料
    @Query("SELECT pc FROM ProductCategory pc WHERE pc.displaySequence > :x")
    List<ProductCategory> findByDisplaySequenceGreaterThan(Integer x);

    // 刪除一筆資料
    @Modifying
    @Transactional
    @Query("DELETE FROM ProductCategory pc WHERE pc.categoryId = :categoryId")
    void deleteById(Integer categoryId);
    
    List<ProductCategory> findAllByOrderByDisplaySequenceAsc();
}
