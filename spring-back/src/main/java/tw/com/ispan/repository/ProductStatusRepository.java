package tw.com.ispan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tw.com.ispan.domain.ProductStatus;

@Repository
public interface ProductStatusRepository extends JpaRepository<ProductStatus, Integer> {
}
