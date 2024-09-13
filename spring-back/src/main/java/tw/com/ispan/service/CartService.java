package tw.com.ispan.service;


import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.com.ispan.domain.Cart;
import tw.com.ispan.domain.Members;
import tw.com.ispan.domain.Product;
import tw.com.ispan.repository.CartRepository;
import tw.com.ispan.repository.MembersRepository;

import tw.com.ispan.repository.ProductRepository;


@Service
public class CartService {

    @Autowired
    private CartRepository cartRepo;
    
    @Autowired
    private ProductRepository productRepo;

    
    @Autowired
    private MembersRepository membersRepo;
    
    @Transactional
	public Cart addToCart(Integer membersId, Integer productId) {
		
		Cart existCart = cartRepo.findByMembersIdAndProductId(membersId, productId);
		
		if(existCart != null) {
			existCart.setCount(existCart.getCount() + 1);
			return existCart;
		}
		
		 // 查找會員
		Optional<Members> optionalMember = membersRepo.findById(membersId);
		if (!optionalMember.isPresent()) {
	        throw new RuntimeException("Member not found with id: " + membersId);
	    }
		Members members = optionalMember.get();
		
		// 查找產品
	    Optional<Product> optionalProduct = productRepo.findById(productId);
	    if (!optionalProduct.isPresent()) {
	        throw new RuntimeException("Product not found with id: " + productId);
	    }
	    Product product = optionalProduct.get();
	    
	    
		
		// Cart Entity 給值
		Cart cart = new Cart();
		cart.setProduct(product);
		cart.setMembers(members);
		cart.setCount(1);
		
		return cartRepo.save(cart);
	}
	
    public Set<Cart> findMembersCart(Integer membersId) {
        // 使用 Members 来查询
        Members members = membersRepo.findById(membersId)
            .orElseThrow(() -> new RuntimeException("会员ID不存在: " + membersId));
        
        return cartRepo.findByMembers(members); // 根據會員找CART
    }
	
	// 車內商品數量 + 1
	@Transactional
	public Cart plusOne(Integer productId, Integer membersId) {
		Cart existCart = cartRepo.findByMembersIdAndProductId(membersId, productId);
		existCart.setCount(existCart.getCount() + 1);
		return existCart;
	}
	
	// 車內商品數量 -1
	@Transactional
	public void minusOne(Integer productId, Integer membersId) {
		Cart existCart = cartRepo.findByMembersIdAndProductId(membersId, productId);
		
		if(existCart.getCount() == 1) {
			cartRepo.delete(existCart);
		}else {
			existCart.setCount(existCart.getCount() - 1);
		}
		
	}


}

