//package mail.model;
//
//import java.sql.Date;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.Id;
//import javax.persistence.Table;
//
//
//@Entity
//@Table(name = "mail")
//public class MailBean  {
//	
//	//一個訊息對應多個使用者
//	//這個table應該顯示使用者收到哪些信息,並依使用者行為改變狀態
//	
//	
//	
//		@Id
//		@Column(columnDefinition = "NVARCHAR(11)")
//		String id;
//		@Column(columnDefinition = "NVARCHAR(MAX) NOT NULL")
//		private String title, content, type;
//		@Column(columnDefinition = "NVARCHAR(MAX)")
//		private String imgpath;
//			
//		private Date date;
//		private Date editDate;
//
//		public Date getEditDate() {
//			return editDate;
//		}
//
//		public void setEditDate(Date editDate) {
//			this.editDate = editDate;
//		}
//
//		public MailBean() {
//
//		}
//
//
//}
