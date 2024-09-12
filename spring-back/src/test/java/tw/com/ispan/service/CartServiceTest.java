package tw.com.ispan.service;


import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import tw.com.ispan.domain.Cart;
import tw.com.ispan.domain.Members;
import tw.com.ispan.domain.Product;
import tw.com.ispan.repository.CartRepository;
import tw.com.ispan.repository.MembersRepository;
import tw.com.ispan.repository.ProductRepository;


@SpringBootTest
public class CartServiceTest {

    @Autowired
    private CartRepository cartRepo;
    
    @Autowired
    private ProductRepository productRepo;

    
    @Autowired
    private MembersRepository membersRepo;
    
    @Autowired
    private CartService cartService;
    
    @Test
    public void testaddToCart() {
    	System.err.println(cartService.addToCart(1, 1));
    }
    
    
    @Test
    public void testfindMembersCart() {
    	System.err.println(cartService.findMembersCart(1));
    }
    
    @Test
    public void testplusOne() {
    	System.err.println(cartService.plusOne(1,1));
    }
    
    @Test
    public void testminusOne() {
    	System.err.println(cartService.plusOne(1,1));
    }
    

    
    
    
	 //@test
	// 車內商品數量 -1
	@Transactional
	public void testminusOne(Integer productId, Integer membersId) {
		Cart existCart = cartRepo.findByMembersIdAndProductId(membersId, productId);
		
		if(existCart.getCount() == 1) {
			cartRepo.delete(existCart);
		}else {
			existCart.setCount(existCart.getCount() - 1);
		}
		
	}


}

