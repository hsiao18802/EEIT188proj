package tw.com.ispan.controller;


import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import tw.com.ispan.domain.Cart;
import tw.com.ispan.domain.Product;

import tw.com.ispan.domain.Members;
import tw.com.ispan.repository.CartRepository;
import tw.com.ispan.repository.MembersRepository;

import tw.com.ispan.repository.ProductRepository;
import tw.com.ispan.service.CartService;
import tw.com.ispan.service.ProductService;

import java.util.List;
import java.util.Set;

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


    
    
    

    @PostMapping("/add")
    public ResponseEntity<?> addToCart(
            @RequestParam("memberId") Integer memberId,
            @RequestParam("productId") Integer productId) {

        try {
            // 呼叫服務層方法新增商品到購物車
            Cart cart = cartService.addToCart(memberId, productId);

            // 查找新增到購物車的商品
            Product product = productService.findById(productId);
            if (product == null) {
            	  return ResponseEntity.status(HttpStatus.NOT_FOUND)
                          .body("Product not found with id: " + productId);
              }

              // 返回成功響應
              return ResponseEntity.ok("Product added to cart successfully.");

          } catch (Exception e) {
              // 捕捉例外並返回錯誤響應
              return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                      .body("An error occurred: " + e.getMessage());
          }
      }
  
    
    
/**
 * 根據會員 ID 查詢該會員的所有購物車項目
 * @param memberId 會員 ID
 * @return 會員的購物車項目列表
 */

@GetMapping("/members/{memberId}")
public ResponseEntity<Set<Cart>> getMembersCart(@PathVariable("memberId") Integer memberId) {
    try {
        // 調用服務層方法來查詢會員的購物車
        Set<Cart> carts = cartService.findMembersCart(memberId);

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
}
//
//    /**
//     * 更新購物車中的商品數量和價格
//     */
//    @PutMapping("/update")
//    public String updateCart(@RequestBody String json) {
//        JSONObject requestJson = new JSONObject(json);
//        JSONObject responseJson = new JSONObject();
//
//        try {
//            Integer memberId = requestJson.getInt("memberId");
//            Integer productId = requestJson.getInt("productId");
//            Integer count = requestJson.getInt("count");
//
//            Members member = membersRepository.findById(memberId)
//                .orElseThrow(() -> new RuntimeException("Member not found"));
//
//            Cart cart = cartRepository.findByMembers(member);
//            if (cart == null) {
//                throw new RuntimeException("Cart not found for member: " + memberId);
//            }
//
//            Product product = productRepository.findById(productId)
//                .orElseThrow(() -> new RuntimeException("Product not found"));
//
//            ProductCart productCart = productCartRepository.findByCartAndProductId(cart, productId);
//            if (productCart != null) {
//                // 更新商品數量和價格
//                productCart.setCount(count);
//                productCart.setPrice(product.getDailyFeeOriginal());
//                productCart.setTotalPrice(count * product.getDailyFeeOriginal());
//                productCartRepository.save(productCart);
//
//                // 更新購物車的總價
//                int totalPrice = productCartRepository.findByCart(cart).stream()
//                        .mapToInt(pc -> pc.getTotalPrice())
//                        .sum();
//                cart.setTotalPrice(totalPrice);
//                cartRepository.save(cart);
//
//                responseJson.put("success", true);
//                responseJson.put("message", "購物車更新成功");
//            } else {
//                responseJson.put("success", false);
//                responseJson.put("message", "購物車中找不到該商品");
//            }
//        } catch (Exception e) {
//            responseJson.put("success", false);
//            responseJson.put("message", "更新購物車失敗: " + e.getMessage());
//        }
//
//        return responseJson.toString();
//    }
//
//    /**
//     * 從購物車中刪除商品
//     */
//    @DeleteMapping("/delete")
//    public String removeFromCart(@RequestBody String json) {
//        JSONObject requestJson = new JSONObject(json);
//        JSONObject responseJson = new JSONObject();
//
//        try {
//            Integer memberId = requestJson.getInt("memberId");
//            Integer productId = requestJson.getInt("productId");
//
//            Members member = membersRepository.findById(memberId)
//                .orElseThrow(() -> new RuntimeException("Member not found"));
//
//            Cart cart = cartRepository.findByMembers(member);
//            if (cart == null) {
//                throw new RuntimeException("Cart not found for member: " + memberId);
//            }
//
//            ProductCart productCart = productCartRepository.findByCartAndProductId(cart, productId);
//            if (productCart != null) {
//                // 刪除商品
//                productCartRepository.delete(productCart);
//
//                // 更新購物車的總價
//                int totalPrice = productCartRepository.findByCart(cart).stream()
//                        .mapToInt(pc -> pc.getTotalPrice())
//                        .sum();
//                cart.setTotalPrice(totalPrice);
//                cartRepository.save(cart);
//
//                responseJson.put("success", true);
//                responseJson.put("message", "商品已從購物車中刪除");
//            } else {
//                responseJson.put("success", false);
//                responseJson.put("message", "購物車中找不到該商品");
//            }
//        } catch (Exception e) {
//            responseJson.put("success", false);
//            responseJson.put("message", "刪除商品失敗: " + e.getMessage());
//        }
//
//        return responseJson.toString();
//    }
//
//    /**
//     * 查詢購物車中的特定商品
//     */
//    @GetMapping("/item")
//    public String getCartItem(@RequestBody String json) {
//        JSONObject requestJson = new JSONObject(json);
//        JSONObject responseJson = new JSONObject();
//
//        try {
//            Integer memberId = requestJson.getInt("memberId");
//            Integer productId = requestJson.getInt("productId");
//
//            Members member = membersRepository.findById(memberId)
//                .orElseThrow(() -> new RuntimeException("Member not found"));
//
//            Cart cart = cartRepository.findByMembers(member);
//            if (cart != null) {
//                ProductCart productCart = productCartRepository.findByCartAndProductId(cart, productId);
//                if (productCart != null) {
//                    JSONObject cartJson = new JSONObject();
//                    cartJson.put("productId", productCart.getProductId());
//                    cartJson.put("count", productCart.getCount());
//                    cartJson.put("price", productCart.getPrice());
//                    cartJson.put("totalPrice", productCart.getTotalPrice());
//
//                    responseJson.put("success", true);
//                    responseJson.put("cartItem", cartJson);
//                } else {
//                    responseJson.put("success", false);
//                    responseJson.put("message", "購物車項目不存在");
//                }
//            } else {
//            	 responseJson.put("success", false);
//                 responseJson.put("message", "購物車不存在");
//             }
//         } catch (Exception e) {
//             responseJson.put("success", false);
//             responseJson.put("message", "查詢購物車項目失敗: " + e.getMessage());
//         }
//
//         return responseJson.toString();
//     }
 