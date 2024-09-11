package tw.com.ispan.domain;

import java.util.Date;
import java.util.List;
import tw.com.ispan.domain.Order;


import jakarta.persistence.*;

@Entity
@Table(name = "order")  
public class Order {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Integer orderId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "members_id")
    private Members members;  // 對應到會員
    
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderProduct> orderProduct;  // 每個訂單對應的產品明細

    @Column(name = "order_creation_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date orderDate;

    @Column(name = "total_price_amount")
    private Integer totalPrice;

    @Column(name = "shipping_fee")
    private Integer shippingFee;

    @Column(name = "shipping_method")
    private String shippingMethod;

    @Column(name = "pay_method")
    private String payMethod;
    

    @Column(name = "remarks")
    private String remarks;  // 備註


    
    
    // 公共的無參構造函數
    public Order() {}




	public Integer getOrderId() {
		return orderId;
	}




	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}




	public Members getMembers() {
		return members;
	}




	public void setMembers(Members members) {
		this.members = members;
	}




	public List<OrderProduct> getOrderProduct() {
		return orderProduct;
	}




	public void setOrderProduct(List<OrderProduct> orderProduct) {
		this.orderProduct = orderProduct;
	}




	public Date getOrderDate() {
		return orderDate;
	}




	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}




	public Integer getTotalPrice() {
		return totalPrice;
	}




	public void setTotalPrice(Integer totalPrice) {
		this.totalPrice = totalPrice;
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




	public String getRemarks() {
		return remarks;
	}




	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}




	

    
}
