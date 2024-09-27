package tw.com.ispan.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class OrderProductDTO {
    private Integer orderProductId;  // 訂單產品ID
    private Integer count;           // 購買的數量
    private Integer subtotal;        // 小計
    private Integer productId;
    private String productName;      // 產品名稱
    private Integer price;           // 產品價格 //dailyFeeOriginal
    private Integer orderId;
    private byte[] mainPhoto;
    
    
    @Override
    public String toString() {
        return "OrderProductDTO{" +
                "orderProductId=" + orderProductId +
                ", orderId=" + orderId +
                ", productId=" + productId +
                ", count=" + count +
                ", subtotal=" + subtotal +
                 ", mainPhoto=" + mainPhoto +
                '}';
    }

}