package tw.com.ispan.DTO;

import org.springframework.stereotype.Component;
import tw.com.ispan.domain.Order;
import tw.com.ispan.domain.OrderProduct;

import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ConverterOrderToDTO {

    public OrderDTO toDTO(Order order) {
        OrderDTO dto = new OrderDTO();
        dto.setOrderId(order.getOrderId());
        dto.setMembersId(order.getMembers().getMembersId()); 
        dto.setTotalPrice(order.getTotalPrice());
        dto.setShippingFee(order.getShippingFee());
        dto.setShippingName(order.getShippingName());
        dto.setShippingPhoneNum(order.getShippingPhoneNum());
        dto.setShippingAddress(order.getShippingAddress());
        dto.setShippingMethod(order.getShippingMethod());
        dto.setPayMethod(order.getPayMethod());
        dto.setRemarks(order.getRemarks());
        dto.setRentalStartDate(order.getRentalStartDate());
        dto.setRentalEndDate(order.getRentalEndDate());
        
     // 將 enum 狀態轉換為字串
        dto.setOrderStatus(order.getOrderStatus() != null ? order.getOrderStatus().name() : "");

        
        
     // 計算租借天數
        if (order.getRentalStartDate() != null && order.getRentalEndDate() != null) {
            long daysBetween = ChronoUnit.DAYS.between(order.getRentalStartDate(), order.getRentalEndDate());
            dto.setRentalDays((int) daysBetween); // 設置計算出的租借天數
        } else {
            dto.setRentalDays(0); // 如果日期未定義，則返回0
        }
        
        
      
 
        // 確保 products 正確初始化，避免 NullPointerException
        List<OrderProduct> products = order.getOrderProduct() != null ? order.getOrderProduct() : new ArrayList<>();

        // 將 products 轉換成 DTO
        List<OrderProductDTO> productDTOs = products.stream()
            .map(product -> {
                OrderProductDTO productDTO = new OrderProductDTO(); // 使用正確的變數名稱
                productDTO.setOrderProductId(product.getOrderProductId()); // 修改為 product
                productDTO.setCount(product.getCount()); // 修改為 product
                productDTO.setSubtotal(product.getSubtotal()); // 修改為 product
                productDTO.setOrderId(product.getOrder().getOrderId()); // 修改為 product
                productDTO.setProductId(product.getProduct() != null ? product.getProduct().getProductId() : null); // 獲取產品 ID
                productDTO.setProductName(product.getProduct().getProductName()); // 獲取產品名稱
                productDTO.setPrice(product.getProduct().getDailyFeeOriginal()); // 獲取產品價格
                productDTO.setMainPhoto(product.getProduct().getMainPhoto()); // 獲取產品價格


                
                return productDTO; // 返回轉換後的 DTO
            })
            .collect(Collectors.toList());

        dto.setOrderProducts(productDTOs); // 將轉換後的產品列表設置到 dto

        return dto; // 返回完整的 OrderDTO
    }
}
