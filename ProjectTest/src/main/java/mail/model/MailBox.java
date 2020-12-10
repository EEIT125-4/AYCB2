//package mail.model;
//
//import java.io.Serializable;
//
//import javax.persistence.CascadeType;
//import javax.persistence.EmbeddedId;
//import javax.persistence.Entity;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.Table;
//
//import member.model.MemberBean;
//import message.model.MessageBean;
//@Entity
//@Table(name="mailbox")
//public class MailBox implements Serializable {
//	
//	@EmbeddedId
//	
//	private UserMailPK mailPK;
//	private Integer state;
//	public UserMailPK getMailPK() {
//		return mailPK;
//	}
//	
//	@ManyToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name="pk")//會員的主鍵
//	MemberBean member;
//	
//	public void setMailPK(UserMailPK mailPK) {
//		this.mailPK = mailPK;
//	}
//	public Integer getState() {
//		return state;
//	}
//	
//	//預設0=未讀,1=已讀
//	public void setState(Integer state) {
//		this.state = state;
//	}
//	
//	
//	
//
//}
