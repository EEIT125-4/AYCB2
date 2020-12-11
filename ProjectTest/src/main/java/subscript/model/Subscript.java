//package subscript.model;
//
//import javax.persistence.CascadeType;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.Table;
//
//import member.model.MemberBean;
//
//
//@Entity
//@Table(name="subscript_table")
//public class Subscript {
//	//以會員PK為主要參考,只需要單向查找
//	@Id
//	@ManyToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name="pk")
//	MemberBean mb;
//	
//	@Id
//	@ManyToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name="type")
//	@Column(name="subscriptType", columnDefinition="NVARCHAR(50) NOT NULL")
//	
//	String subscriptType;
//	
//	
//	public Subscript() {};
//
//	public Subscript(MemberBean mb, String subscriptType) {
//		super();
//		this.mb = mb;
//		this.subscriptType = subscriptType;
//	}
//
//	public MemberBean getMb() {
//		return mb;
//	}
//
//	public void setMb(MemberBean mb) {
//		this.mb = mb;
//	}
//
//	public String getSubscriptType() {
//		return subscriptType;
//	}
//
//	public void setSubscriptType(String subscriptType) {
//		this.subscriptType = subscriptType;
//	}
//	
//	
//
//}
