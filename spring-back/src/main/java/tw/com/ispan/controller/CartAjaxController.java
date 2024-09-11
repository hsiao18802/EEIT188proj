package tw.com.ispan.controller;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import tw.com.ispan.domain.Cart;
import tw.com.ispan.domain.Product;
import tw.com.ispan.domain.ProductCart;
import tw.com.ispan.domain.Members;
import tw.com.ispan.repository.CartRepository;
import tw.com.ispan.repository.MembersRepository;
import tw.com.ispan.repository.ProductCartRepository;
import tw.com.ispan.repository.ProductRepository;
import tw.com.ispan.service.CartService;

import java.util.List;

@RestController
@RequestMapping("/ajax/pages/cart")
@CrossOrigin
public class CartAjaxController {
//
//    @Autowired
//    private CartService cartService;
//
//    @Autowired
//    private CartRepository cartRepository;
//
//    @Autowired
//    private MembersRepository membersRepository;
//
//    @Autowired
//    private ProductRepository productRepository;
//
//    @Autowired
//    private ProductCartRepository productCartRepository;
//
//    /**
//     * 新增商品到購物車
//     */
//    @PostMapping("/add")
//    public String addToCart(@RequestBody String json) {
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
//            Product product = productRepository.findById(productId)
//                .orElseThrow(() -> new RuntimeException("Product not found"));
//
//            Cart cart = cartRepository.findByMembers(member);
//            if (cart == null) {
//                cart = new Cart();
//                cart.setMembers(member);
//                cart.setTotalPrice(0);
//                cart.setDeposit(0);
//                cart.setRemarks("");
//                cart.setShippingFee(0);
//                cart.setShippingMethod("");
//                cart.setPayMethod("");
//                cartRepository.save(cart);
//            }
//
//            ProductCart productCart = new ProductCart();
//            productCart.setCart(cart);
//            productCart.setProductId(productId);
//            productCart.setCount(count);
//            productCart.setDailyFeeOriginal(product.getDailyFeeOriginal());
//            productCart.setTotalPrice(count * product.getDailyFeeOriginal());
//
//            productCartRepository.save(productCart);
//
//            // 更新購物車的總價
//            int totalPrice = cart.getTotalPrice() + (count * product.getDailyFeeOriginal());
//            cart.setTotalPrice(totalPrice);
//            cartRepository.save(cart);
//
//            responseJson.put("success", true);
//            responseJson.put("message", "商品已新增到購物車");
//        } catch (Exception e) {
//            responseJson.put("success", false);
//            responseJson.put("message", "新增商品到購物車失敗: " + e.getMessage());
//        }
//
//        return responseJson.toString();
//    }
//
//    /**
//     * 查詢用戶的購物車
//     */
//    @GetMapping("/member/{memberId}")
//    public String getCartByMemberId(@PathVariable("memberId") Integer memberId) {
//        JSONObject responseJson = new JSONObject();
//        JSONArray cartArray = new JSONArray();
//
//        try {
//            Cart cart = cartRepository.findByMembers(membersRepository.findById(memberId)
//                .orElseThrow(() -> new RuntimeException("Member not found")));
//            if (cart != null) {
//                List<ProductCart> productCarts = productCartRepository.findByCart(cart);
//                for (ProductCart productCart : productCarts) {
//                    JSONObject cartJson = new JSONObject();
//                    cartJson.put("productId", productCart.getProductId());
//                    cartJson.put("productName", productCart.getProduct().getProductName());
//                    cartJson.put("count", productCart.getCount());
//                    cartJson.put("price", productCart.getPrice());
//                    cartJson.put("totalPrice", productCart.getTotalPrice());
//                    cartArray.put(cartJson);
//                }
//                responseJson.put("success", true);
//                responseJson.put("cart", cartArray);
//            } else {
//                responseJson.put("success", false);
//                responseJson.put("message", "購物車為空");
//            }
//        } catch (Exception e) {
//            responseJson.put("success", false);
//            responseJson.put("message", "查詢購物車失敗: " + e.getMessage());
//        }
//
//        return responseJson.toString();
//    }
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
 }