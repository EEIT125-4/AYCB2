//package subscript;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.Transaction;
//
//import member.model.MemberBean;
//import member.service.MemberService;
//import member.service.impl.MemberServiceImpl;
//import message.model.MessageBean;
//import message.service.MessageService;
//import message.service.impl.MessageServiceImpl;
//import subscript.model.Follow;
//import subscript.model.FollowPK;
//import tool.HibernateUtils;
//
//public class TestOfFollow {
//
//	public static void main(String[] args) {
//		
//		
//		MemberService ms1=new MemberServiceImpl();
//		
//		List<MemberBean> members=ms1.getAllMembers();
//		MemberBean member1=ms1.getMember(1);
//		MemberBean member2=ms1.getMember(2);
//		System.out.println(member1);
//		System.out.println(member2);
//		for(MemberBean m:members) {
//			
//			System.out.println("member:"+m);
//			
//		}
//		System.out.println("==================");
//		
//		MessageService ms2=new MessageServiceImpl();
//		MessageBean message1=ms2.getMessage("20201207001");
//		MessageBean message2=ms2.getMessage("202012075");
//		System.out.println(message1);
//		System.out.println(message2);
//		
//		System.out.println("===================");
//		
//		
////		subscript.model.FollowPK fPk=new subscript.model.FollowPK();
////		fPk.setMember(mBean);
////		fPk.setScriptType("girl");
//		
//		//Follow follow1=new Follow(fPk);
//		
//		Follow follow1=new Follow();
//		follow1.setMember(member1);
//		follow1.setScriptType("type1");	
//		Follow follow2=new Follow();
//		
//		follow2.setMember(member2);
//		follow2.setScriptType("type2");
//		System.out.println("follow1:");
//		System.out.println(follow1);
//		System.out.println("follow2:");
//		System.out.println(follow2);
//		
//		System.out.println("==============");
//		
//		
//		SessionFactory factory = HibernateUtils.getSessionFactory();
//		Session session = factory.openSession();
//		Transaction tx = session.beginTransaction();
//		
//		
//		try{
//			session.save(follow1);
//			
//			System.out.println("----------------");
//			
//			tx.commit();
//		} catch(Exception e){
//			System.out.println(e);
//			if (tx != null) 
//				tx.rollback();
//		} finally{
//			if (session != null)
//			session.close();
//		}
//		HibernateUtils.shutdown();
//		
//		
//	}
//
//}
