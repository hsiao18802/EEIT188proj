package tw.com.ispan.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;


@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "order_product")
public class OrderProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_product_id")
    private Integer orderProductId;

    
    
    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order; //要 id

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;  // 對應到產品 名字 價格 id

    @Column(name = "count")
    private Integer count;  // 購買的數量


    @Column(name = "subtotal")
    private Integer subtotal;  // 小計
    
    
    @Override
    public String toString() {
        return "OrderProduct{" +
                "orderProductId=" + orderProductId +
                ", orderId=" + (order != null ? order.getOrderId() : null) +
                ", productId=" + (product != null ? product.getProductId() : null) +
                ", count=" + count +
                ", subtotal=" + subtotal +
                '}';
    }
    
    
    
}
