package tw.com.ispan.service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ecpay.payment.integration.AllInOne;
import ecpay.payment.integration.domain.AioCheckOutALL;
import jakarta.transaction.Transactional;
import tw.com.ispan.DTO.ConverterOrderToDTO;
import tw.com.ispan.DTO.ConverterOrderToECPayDTO;

import tw.com.ispan.DTO.OrderDTO;
import tw.com.ispan.DTO.OrderRequestDTO;
import tw.com.ispan.domain.Members;
import tw.com.ispan.domain.Order;
import tw.com.ispan.domain.OrderProduct;
import tw.com.ispan.domain.OrderStatus;
import tw.com.ispan.domain.Product;
import tw.com.ispan.exception.ResourceNotFoundException;
import tw.com.ispan.repository.MembersRepository;
import tw.com.ispan.repository.OrderRepository;
import tw.com.ispan.repository.ProductRepository;

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
    
    @Autowired
    private ConverterOrderToECPayDTO converterOrderToECPayDTO;
    
    

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
        
     // 4. 保存訂單
        Order savedOrder = orderRepository.save(order);
        
        // 5. 處理訂單產品資訊
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
                    orderProduct.setOrder(savedOrder); // 使用已保存的訂單物件

                    return orderProduct;
                })
                .collect(Collectors.toList());
            
            // 6. 更新訂單產品關聯
            savedOrder.setOrderProduct(orderProducts); // 將所有的 orderProduct 設置到訂單中
        }

        savedOrder.setOrderDate(LocalDateTime.now()); // 只設置當前日期，不包含時間
        
        // 7. 返回轉換後的 DTO
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
    
    // ECPay結帳
    @Transactional
    public String ecpayCheckout(Integer orderId) {
        // 從資料庫獲取訂單
    
    	 // 從資料庫獲取訂單
        Order order = orderRepository.findById(orderId)
            .orElseThrow(() -> new ResourceNotFoundException("Order not found"));

        System.out.println("order="+order);
        // 將訂單轉換為 ECPay DTO
        OrderRequestDTO orderRequestDTO = converterOrderToECPayDTO.toECPayDTO(order);

        // 初始化 ECPay AllInOne 服務
        AllInOne all = new AllInOne("");

        // 創建 AioCheckOutALL 對象，準備填充資料
        AioCheckOutALL obj = new AioCheckOutALL();
        System.out.println("orderRequestDTO="+orderRequestDTO.getItemName());
        System.out.println("orderRequestDTO_getMerchantTradeNo="+orderRequestDTO.getMerchantTradeNo());

        // 填充訂單資訊
        obj.setMerchantTradeNo(orderRequestDTO.getMerchantTradeNo()); // 設置商家交易編號
        obj.setMerchantTradeDate(orderRequestDTO.getMerchantTradeDate()); // 設置商店交易日期
        obj.setTotalAmount(orderRequestDTO.getTotalAmount().toString()); // 設置總金額
        obj.setTradeDesc("------------------"); // 設置交易描述
        obj.setItemName(orderRequestDTO.getItemName()); // 設置商品名稱

        // 設置回傳網址和商店轉跳網址
        obj.setReturnURL(orderRequestDTO.getReturnURL()); 
        obj.setNeedExtraPaidInfo("N"); // 是否需要額外付款資訊
        obj.setClientBackURL(orderRequestDTO.getClientBackURL()); // 設置商店轉跳網址
        obj.setChooseSubPayment("Credit"); // 設置付款方式
        
        // 調用 ECPay 的 aioCheckOut 方法，生成支付表單
        String form = all.aioCheckOut(obj, null);

        // 保存交易編號到訂單，並更新數據庫
        order.setMerchantTradeNo(orderRequestDTO.getMerchantTradeNo());
        orderRepository.save(order);

        // 返回支付表單給前端
        return form;
    }
    
 // 查找訂單根據 MerchantTradeNo
    @Transactional
    public Optional<Order> findByMerchantTradeNo(String merchantTradeNo) {

        return orderRepository.findByMerchantTradeNo(merchantTradeNo);

    }



    // 保存訂單
    @Transactional
    public Order saveOrder(Order order) {

        return orderRepository.save(order);

    }

    
    
}
    
    
    

