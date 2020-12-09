package member;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;




public class MemberBean implements Serializable {

	Integer pk;	
	private String name;
	private String account;
	private String password;
	private String address;
	private String phone;
	private Date birth;
	private String email;
	private String gender;


	public MemberBean(){
		
	}
	
	public MemberBean(String name,String account, String password, String address, String phone, Date birth, String email, String gender) {
//		super();
		this.name = name;
		this.account = account;
		this.password = password;
		this.address = address;
		this.phone = phone;
		this.birth = birth;
		this.email = email;
		this.gender = gender;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
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
		return "MemberBean [name=" + name + ", password=" + password + ", address=" + address + ", phone=" + phone
				+ ", birth=" + birth + ", email=" + email + ", gender=" + gender + "]";
	}





}
	