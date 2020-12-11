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



@WebServlet({ "/AttendanceUpdate.do" })
public class AttendanceUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession hsession = request.getSession();
		Map<String,String> errorMsg = new HashMap<>();
		hsession.setAttribute("error", errorMsg);
		String modify = request.getParameter("finalDecision");
		Integer aid = Integer.valueOf(request.getParameter("aid"));
		AttendanceService as = new AttendanceServiceImpl();
		int count=0;
		if(modify.equals("DELETE")){
			count = as.deleteAttendance(aid);
			if(count ==1){
				hsession.setAttribute("modify", "刪除成功");
			}else{
				hsession.setAttribute("modify", "刪除時發生異常");
			}
			String url = request.getContextPath()+"/queryAllAttendance.do";
			String newurl = response.encodeRedirectURL(url);
			response.sendRedirect(newurl);
			
		}else if(modify.equals("UPDATE")){
			
//			Integer aid = Integer.valueOf(request.getParameter("aid"));
			String id =request.getParameter("MemberID");
			String phone = request.getParameter("Phone");
			String eid = request.getParameter("EventID");
			String mail = request.getParameter("Mailaddress");
			String pax = request.getParameter("Pax");
			System.out.println("++++++++++++++++++++++++++");
			System.out.println(eid);
			System.out.println(phone);
			System.out.println(mail);
			System.out.println(pax);
			System.out.println("++++++++++++++++++++++++++");
			
			//檢查輸入的資料
			if (id == null || id.trim().length() == 0) {
				errorMsg.put("MemberID", "會員帳號不能空白");
			}			
			if(phone == null || phone.trim().length()==0){
				errorMsg.put("phone","手機號碼不能空白");
			}else if(phone.trim().length() != 10){
				errorMsg.put("phone","手機號碼長度錯誤");
			}		
			//如果輸入資料都正確,進行修改動作
			if (!errorMsg.isEmpty()) {
				RequestDispatcher rd = request.getRequestDispatcher("event/showAttendance.jsp");
				rd.forward(request, response);
				return;
			}
		
			Attendance a = new Attendance(aid, id, phone, eid, mail, pax);
			System.out.println(aid);
			count = as.updateAttendance(a);
			if(count==1){
				hsession.setAttribute("modify", "修改成功");
			}else{
				hsession.setAttribute("modify", "修改時發生異常");
			}
			String url = request.getContextPath()+"/queryAllAttendance.do";
			System.out.println(url);
			request.setAttribute("a", a);
			String newurl = response.encodeRedirectURL(url);
			response.sendRedirect(newurl);
		
			}
			
	}
}
