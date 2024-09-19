package tw.com.ispan.service;


import java.util.Base64;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.com.ispan.DTO.CartDTO;
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
    
    public Set<Cart> findCartsByMembesrId2(Integer membersId) {
        return cartRepo.findByMembersIdWithProduct(membersId);
    }


    
    @Transactional
    public Cart addToCart(CartDTO cartDTO) {

        Cart existCart = cartRepo.findByMembersIdAndProductId(cartDTO.getMembersId(), cartDTO.getProductId());

        if (existCart != null) {
            // 更新數量
            existCart.setCount(existCart.getCount() + cartDTO.getCount());
            return cartRepo.save(existCart);
        }

        // 查找會員
        Optional<Members> optionalMember = membersRepo.findById(cartDTO.getMembersId());
        if (!optionalMember.isPresent()) {
            throw new RuntimeException("Member not found with id: " + cartDTO.getMembersId());
        }
        Members members = optionalMember.get();

        // 查找產品
        Optional<Product> optionalProduct = productRepo.findById(cartDTO.getProductId());
        if (!optionalProduct.isPresent()) {
            throw new RuntimeException("Product not found with id: " + cartDTO.getProductId());
        }
        Product product = optionalProduct.get();

        // 創建新的 Cart Entity
        Cart cart = new Cart();
        cart.setProduct(product);
        cart.setMembers(members);
        cart.setCount(cartDTO.getCount());
        cart.setRentalStartDate(cartDTO.getRentalStartDate());
        cart.setRentalEndDate(cartDTO.getRentalEndDate());
     
       

        return cartRepo.save(cart);
    }

    
    //查找會員購物車內容
	
    public Set<Cart> findCartsByMembesrId(Integer membersId) {
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
	
	 
     // 從購物車中移除商品
    @Transactional
    public void removeFromCart(Integer membersId, Integer productId) {
        Cart existCart = cartRepo.findByMembersIdAndProductId(membersId, productId);
        if (existCart != null) {
            cartRepo.delete(existCart);
        }
    }
    
    public void clearCartByMembersId(String membersId) {
        // 根據會員 ID 清空購物車資料
    	cartRepo.deleteByMembersId(membersId);
    }
//  
////CartDTO 會包含來自購物車、產品和會員的數據，並可以將這些數據發送到前端。
//    public CartDTO convertCartToDTO(Cart cart) {
//        CartDTO cartDTO = new CartDTO();
//        
//        cartDTO.setCartId(cart.getCartId());
//        cartDTO.setCount(cart.getCount());
//        cartDTO.setRentalStartDate(cart.getRentalStartDate());
//        cartDTO.setRentalEndDate(cart.getRentalEndDate());
//
//        //  
//        if (cart.getMembers() != null) {
//            cartDTO.setMembersId(cart.getMembers().getMembersId());
//        }
//
//        // 設置產品相關屬性
//        if (cart.getProduct() != null) {
//            cartDTO.setProductId(cart.getProduct().getProductId());
//            cartDTO.setProductName(cart.getProduct().getProductName());
//            cartDTO.setDailyFeeOriginal(cart.getProduct().getDailyFeeOriginal()); // 轉換每日租金
//    	    System.out.println("convertCartToDTO_Product dailyFeeOriginal: " + cart.getProduct().getDailyFeeOriginal());
//
//         // 將圖片直接轉換為 byte[]
//            if (cart.getProduct().getMainPhoto() != null) {
//                cartDTO.setMainPhoto(cart.getProduct().getMainPhoto());
//            }
//        }
//
//        return cartDTO;
//    }

//    
//    1. 將轉換邏輯留在 CartService 中的優點：
//    集中處理業務邏輯： 如果 CartService 已經負責處理 Cart 的業務邏輯，將轉換邏輯放在 CartService 內可以集中處理，方便統一管理。
//    減少額外的類： 如果只是少量的轉換邏輯，將它放在 CartService 內可以避免創建額外的類別，減少類的數量，讓代碼更加簡潔。
//    缺點：
//    單一職責原則違反 (SRP)： 如果 CartService 同時處理業務邏輯和 DTO 的轉換，這可能會違反單一職責原則，因為 CartService 的主要職責是處理業務邏輯，而轉換 DTO 應該是不同的職責。
//    代碼膨脹： 隨著功能增加，轉換邏輯可能變得複雜，讓 CartService 的代碼過於冗長。
   
}



