package tw.com.ispan.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tw.com.ispan.DTO.ConverterOrderToDTO;
import tw.com.ispan.DTO.OrderDTO;
import tw.com.ispan.DTO.OrderProductDTO;
import tw.com.ispan.domain.Members;
import tw.com.ispan.domain.Order;
import tw.com.ispan.domain.OrderStatus;
import tw.com.ispan.domain.Product;
import tw.com.ispan.repository.MembersRepository;
import tw.com.ispan.repository.OrderRepository;
import tw.com.ispan.repository.ProductRepository;

@SpringBootTest
public class TESTOrderService {
	
	
	 @Autowired
	    private OrderRepository orderRepository;

	    @Autowired
	    private ConverterOrderToDTO orderConverter;
	    
	    @Autowired
	    private MembersRepository membersRepository;
	    
	    @Autowired 
	    private ProductRepository productRepository;
	    
	    @Autowired
	    private OrderService orderService;

	    
	
	    
	   @Test
	   public void getAllOrders() {
		   
		   System.err.println(orderService.getAllOrders());
		   
	      
	    }
	   


	   
	  // @Test
	   public void deleteOrder() {
		   
	  orderService.deleteOrder(5);

	   }
	   
	    //@Test
	   public void getOrdersByMemberId() {
		       System.err.println(orderService.getOrdersByMemberId(1));

	    	
	    }
	    
	    
	    
	  //@Test
	  public void TestupdateOrderStatus() {
		  System.err.println(orderService.updateOrderStatus(19,OrderStatus.SHIPPED));
		  
	  }
	    
		  //@Test
		  public void TESTcreateOrder() {
		      // 準備測試數據
		      OrderDTO orderDTO = new OrderDTO();
		      orderDTO.setMembersId(2); // 假設存在 ID 為 1 的會員
		      orderDTO.setTotalPrice(1000);
		      orderDTO.setShippingFee(50);
		      orderDTO.setShippingName("John Doe");
		      orderDTO.setShippingPhoneNum("123456789");
		      orderDTO.setShippingAddress("123 Street");
		      orderDTO.setShippingMethod("Express");
		      orderDTO.setPayMethod("Credit Card");
		      orderDTO.setRemarks("Please deliver on time");
		      orderDTO.setRentalStartDate(LocalDate.of(2024, 10, 1));
		      orderDTO.setRentalEndDate(LocalDate.of(2024, 10, 5));

		      // 創建 OrderProductDTO 列表並添加測試資料
		      List<OrderProductDTO> orderProducts = new ArrayList<>();
		      
		      // 假設你有產品 ID 為 1 的產品，並設置數量和小計
		      OrderProductDTO product1 = new OrderProductDTO();
		      product1.setProductId(1008); // 產品 ID
		      product1.setCount(2); // 數量
		      product1.setSubtotal(200); // 小計

		      // 將產品添加到列表
		      orderProducts.add(product1);

		      // 可以添加更多產品
		      OrderProductDTO product2 = new OrderProductDTO();
		      product2.setProductId(1010); // 另一個產品 ID
		      product2.setCount(1); // 數量
		      product2.setSubtotal(800); // 小計

		      orderProducts.add(product2);

		      // 將產品列表設置到 orderDTO
		      orderDTO.setOrderProducts(orderProducts);

		      // 調用 createOrder 方法
		      OrderDTO result = orderService.createOrder(orderDTO);

		      // 打印結果
		      System.err.println(result);
		  }
	    

	
	}
	    
	    
	    
	    

