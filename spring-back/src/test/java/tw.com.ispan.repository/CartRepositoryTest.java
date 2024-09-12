//package tw.com.ispan.repositoryTest;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import static org.junit.jupiter.api.Assertions.*;
//import java.util.List;
//
//import tw.com.ispan.domain.Cart;
//import tw.com.ispan.domain.Members;
//import tw.com.ispan.repository.CartRepository;
//
//@SpringBootTest
//public class CartRepositoryTest {
//
//    @Autowired
//    private CartRepository cartRepository;
//
//    // 測試 findByMembersIdAndProductId 方法
//    @Test
//    public void testFindByMembersIdAndProductId() {
//        // 假設這裡有一個已經存在的 membersId 和 productId
//        Integer membersId = 1;
//        Integer productId = 1;
//
//        Cart cart = cartRepository.findByMembersIdAndproductId(membersId, productId);
//        assertNotNull(cart); // 檢查 cart 不為 null
//        System.out.println(cart.getMembers().getMembersId()) ;
//        System.out.println(cart.getProduct().getProductId())
//        assertEquals(membersId, cart.getMembers().getMembersId()); // 驗證 membersId
///       assertEquals(productId, cart.getProductId()); // 驗證 productId
//    }
//
//    // 測試 findMembersCartQuery 方法
//   // @Test
//    public void testFindMembersCartQuery() {
//        Integer membersId = 1;
//        List<Cart> carts = cartRepository.findMembersCartQuery(membersId);
//        assertNotNull(carts); // 檢查 carts 不為 null
//        assertFalse(carts.isEmpty()); // 檢查結果不為空
//        for (Cart cart : carts) {
//            assertEquals(membersId, cart.getMembersId()); // 驗證所有的 cart 都屬於該 membersId
//        }
//    }
//
//    // 測試 findByMembers 方法
//    //@Test
//    public void testFindByMembers() {
//        // 假設這裡有一個已經存在的 Members 物件
//        Members member = new Members();
//        member.setId(1); // 設定一個已知的會員ID
//        
//        List<Cart> carts = cartRepository.findByMembers(member);
//        assertNotNull(carts); // 檢查 carts 不為 null
//        assertFalse(carts.isEmpty()); // 檢查結果不為空
//    }
//
//    // 測試 findByMembersId 方法
//    //@Test
//    public void testFindByMembersId() {
//        Integer membersId = 1;
//        List<Cart> carts = cartRepository.findByMembersId(membersId);
//        assertNotNull(carts); // 檢查 carts 不為 null
//        assertFalse(carts.isEmpty()); // 檢查結果不為空
//        for (Cart cart : carts) {
//            assertEquals(membersId, cart.getMembersId()); // 驗證所有的 cart 都屬於該 membersId
//        }
//    }
//}
