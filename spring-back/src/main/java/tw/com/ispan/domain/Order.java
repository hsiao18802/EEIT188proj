package tw.com.ispan.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import tw.com.ispan.domain.Order;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "orders")  
public class Order {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Integer orderId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "members_id")
    private Members members;  // 對應到會員
    
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL , fetch = FetchType.EAGER)
    private List<OrderProduct> orderProduct;  // 每個訂單對應的產品明細


    
    @Column(name = "total_price_amount")
    private Integer totalPrice;

    @Column(name = "shipping_fee")
    private Integer shippingFee;
    
    @Column(name = "shipping_name")
    private String shippingName;
    
    @Column(name = "shipping_phone_number")
    private String shippingPhoneNum;
    
    @Column(name = "shipping_address")
    private String shippingAddress;
    

    @Column(name = "shipping_method")
    private String shippingMethod;

    @Column(name = "pay_method")
    private String payMethod;
    

    @Column(name = "remarks")
    private String remarks;  // 備註
    
    @Column(name = "rental_start_date")
    @Temporal(TemporalType.DATE)  // 改為只包含日期部分
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate rentalStartDate;  // 租借開始日期

    @Column(name = "rental_end_date")
    @Temporal(TemporalType.DATE)  // 改為只包含日期部分
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate rentalEndDate;  // 租借結束日期

    @Column(name = "rental_days")
    private Integer rentalDays;  // 租借天數
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "discount_id", nullable = true)  // 折扣碼外鍵
    private Discount discount;  // 對應的折扣碼
    
    
    @Enumerated(EnumType.ORDINAL) 
    @Column(name = "order_status")
    private OrderStatus orderStatus = OrderStatus.PENDING; // 預設為 PENDING
    
    @Column(name = "order_creation_date")
    private LocalDateTime orderDate = LocalDateTime.now();
    
    // 新增的方法
    public static String getOrderStatusString(int status) {
        switch (status) {
            case 0: return "PENDING";
            case 1: return "PAID";
            case 2: return "SHIPPED";
            case 3: return "DELIVERED";
            case 4: return "DONE";
            case 5: return "CANCELLED";
            case 6: return "RETURNED";
            default: return "UNKNOWN";
        }
    }
    

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", membersId=" + (members != null ? members.getMembersId() : null) +
                ", orderDate=" + orderDate +
                ", totalPrice=" + totalPrice +
                ", shippingFee=" + shippingFee +
                ", shippingName='" + shippingName + '\'' +
                ", shippingPhoneNum='" + shippingPhoneNum + '\'' +
                ", shippingAddress='" + shippingAddress + '\'' +
                ", shippingMethod='" + shippingMethod + '\'' +
                ", payMethod='" + payMethod + '\'' +
                ", remarks='" + remarks + '\'' +
                ", rentalStartDate=" + rentalStartDate +
                ", rentalEndDate=" + rentalEndDate +
                ", rentalDays=" + rentalDays +
                ", orderStatus='" + orderStatus + '\'' +
                ", orderProducts=" + (orderProduct != null ? orderProduct.toString() : null) +
                '}';
    }
}