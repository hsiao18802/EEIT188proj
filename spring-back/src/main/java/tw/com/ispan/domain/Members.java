package tw.com.ispan.domain;

import java.util.Date;
import java.util.Set;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
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
@Table(name = "members")
public class Members {


    @OneToMany(mappedBy = "members")
    private Set<Cart> cart;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="members_id")
	private Integer membersId;

	@Column(name="members_username")
	private String username;
	
	@Column(name="members_password")
	private byte[] password;
	
	@Column(name = "realname")
	private String realName;
	
	@Column(name="email", unique = true)
	private String email;
	
	@Column(name="phone")
	private String phone;
	
	@Column(name="address")
	private String address;
	
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss EEEE")
	@Column(name="registration_date")
	private Date registrationDate;
	
	@PrePersist
	protected void onCreate() {
	    registrationDate = new Date();
	}


	@Column(name="member_photo")
	private byte[] memberPhoto;

	}


