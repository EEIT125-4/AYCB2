package event.controller;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import event.model.Attendance;
import event.service.AttendanceService;
import event.service.AttendanceServiceImpl;



@WebServlet("/insertAttendance.do")
                   
public class InsertAttendanceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("insert attendance");
		request.setCharacterEncoding("utf-8");
		Map<String, String> errorMsg = new HashMap<String, String>();
		if(request.getAttribute("error")!=null) {request.removeAttribute("error");}
		request.setAttribute("error", errorMsg);
		//讀取輸入資料
		String id =request.getParameter("MemberID");
		String phone = request.getParameter("Phone");
		String mail = request.getParameter("Mailaddress");
		String eid = request.getParameter("EventID");		
		String pax= request.getParameter("Pax");
		
		System.out.println("id:"+id);
		
		//進行必要的型態轉換，
		
		//檢查輸入資料
		if(id == null || id.trim().length()==0){
			errorMsg.put("id","帳號不能空白");			
		}else {errorMsg.remove("id");}
		if(phone == null || phone.trim().length()==0){
			errorMsg.put("phone","手機號碼不能空白");			
		}else if(phone.trim().length()<10){
			errorMsg.put("phone","手機號碼長度錯誤");	
		}else{errorMsg.remove("phone");}
		if(mail ==null || mail.trim().length() ==0){
			errorMsg.put("mail", "email不能空白");
		}else {errorMsg.remove("mail");}
		
		
		
		if(eid ==null || eid.trim().length() ==0){
			errorMsg.put("eid", "活動id不能空白");
		}else {errorMsg.remove("eid");}	
		if(pax ==null || pax.trim().length()<1){
			errorMsg.put("pax", "參加人數須大於一");
		}else {errorMsg.remove("pax");}

//		}
		//企業邏輯的運算
		AttendanceService as = new AttendanceServiceImpl();
		if (as.isDup(id)){
			errorMsg.put("id", "帳號重複，請重新輸入新帳號");
			RequestDispatcher rd = request.getRequestDispatcher("/event/attendanceForm.jsp");
			rd.forward(request,response);
			return;
		}
		//轉向成功加入會員頁面
		HttpSession session = request.getSession();
		try{
			//將要寫入的資料裝到Bean內
			Attendance a = new Attendance(null,id,phone,mail,eid,pax);
			session.setAttribute("a", a);    
			as.save(a);    
		}catch(Exception e){
			errorMsg.put("id", "寫入資料時發生異常,訊息:"+ e.getMessage());
		}
		//沒有任何錯誤時
		if(errorMsg.isEmpty()){
			
			//不這樣寫是因為頁面不會跳轉,若案重新整理寫入資料會重做一遍,容易有疑慮
			//RequestDispatcher rd = request.getRequestDispatcher("/ch01/InsertSuccess.jsp");
			String url = request.getContextPath()+ "/event/insertSuccess.jsp";
			String targetURL = response.encodeRedirectURL(url);
			//新增資料成功,利用response.encodeRedirect送出回應,共用資料放在Session物件
			//新增資料失敗,利用RequestDispatcher送出回應,共用資料放在request物件
			response.sendRedirect(targetURL);
		}else{
			System.out.println("errorMsg="+errorMsg);
			System.out.println("sth error");
			RequestDispatcher rd = request.getRequestDispatcher("/event/attendanceForm.jsp");
			
			rd.forward(request,response);
			return;
		}
	}
}
