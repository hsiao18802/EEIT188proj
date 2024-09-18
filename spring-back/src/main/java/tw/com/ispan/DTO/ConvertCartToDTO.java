package tw.com.ispan.DTO;

import tw.com.ispan.domain.Cart;

public class ConvertCartToDTO {
	
	public CartDTO convertCartToDTO(Cart cart) {
	    CartDTO cartDTO = new CartDTO();
	    cartDTO.setCartId(cart.getCartId());
	    cartDTO.setProductId(cart.getProduct().getProductId());
	    cartDTO.setProductName(cart.getProduct().getProductName());
	    cartDTO.setCount(cart.getCount());
	    cartDTO.setMainPhoto(cart.getProduct().getMainPhoto()); // 轉換主照片
	    cartDTO.setDailyFeeOriginal(cart.getProduct().getDailyFeeOriginal()); // 轉換每日租金
	    System.out.println("convertCartToDTO_Product dailyFeeOriginal: " + cart.getProduct().getDailyFeeOriginal());

	    cartDTO.setRentalStartDate(cart.getRentalStartDate());
	    cartDTO.setRentalEndDate(cart.getRentalEndDate());
	    cartDTO.setMembersId(cart.getMembers().getMembersId());
	    

	    return cartDTO;
	}
	
	



}
