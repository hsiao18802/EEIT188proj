package tw.com.ispan.DTO;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import tw.com.ispan.domain.Order;

@Component
public class ConverterOrderToECPayDTO {

    public OrderRequestDTO toECPayDTO(Order order) {
        OrderRequestDTO dto = new OrderRequestDTO();
        
        String gogoCampingNo =UUID.randomUUID().toString().replace("-", "").substring(0,20);
        
        dto.setMerchantTradeNo(gogoCampingNo);  // 設置商店交易編號
        dto.setMerchantTradeDate(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"))); // 設置商店交易日期
        dto.setTotalAmount(order.getTotalPrice());  // 設置交易總金額
        dto.setTradeDesc("租借服務 - 帳篷");  // 設置交易描述
        
        // 拼接商品名稱
        String itemNames = order.getOrderProduct().stream()
            .map(op -> op.getProduct().getProductName() + " x " + op.getCount())
            .collect(Collectors.joining(", "));
        dto.setItemName(itemNames);
        
        dto.setReturnURL("http://localhost:5173/rent/ecpay/callback");  // 設置回傳網址
        dto.setClientBackURL("http://localhost:5173/");  // 設置商店轉跳網址
       // dto.setPaymentMethod(order.getPayMethod());  // 設置付款方式

        return dto;
    }
}


