//package subscript.model;
//
//import java.io.Serializable;
//
//import javax.persistence.CascadeType;
//import javax.persistence.Column;
//import javax.persistence.Embeddable;
//import javax.persistence.EmbeddedId;
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.JoinColumns;
//import javax.persistence.ManyToOne;
//import javax.persistence.OneToMany;
//import javax.persistence.Table;
//
//import member.model.MemberBean;
//import message.model.MessageBean;
//
//@Entity
//@Table(name="follow")
//public class Follow implements Serializable{
//	//@EmbeddedId
//	@ManyToOne(fetch=FetchType.LAZY)
//	
//	//@JoinColumn(name="memberPK",referencedColumnName="pk")
//	
//	
//	
//	@Id
//	@JoinColumn(name="memberPK",referencedColumnName="pk")
//	private MemberBean member;
////	@Id
////	@JoinColumn(name="messageType",referencedColumnName="type")
////	private MessageBean message;
//	
//	//private FollowPK followPK;
//	
//	@Column(columnDefinition = "nvarchar(50)")
//	private String scriptType;
//
//	public Follow() {
//		
//	}
//
//	public Follow(MemberBean member,String type) {
//		super();
//		this.member = member;
//		this.scriptType=type;
//	}
//	
//	
//
//	public MemberBean getMember() {
//		return member;
//	}
//
//	public void setMember(MemberBean member) {
//		this.member = member;
//	}
//
//	public String getScriptType() {
//		return scriptType;
//	}
//
//	public void setScriptType(String scriptType) {
//		this.scriptType = scriptType;
//	}
//
//	
//	
//
////	public FollowPK getFollowPK() {
////		return followPK;
////	}
//
////	public void setFollowPK(FollowPK followPK) {
////		this.followPK = followPK;
////	}
//
//
//	
//	
//}
