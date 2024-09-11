package tw.com.ispan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import tw.com.ispan.domain.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
