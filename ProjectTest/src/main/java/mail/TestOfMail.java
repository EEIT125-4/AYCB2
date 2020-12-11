//package mail;
//
//import javax.persistence.EntityManager;
//
//import mail.model.UserMailPK;
//import member.model.MemberBean;
//import member.service.MemberService;
//import member.service.impl.MemberServiceImpl;
//import message.model.MessageBean;
//import message.service.MessageService;
//import message.service.impl.MessageServiceImpl;
//
//public class TestOfMail {
//
//	public static void main(String[] args) {
//		
//		
//		MemberService ms1=new MemberServiceImpl();
//		
//		MemberBean mb=ms1.getMember(1);
//		MessageService ms2=new MessageServiceImpl();
//		
//		MessageBean message=ms2.getMessage("20201206001");
//		
//		
//		
//		UserMailPK pk=new UserMailPK();
//		pk.setMemberPk(mb.getPk());
//		pk.setMessageID(message.getMsg_id());
//
//		
//		
//	}
//
//}
