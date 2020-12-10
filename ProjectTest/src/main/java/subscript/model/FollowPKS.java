//package subscript.model;
//
//import java.io.Serializable;
//
//import javax.persistence.CascadeType;
//import javax.persistence.Column;
//import javax.persistence.EmbeddedId;
//import javax.persistence.FetchType;
//import javax.persistence.JoinColumn;
//import javax.persistence.JoinColumns;
//import javax.persistence.ManyToOne;
//
//import member.model.MemberBean;
//import message.model.MessageBean;
//
//
//
//public class FollowPKS {
//
//	
//		
//	 
//		@ManyToOne(fetch=FetchType.LAZY)
//			
////			@JoinColumns({
////				
////				@JoinColumn(name="memberPK",referencedColumnName="pk"),
////				@JoinColumn(name="messageType",referencedColumnName="type")
////				
////			})
//		@JoinColumn(name="memberPK",referencedColumnName="pk")
//		
//		private MemberBean member;
//		
//		@Column(columnDefinition = "nvarchar(50)")
//		private String scriptType;
//		
//
//		//private Integer state;
//
//
//		public MemberBean getMember() {
//			return member;
//		}
//
//
//		public void setMember(MemberBean mb) {
//			this.member = mb;
//		}
//		
//
//		public String getScriptType() {
//			return scriptType;
//		}
//
//
//		public void setScriptType(String scriptType) {
//			this.scriptType = scriptType;
//		}
//
//
//		
//
//
////		public Integer getState() {
////			return state;
////		}
//	//
//	//
////		public void setState(Integer state) {
////			this.state = state;
////		}
//
//
//		@Override
//		public String toString() {
//			StringBuilder builder = new StringBuilder();
//			builder.append("FollowPK [member=");
//			builder.append(member);
//			builder.append(", scriptType=");
//			builder.append(scriptType);
//			builder.append("]");
//			return builder.toString();
//		}
//
//
//	}
//
//
