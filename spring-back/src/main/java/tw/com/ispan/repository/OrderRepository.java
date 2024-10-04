package tw.com.ispan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tw.com.ispan.domain.Members;
import tw.com.ispan.domain.Order;
import tw.com.ispan.domain.OrderStatus;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
    List<Order> findByMembers(Members members); // 直接查詢 Members 對象
    Optional<Order> findByMerchantTradeNo(String merchantTradeNo); // 查詢MerchantTradeNo
    List<Order> findByOrderStatusAndOrderDateBefore(OrderStatus status, LocalDateTime dateTime);



}
