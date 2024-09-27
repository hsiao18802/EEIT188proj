package tw.com.ispan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tw.com.ispan.DTO.OrderDTO;
import tw.com.ispan.domain.OrderStatus;
import tw.com.ispan.service.OrderService;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/rent/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    // 獲取所有訂單
    @GetMapping("/all")
    public ResponseEntity<List<OrderDTO>> getAllOrders() {
        List<OrderDTO> orders = orderService.getAllOrders();
        System.err.println(orders); // 確認資料

        return ResponseEntity.ok(orders);
    }

    // 根據訂單 ID 獲取訂單
    @GetMapping("/{id}")
    public ResponseEntity<OrderDTO> getOrderById(@PathVariable("id") Integer orderId) {
        OrderDTO order = orderService.getOrderById(orderId);
        return ResponseEntity.ok(order);
    }

    // 創建新訂單
    @PostMapping("/create")
    public ResponseEntity<OrderDTO> createOrder(@RequestBody OrderDTO orderDTO) {
        OrderDTO createdOrder = orderService.createOrder(orderDTO);
        return ResponseEntity.status(201).body(createdOrder); // 返回 201 創建成功狀態
    }
    
    
    
    
    

    // 更新訂單狀態
    @PutMapping("/{id}/status")
    public ResponseEntity<OrderDTO> updateOrderStatus(
            @PathVariable("id") Integer orderId,
            @RequestParam OrderStatus status) { // 確保使用正確的參數類型
        OrderDTO updatedOrder = orderService.updateOrderStatus(orderId, status);
        return ResponseEntity.ok(updatedOrder);
    }


    // 刪除訂單
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable("id") Integer orderId) {
        orderService.deleteOrder(orderId);
        return ResponseEntity.noContent().build(); // 返回 204 無內容狀態
    }

    // 獲取指定會員的所有訂單
    @GetMapping("/member/{memberId}")
    public ResponseEntity<List<OrderDTO>> getOrdersByMemberId(@PathVariable("memberId") Integer memberId) {
        List<OrderDTO> orders = orderService.getOrdersByMemberId(memberId);
        return ResponseEntity.ok(orders);
    }
}
