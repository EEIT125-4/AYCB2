//package mail.model;
//
//import java.io.Serializable;
//import java.util.Objects;
///**
// * 
// * @author user
// *嘗試雙主鍵定義
// */
//
//import javax.persistence.JoinColumn;
//import javax.persistence.JoinColumns;
//import javax.persistence.ManyToOne;
//public class UserMailPK implements Serializable{
//	
//	
//	
//	private Integer memberPK;
//
//	private String messageID;
//	public Integer getMemberPk() {
//		return memberPK;
//	}
//	public void setMemberPk(Integer memberPk) {
//		this.memberPK = memberPk;
//	}
//	public String getMessageID() {
//		return messageID;
//	}
//	public void setMessageID(String messageID) {
//		this.messageID = messageID;
//	}
//	@Override
//	public int hashCode() {
//		
//		return Objects.hash(memberPK, messageID);
//	}
//	@Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        UserMailPK that = (UserMailPK) o;
//        return memberPK.equals(that.memberPK) &&
//                messageID.equals(that.messageID);
//    }
//	
//	
//	
//	//name代表在自己表格的欄位名稱,reference代表參照的表格欄未名稱
////	@ManyToOne(fetch = FetchType.LAZY)
////	@JoinColumns({
////		
////	@JoinColumn(name="memberpk",referencedColumnName="pk"),
////	@JoinColumn(name="messageid", referencedColumnName="id")
////	})
////	private 
//	
//	
//	
//	
//	
//	
//	
//	
//
//}
