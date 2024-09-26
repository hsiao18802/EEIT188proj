package tw.com.ispan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tw.com.ispan.domain.Discount;

public interface DiscountRepository extends JpaRepository<Discount, Integer> {
    Discount findByCode(String code);
}