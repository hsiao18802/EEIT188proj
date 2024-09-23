package tw.com.ispan.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "product_status")
public class ProductStatus {
	
    @Id
    @Column(name = "status_id")
    private Integer statusId;

    @Column(name = "status")
    private String status;
    
}