package tw.com.ispan.domain;



import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;


@Entity
@Table(name="product_cart")
public class ProductCart {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="product_cart_id")
	private Integer productCartId;
	

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "product_id")  // 
	private Product product;
	
	

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cart_id")
	private Cart cart;
	
	
	@Column(name = "count")
	private Integer count;  // 租借的數量
	
	
	@Column(name = "rental_start_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date rentalStartDate;  // 租借開始日期
	
	@Column(name = "rental_end_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date rentalEndDate;  // 租借結束日期

	

	public Integer getProductCartId() {
		return productCartId;
	}

	public void setProductCartId(Integer productCartId) {
		this.productCartId = productCartId;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Date getRentalStartDate() {
		return rentalStartDate;
	}

	public void setRentalStartDate(Date rentalStartDate) {
		this.rentalStartDate = rentalStartDate;
	}

	public Date getRentalEndDate() {
		return rentalEndDate;
	}

	public void setRentalEndDate(Date rentalEndDate) {
		this.rentalEndDate = rentalEndDate;
	}

	
	}

	
    
    
    
    
	
	
