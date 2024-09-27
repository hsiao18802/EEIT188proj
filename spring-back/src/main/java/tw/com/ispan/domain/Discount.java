package tw.com.ispan.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@ToString
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "discount")
public class Discount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "discount_id")
    private Integer discountId;

    @Column(name = "code")
    private String code;  // 折扣碼

    @Column(name = "description")
    private String description;  // 折扣碼描述

    @Column(name = "discount_type")
    private String discountType;  // 折扣類型（如百分比折扣、固定金額折扣等）

    @Column(name = "discount_value")
    private Double discountValue;  // 折扣值（根據類型可能是百分比或金額）

    @Column(name = "start_date")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startDate;  // 折扣開始日期

    @Column(name = "end_date")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDate;  // 折扣結束日期

    @Column(name = "usage_limit")
    private Integer usageLimit;  // 折扣碼使用次數限制

    @Column(name = "usage_count")
    private Integer usageCount;  // 當前已使用次數
    
    @Column(name = "is_active")
    private Boolean isActive;  // 是否可用
}
