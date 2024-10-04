package tw.com.ispan.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "product_category")
public class ProductCategory {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 使用自動生成主鍵
    @Column(name = "category_id")
    private Integer categoryId;
    

    @Column(name = "category_name")
    private String categoryName;
    
    @Column(name = "display_sequence")
    private Integer displaySequence;
    
}