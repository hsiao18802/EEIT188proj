package tw.com.ispan.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.support.MethodArgumentTypeMismatchException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tw.com.ispan.DTO.OrderDTO;
import tw.com.ispan.DTO.OrderRequestDTO;
import tw.com.ispan.domain.Order;
import tw.com.ispan.domain.OrderStatus;
import tw.com.ispan.exception.ResourceNotFoundException;
import tw.com.ispan.service.OrderService;

@CrossOrigin
@RestController
@RequestMapping("/rent/order")
public class PayMentController {

    @Autowired
    private OrderService orderService;

    // 在類中創建 Logger 實例
    private static final Logger logger = LoggerFactory.getLogger(PayMentController.class);
    
    

    @PostMapping("/ecpayCheckout/{orderId}")
    public String ecpayCheckout(@PathVariable Integer orderId){
   
        // 根據傳入的 orderId 進行結帳處理
        String aioCheckOutALLForm = orderService.ecpayCheckout(orderId);
        return aioCheckOutALLForm;
    }


   
   
   

    @PostMapping("/ecpay/callback")
    public String handleECPayCallback(@RequestParam Map<String, String> params) {
        String merchantTradeNo = params.get("MerchantTradeNo");
        String paymentStatus = params.get("RtnCode"); // 支付結果代碼
        String tradeNo = params.get("TradeNo");

        // 根據 MerchantTradeNo 查詢訂單
        Order order = orderService.findByMerchantTradeNo(merchantTradeNo)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found"));

        // 根據支付狀態更新訂單狀態
        if ("1".equals(paymentStatus)) {
            order.setOrderStatus(OrderStatus.PAID); // 支付成功
        } else {
            order.setOrderStatus(OrderStatus.CANCELLED); // 支付失敗
        }

        // 更新交易編號
        order.setEcpayTradeNo(tradeNo);

        // 更新訂單
        orderService.saveOrder(order);

        return "1|OK";
    }
}
