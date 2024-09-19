package tw.com.ispan.domain;

import java.util.Date;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "product")
public class Product {
	
	@JsonIgnore
    @OneToMany(mappedBy = "product")
    private Set<Cart> cart;
	

	
	

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Integer productId;

    @Column(name = "product_name")
    private String productName;
    

    @Column(name = "daily_fee_original")
    private Integer dailyFeeOriginal;

    @Column(name = "max_available_quantity")
    private Integer maxAvailableQuantity;

    @Lob
    @Column(name = "main_photo")
    private byte[] mainPhoto;
    // 商品主資料表放一張照片
    // 因為前端只要有商品的地方都至少會有這一張圖
    // 但是除了商品展示頁面以外，其實也都只會放這一張
    // 那就把其他的照片拆到別的資料表，主資料表放個一張
    // 這樣只要一張照片的時候就不用另外叫其他資料表
    // 寫起來會比較好寫

    @Column(name = "description")
    private String description;
    
    @Column(name = "description_two")
    private Boolean descriptionTwo;

    @Column(name = "category_id")
    private Integer categoryId;
    // 這裡指的是產品類別，例如帳篷一類、登山杖一類、手電筒一類之類的
    // 寫id就表示有另外一張專門放類別的表，這裡放的是id的類別
    // 不過或許也可以直接把類別寫在這裡，不要另拆一張表就是了
    
    @Column(name = "status_id")
    private Integer statusId;

    @Column(name = "add_datetime")
    private Date addDatetime;
    // 這個還有下一行新增員工的id理論上應該要限制不能NULL
    // 不過員工帳號還沒有做出來，那就通通都NULL，反正下單的時候用不到

    @Column(name = "add_employee_id")
    private Integer addEmployeeId;

    @Column(name = "last_update_datetime")
    private Date lastUpdateDatetime;

    @Column(name = "last_update_employee_id")
    private Integer lastUpdateEmployeeId;

    
}
