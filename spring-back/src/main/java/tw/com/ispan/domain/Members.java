package tw.com.ispan.domain;

import java.util.Date;
import java.util.Set;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString; // 加入這個

@ToString
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "members")
public class Members {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "members_id")
    private Integer membersId;

    @Column(name = "members_username")
    private String username;

    @Column(name = "members_password")
    private byte[] password;

    @Column(name = "realname")
    private String realName;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "address")
    private String address;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss EEEE")
    @Column(name = "registration_date")
    private Date registrationDate;

    @PrePersist
    protected void onCreate() {
        registrationDate = new Date();
    }

    @Column(name = "member_photo")
    private byte[] memberPhoto;

    
    // 黑名單標記
    @Column(name = "black_listed", nullable = false)
    private boolean blacklisted = false;
    
    
    
    
    // 聊天記錄
    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    @JsonIgnore
    @ToString.Exclude // 排除這個屬性
    private Set<ChatRecord> chatRecords;

    // 客服請求
    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    @JsonIgnore
    @ToString.Exclude // 排除這個屬性
    private Set<CustomerServiceRequest> customerServiceRequests;
}
