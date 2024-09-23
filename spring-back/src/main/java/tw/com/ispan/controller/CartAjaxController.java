package tw.com.ispan.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import tw.com.ispan.DTO.ApiResponse;
import tw.com.ispan.DTO.CartDTO;
import tw.com.ispan.DTO.ConvertCartToDTO;
import tw.com.ispan.domain.Cart;
import tw.com.ispan.domain.Product;

import tw.com.ispan.domain.Members;
import tw.com.ispan.repository.CartRepository;
import tw.com.ispan.repository.MembersRepository;

import tw.com.ispan.repository.ProductRepository;
import tw.com.ispan.service.CartService;
import tw.com.ispan.service.ProductService;

import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping("/rent/cart")
public class CartAjaxController {

    @Autowired
    private CartService cartService;

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private MembersRepository membersRepository;

    @Autowired
    private ProductService productService;
    
    @Autowired
    private ConvertCartToDTO convertCartTDTO;
    

    @PostMapping("/add")
    public ResponseEntity<?> addToCart(@RequestBody CartDTO cartDTO) {
        System.out.println("Received CartDTO: " + cartDTO);

        try {
            if (cartDTO.getMembersId() == null || cartDTO.getProductId() == null || cartDTO.getCount() == null) {
                return ResponseEntity.badRequest().body(new ApiResponse(false, "Missing required fields in CartDTO"));
            }
            
            Product product = productService.findById(cartDTO.getProductId());
            if (product == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(new ApiResponse(false, "Product not found with id: " + cartDTO.getProductId()));
            }
            
            cartDTO.setProductName(product.getProductName());
            cartDTO.setMainPhoto(product.getMainPhoto()); // 這裡設置 byte[] 圖片數據
            cartDTO.getMainPhotoBase64(); // 這樣前端可以獲取 Base64 格式的圖片

            cartDTO.setDailyFeeOriginal(product.getDailyFeeOriginal());
            
            System.out.println("Product dailyFeeOriginal: " + product.getDailyFeeOriginal());


            Cart cart = cartService.addToCart(cartDTO);
         // 使用 convertCartToDTO 將 Cart 轉換為 CartDTO
            CartDTO responseDTO = convertCartTDTO.convertCartToDTO(cart);


            return ResponseEntity.ok(new ApiResponse(true, "Product added to cart successfully.", cartDTO));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse(false, "An error occurred: " + e.getMessage()));
        }
    }


    
    
    /**
     * 查詢指定會員的購物車項目，返回 CartDTO 列表
   
     */
    @GetMapping("/members/{membersId}/cart")
    public ResponseEntity<Set<CartDTO>> getMembersCart(@PathVariable("membersId") Integer membersId) {
        Set<Cart> carts = cartService.findCartsByMembesrId2(membersId);
        
        Set<CartDTO> cartDTOs = carts.stream()
                .map(cart -> {
                    System.out.println("cart: " + cart); // 打印 CartDTO 以檢查值
                    CartDTO dto = convertCartTDTO.convertCartToDTO(cart); // 使用專門的類進行轉換
                    System.out.println("CartDTO: " + dto); // 打印 CartDTO 以檢查值
                    return dto;
                })
                .collect(Collectors.toSet());
        
        return ResponseEntity.ok(cartDTOs);
    }


  
    
    
/**
 * 根據會員 ID 查詢該會員的所有購物車項目
 * @param memberId 會員 ID
 * @return 會員的購物車項目列表
 */

@GetMapping("/members/{membersId}")
public ResponseEntity<Set<Cart>> getMembersCart2(@PathVariable("membersId") Integer membersId) {
    try {
        // 調用服務層方法來查詢會員的購物車
        Set<Cart> carts = cartService.findCartsByMembesrId(membersId);

        // 返回成功響應，包含會員的購物車項目
        return ResponseEntity.ok(carts);
    } catch (RuntimeException e) {
        // 處理找不到會員的情況，返回 404 Not Found
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(null);
    } catch (Exception e) {
        // 處理其他可能的錯誤情況，返回 500 Internal Server Error
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(null);
    }
}

@PostMapping("/plusOne")
public ResponseEntity<?> plusOne(
        @RequestParam("membersId") Integer membersId,
        @RequestParam("productId") Integer productId) {
    try {
        Cart cart = cartService.plusOne(productId, membersId);
        return ResponseEntity.ok("Quantity increased successfully.");
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("An error occurred: " + e.getMessage());
    }
}

//如果數量變為 0，商品將從購物車中刪除。
@PostMapping("/minusOne")
public ResponseEntity<?> minusOne(
        @RequestParam("membersId") Integer membersId,
        @RequestParam("productId") Integer productId) {
    try {
        cartService.minusOne(productId, membersId);
        return ResponseEntity.ok("Quantity decreased successfully.");
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("An error occurred: " + e.getMessage());
    }
}


@DeleteMapping("/remove")
public ResponseEntity<String> removeFromCart(
        @RequestParam("membersId") Integer membersId,
        @RequestParam("productId") Integer productId) {
    try {
        cartService.removeFromCart(membersId, productId);
        return ResponseEntity.ok("Product removed from cart successfully.");
    } catch (RuntimeException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Error: " + e.getMessage());
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("An error occurred: " + e.getMessage());
    }
}

@DeleteMapping("/clear")
public ResponseEntity<?> clearCart(@RequestParam Integer membersId) {
	cartService.clearCart(membersId);
    return ResponseEntity.ok("購物車已清空");
}

//清空購物車
//@PostMapping("/clear")
//public ResponseEntity<String> clearCart(@RequestHeader("Authorization") String token) {
//    try {
//        // 從 token 中獲取會員 ID
//        String membersId = jwtService.getMemberIdFromToken(token);
//
//        // 調用 service 清空該會員的購物車
//        cartService.clearCartByMembersId(membersId);
//
//        return ResponseEntity.ok("購物車已清空");
//    } catch (Exception e) {
//        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("清空購物車失敗");
//    }
//}

}


