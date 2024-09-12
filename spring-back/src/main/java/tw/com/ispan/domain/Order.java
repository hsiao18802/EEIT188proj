package tw.com.ispan.domain;

import java.util.Date;
import java.util.List;
import tw.com.ispan.domain.Order;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "order")  
public class Order {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Integer orderId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "members_id")
    private Members members;  // 對應到會員
    
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderProduct> orderProduct;  // 每個訂單對應的產品明細

    @Column(name = "order_creation_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date orderDate;

    @Column(name = "total_price_amount")
    private Integer totalPrice;

    @Column(name = "shipping_fee")
    private Integer shippingFee;

    @Column(name = "shipping_method")
    private String shippingMethod;

    @Column(name = "pay_method")
    private String payMethod;
    

    @Column(name = "remarks")
    private String remarks;  // 備註



    
}
