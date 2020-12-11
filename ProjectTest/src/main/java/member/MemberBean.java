package member;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity

public class MemberBean implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(columnDefinition = "nvarchar(Max)")
	private String account;
	@Column(columnDefinition = "nvarchar(Max)")
	private String name;
	@Column(columnDefinition = "nvarchar(Max)")
	private String password;
	@Column(columnDefinition = "nvarchar(Max)")
	private String address;
	@Column(columnDefinition = "nvarchar(Max)")
	private String phone;
	private Date birth;
	@Column(columnDefinition = "nvarchar(Max)")
	private String email;
	@Column(columnDefinition = "nvarchar(Max)")
	private String gender;
	
	public MemberBean() {
		
	}
	
	
	
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		id = id;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MemberBean [Id=");
		builder.append(id);
		builder.append(", account=");
		builder.append(account);
		builder.append(", name=");
		builder.append(name);
		builder.append(", password=");
		builder.append(password);
		builder.append(", address=");
		builder.append(address);
		builder.append(", phone=");
		builder.append(phone);
		builder.append(", birth=");
		builder.append(birth);
		builder.append(", email=");
		builder.append(email);
		builder.append(", gender=");
		builder.append(gender);
		builder.append("]");
		return builder.toString();
	}

	public MemberBean(Integer id, String account, String name, String password, String address, String phone,
			Date birth, String email, String gender) {
		super();
		id = id;
		this.account = account;
		this.name = name;
		this.password = password;
		this.address = address;
		this.phone = phone;
		this.birth = birth;
		this.email = email;
		this.gender = gender;
	}


}