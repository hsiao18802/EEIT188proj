package tw.com.ispan.domain;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "customer_service_request")
public class CustomerServiceRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
   

    @Column(name = "issue_description")
    private String issueDescription;

    @Column(name = "status")
    private String status;

    // 將實體類中的 createdAt 屬性與資料庫中的 request_date 欄位對應
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "request_date") // 這裡指定資料庫欄位名稱
    private Date createdAt;
    
    
    // 確保這裡的成員名稱為 member
    @ManyToOne
    @JoinColumn(name = "members_id") // 外鍵欄位名稱，與 Members 表的 members_id 對應
    private Members member;
 
}


