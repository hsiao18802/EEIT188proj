	package tw.com.ispan.domain;


import java.util.Date;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Transient;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name="cart")
public class Cart {
	
	

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;
	
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "members_id")
    private Members members;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cart_id")
	private Integer cartId;
	
	
	@Column(name = "count")
	private Integer count;  // 租借的數量
	
	
	@Column(name = "rental_start_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date rentalStartDate;  // 租借開始日期
	
	@Column(name = "rental_end_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date rentalEndDate;  // 租借結束日期

	@Override
	public String toString() {
		return "Cart [product=" + product + ", members=" + members + ", cartId=" + cartId + ", count=" + count
				+ ", rentalStartDate=" + rentalStartDate + ", rentalEndDate=" + rentalEndDate + "]";
	}
	
	
	
	
	//   @Transient
	  //  public Integer getProductId() {
	    //    return product != null ? product.getProductId() : null;
	   // }
	
//使用了 @JsonIgnore 註解，這會告訴 Jackson 在序列化 Cart 對象時忽略 Product 和 Members 對象的詳細信息。
	   //因此，你的 JSON 輸出中不會顯示 productId。
	   
	   //上面的 getProductId 方法是使用 @Transient 註解來避免被映射到資料庫表中。
	   //它從 Product 對象中獲取 productId，並在序列化時使用這個方法來獲取 productId
	
	
	}




    
    
   
