package tw.com.ispan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import tw.com.ispan.domain.Members;
import tw.com.ispan.domain.Order;
import tw.com.ispan.domain.OrderProduct;
import tw.com.ispan.domain.OrderStatus;
import tw.com.ispan.domain.Product;
import tw.com.ispan.exception.ResourceNotFoundException;
import tw.com.ispan.DTO.ConverterOrderToDTO;
import tw.com.ispan.DTO.OrderDTO;
import tw.com.ispan.DTO.OrderProductDTO;
import tw.com.ispan.repository.MembersRepository;
import tw.com.ispan.repository.OrderRepository;
import tw.com.ispan.repository.ProductRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ConverterOrderToDTO orderConverter;
    
    @Autowired
    private MembersRepository membersRepository;
    
    @Autowired 
    private ProductRepository productRepository;
    
    

    // 查詢所有訂單
    @Transactional
    public List<OrderDTO> getAllOrders() {
        return orderRepository.findAll().stream()
                .map(orderConverter::toDTO)
                .toList();
    }

    // 根據訂單 ID 查詢訂單
    @Transactional
    public OrderDTO getOrderById(Integer orderId) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found"));
        return orderConverter.toDTO(order);
    }
    

    // 新增訂單
    @Transactional
    public OrderDTO createOrder(OrderDTO orderDTO) {
        
      
        Order order = new Order();
        order.setTotalPrice(orderDTO.getTotalPrice());
        // 設置其他屬性，例如會員 ID、運送方式等
        
        order.setShippingFee(orderDTO.getShippingFee());
        order.setShippingName(orderDTO.getShippingName());
        order.setShippingPhoneNum(orderDTO.getShippingPhoneNum());
        order.setShippingAddress(orderDTO.getShippingAddress());
        order.setShippingMethod(orderDTO.getShippingMethod());
        order.setPayMethod(orderDTO.getPayMethod());
        order.setRemarks(orderDTO.getRemarks());
        order.setRentalStartDate(orderDTO.getRentalStartDate());
        order.setRentalEndDate(orderDTO.getRentalEndDate());
     
        order.setOrderStatus(OrderStatus.PENDING); // 預設為待付款

        
        // 設置會員資訊
        if (orderDTO.getMembersId() != null) {
            Members member = membersRepository.findById(orderDTO.getMembersId())
                    .orElseThrow(() -> new ResourceNotFoundException("Member not found"));
            order.setMembers(member);
        }
        
        
        // 計算租借天數並設置到 Order 實體
        if (orderDTO.getRentalStartDate() != null && orderDTO.getRentalEndDate() != null) {
            long daysBetween = ChronoUnit.DAYS.between(orderDTO.getRentalStartDate(), orderDTO.getRentalEndDate());
            order.setRentalDays((int) daysBetween); // 設置租借天數
        } else {
            order.setRentalDays(0); // 如果日期未定義，則返回0
        }
        
        



     // 處理訂單產品資訊
        if (orderDTO.getOrderProducts() != null) {
            List<OrderProduct> orderProducts = orderDTO.getOrderProducts().stream()
                .map(productDTO -> {
                    OrderProduct orderProduct = new OrderProduct();
                    orderProduct.setCount(productDTO.getCount()); // 設置產品數量
                    orderProduct.setSubtotal(productDTO.getSubtotal()); // 設置小計

                    // 根據 productId 獲取 Product 實體
                    Product product = productRepository.findById(productDTO.getProductId())
                            .orElseThrow(() -> new ResourceNotFoundException("Product not found"));
                    
                    // 設置 Product
                    orderProduct.setProduct(product); 

                    // 設置與訂單的關聯
                    orderProduct.setOrder(order); 

                    // **不需要顯式設置 `productName` 和 `price`，這些可以在 `DTO` 中處理**
                    return orderProduct;
                })
                .collect(Collectors.toList());
            
            // 設置訂單產品列表
            order.setOrderProduct(orderProducts); 
        }
        
        order.setOrderDate(LocalDateTime.now()); // 只設置當前日期，不包含時間


        // 保存訂單
        Order savedOrder = orderRepository.save(order);

        // 返回轉換後的 DTO
        return orderConverter.toDTO(savedOrder);
    }


    // 更新訂單狀態
    @Transactional
    public OrderDTO updateOrderStatus(Integer orderId, OrderStatus status) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found"));
        
        order.setOrderStatus(status); // 使用 Enum 更新狀態
        Order updatedOrder = orderRepository.save(order);
        return orderConverter.toDTO(updatedOrder);
    }

    // 刪除訂單
    @Transactional
    public void deleteOrder(Integer orderId) {
        if (!orderRepository.existsById(orderId)) {
            throw new ResourceNotFoundException("Order not found");
        }
        orderRepository.deleteById(orderId);
    }

    
    
    public List<OrderDTO> getOrdersByMemberId(Integer membersId) {
        Members member = membersRepository.findById(membersId)
                .orElseThrow(() -> new ResourceNotFoundException("Member not found"));
        return orderRepository.findByMembers(member).stream()
                .map(orderConverter::toDTO)
                .toList();
    }

    
}


