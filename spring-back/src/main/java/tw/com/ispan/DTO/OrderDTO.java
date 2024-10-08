package tw.com.ispan.DTO;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@Setter
@Getter
public class OrderDTO {
    private Integer orderId;              // 訂單ID
    private Integer membersId;            // 會員ID
    private Integer totalPrice;           // 總價格
    private Integer shippingFee;          // 運費
    private String shippingName;          // 收件人姓名
    private String shippingPhoneNum;      // 收件人電話
    private String shippingAddress;       // 收件地址
    private String shippingMethod;        // 運送方式
    private String payMethod;             // 付款方式
    private String remarks;                // 備註
    private LocalDate rentalStartDate;         // 租借開始日期
    private LocalDate rentalEndDate;           // 租借結束日期
    private Integer rentalDays;           // 租借天數
    private String orderStatus;            // 訂單狀態
    private LocalDateTime orderDate = LocalDateTime.now();
    private String discountCode; // 儲存折扣碼
    private Double discountValue;



    private List<OrderProductDTO> orderProducts = new ArrayList<>();  // 直接初始化列表
    
   
   
    
    @Override
    public String toString() {
        return "OrderDTO{" +
                "orderId=" + orderId +
                ", membersId=" + membersId +
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
                ", orderProducts=" + orderProducts +
                 ", discountCode=" + discountCode +
                    ", discountValue=" + discountValue +
                '}';
    }
}