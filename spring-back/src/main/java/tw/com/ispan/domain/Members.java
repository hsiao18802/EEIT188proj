package tw.com.ispan.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="members")
public class Members {
	
//  member - cart 一對一
    @OneToOne(mappedBy = "members")
    private Cart cart;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="members_id")
	private Integer membersId;

	@Column(name="members_username")
	private String username;
	
	@Column(name="members_password")
	private byte[] password;
	
	
	@Column(name="realname")
	private String realName;
	
	@Column(name="email")
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

	public Cart getCart() {
		return cart;
	}


	public void setCart(Cart cart) {
		this.cart = cart;
	}





	public Integer getMembersId() {
		return membersId;
	}


	public void setMembersId(Integer membersId) {
		this.membersId = membersId;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public byte[] getPassword() {
		return password;
	}


	public void setPassword(byte[] password) {
		this.password = password;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public Date getRegistrationDate() {
		return registrationDate;
	}


	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}


	public byte[] getMemberPhoto() {
		return memberPhoto;
	}


	public void setMemberPhoto(byte[] memberPhoto) {
		this.memberPhoto = memberPhoto;
	}

	
	
	
	
	
	
	
	
}
