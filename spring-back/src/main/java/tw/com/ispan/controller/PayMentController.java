package tw.com.ispan.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.support.MethodArgumentTypeMismatchException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.com.ispan.service.OrderService;

@CrossOrigin
@RestController
@RequestMapping("/rent")
public class PayMentController {
	
	  @Autowired
	    private OrderService orderService;
	  
	// 在類中創建 Logger 實例
	    private static final Logger logger = LoggerFactory.getLogger(PayMentController.class);
	    
	
	    @PostMapping("/ecpayCheckout")
	    public ResponseEntity<String> ecpayCheckout() {
	        logger.info("Received ecpayCheckout request");
	        try {
	            String aioCheckOutALLForm = orderService.ecpayCheckout();
	            return ResponseEntity.ok(aioCheckOutALLForm);
	        } catch (MethodArgumentTypeMismatchException e) {
	            logger.error("Parameter mismatch: {}", e.getMessage());
	            return ResponseEntity.badRequest().body("Invalid request parameters: " + e.getMessage());
	        } catch (Exception e) {
	            logger.error("Error occurred: {}", e.getMessage());
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred: " + e.getMessage());
	        }
	    }

}
