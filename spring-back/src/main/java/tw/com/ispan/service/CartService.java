package tw.com.ispan.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tw.com.ispan.domain.Cart;
import tw.com.ispan.domain.Members;
import tw.com.ispan.domain.Order;
import tw.com.ispan.domain.OrderProduct;
import tw.com.ispan.domain.ProductCart;
import tw.com.ispan.repository.CartRepository;
import tw.com.ispan.repository.MembersRepository;
import tw.com.ispan.repository.OrderProductRepository;
import tw.com.ispan.repository.OrderRepository;
import tw.com.ispan.repository.ProductCartRepository;

@Service
public class CartService {
//
//    @Autowired
//    private CartRepository cartRepository;
//
//    @Autowired
//    private OrderProductRepository orderProductRepository;
//
//    @Autowired
//    private OrderRepository orderRepository;
//    
//    @Autowired
//    private MembersRepository memberRepository;
//    
//    @Autowired
//    private ProductCartRepository productCartRepository;
//
//    @Transactional
//    public void checkout(Integer membersId) {
//        // 查找對應的會員
//        Members member = memberRepository.findById(membersId)
//            .orElseThrow(() -> new RuntimeException("Member not found"));
//
//        // 查找對應的購物車
//        Cart cart = cartRepository.findByMembers(member);
//
//        if (cart == null) {
//            throw new RuntimeException("Cart not found for member: " + membersId);
//        }
//
//        // 創建訂單
//        Order order = new Order();
//        order.setMembers(member);
//        order.setTotalPrice(cart.getTotalPrice());
//        order.setRemarks(cart.getRemarks());
//        order.setShippingFee(cart.getShippingFee());
//        order.setShippingMethod(cart.getShippingMethod());
//        order.setPayMethod(cart.getPayMethod());
//
//        Order savedOrder = orderRepository.save(order);
//
//        // 從購物車中創建訂單產品
//        List<ProductCart> productCarts = productCartRepository.findByCart(cart);
//        for (ProductCart productCart : productCarts) {
//            OrderProduct orderProduct = new OrderProduct();
//            orderProduct.setOrder(savedOrder);
//            orderProduct.setProduct(productCart.getProduct());
//            orderProduct.setCount(productCart.getCount());
//            orderProduct.setDailyFeeOriginal(productCart.getProduct().getDailyFeeOriginal());
//            // 計算小計
//            int subtotal = productCart.getCount() * productCart.getProduct().getDailyFeeOriginal();
//            orderProduct.setSubtotal(subtotal);
//
//            orderProductRepository.save(orderProduct);
//        }
//
//        // 清空購物車
//        cartRepository.delete(cart);
//    }
}
