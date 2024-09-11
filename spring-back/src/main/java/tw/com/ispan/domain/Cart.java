	package tw.com.ispan.domain;


import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


@Entity
@Table(name="cart")
public class Cart {
	
	// cart - member 1:1 
	
	


    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "members_id")
    private Members members;
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cart_id")
	private Integer cartId;
	
	

	@OneToMany(mappedBy = "cart", fetch = FetchType.LAZY)
	    private List<ProductCart> productCart;  // 產品在購物車中的條目
    
	@Column(name = "total_price")
    private Integer totalPrice;  // 總價
	
	@Column(name = "deposit")
    private Integer deposit;  // 押金
	
	@Column(name = "remarks")
    private String remarks;  // 備註
	 
	@Column(name = "shipping_fee")
    private Integer shippingFee;  // 運輸費用
	
	 @Column(name = "shipping_method")
    private String shippingMethod;  // 運輸方式
	 
	 @Column(name = "pay_method")
	 private String payMethod;  // 付款方式

	public Members getMembers() {
		return members;
	}

	public void setMembers(Members members) {
		this.members = members;
	}

	public Integer getCartId() {
		return cartId;
	}

	public void setCartId(Integer cartId) {
		this.cartId = cartId;
	}

	public Integer getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Integer totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Integer getDeposit() {
		return deposit;
	}

	public void setDeposit(Integer deposit) {
		this.deposit = deposit;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Integer getShippingFee() {
		return shippingFee;
	}

	public void setShippingFee(Integer shippingFee) {
		this.shippingFee = shippingFee;
	}

	public String getShippingMethod() {
		return shippingMethod;
	}

	public void setShippingMethod(String shippingMethod) {
		this.shippingMethod = shippingMethod;
	}

	public String getPayMethod() {
		return payMethod;
	}

	public void setPayMethod(String payMethod) {
		this.payMethod = payMethod;
	}
	

	  public List<ProductCart> getProductCart() {
		return productCart;
	}

	public void setProductCart(List<ProductCart> productCart) {
		this.productCart = productCart;
	}


    
    
    
	
	


	

	

}
