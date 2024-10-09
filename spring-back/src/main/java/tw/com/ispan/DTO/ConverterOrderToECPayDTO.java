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
        
        String gogoCampingNo = "gogoCampingNo" + UUID.randomUUID().toString().replace("-", "").substring(0,5);
        
        dto.setMerchantTradeNo(gogoCampingNo);  // 設置商店交易編號
        dto.setMerchantTradeDate(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"))); // 設置商店交易日期
        dto.setTotalAmount(order.getTotalPrice());  // 設置交易總金額
        dto.setTradeDesc("租借服務 - 帳篷");  // 設置交易描述
        
        // 拼接商品名稱
        String itemNames = order.getOrderProduct().stream()
            .map(op -> op.getProduct().getProductName() + " x " + op.getCount())
            .collect(Collectors.joining(", "));
        dto.setItemName(itemNames);
        dto.setReturnURL("https://2a75-1-160-34-214.ngrok-free.app/rent/order/ecpay/callback");
      
       
        dto.setClientBackURL("https://2a75-1-160-34-214.ngrok-free.app/");  // 設置商店轉跳網址
       // dto.setPaymentMethod(order.getPayMethod());  // 設置付款方式

        return dto;
    }
}


