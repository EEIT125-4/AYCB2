package event.controller;


import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import event.model.Attendance;
import event.service.AttendanceService;
import event.service.AttendanceServiceImpl;


@WebServlet("/queryAllAttendance.do")
public class QueryAllAttendanceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AttendanceService as = new AttendanceServiceImpl();
		List <Attendance>list = as.getAllAttendance();
		for (Attendance attendance : list) {
			System.out.println(attendance.getMemberID());
		}
		//Collection<MemberBean> coll = ms.getAllMembers();
		//用List不用Collection,因為List是子代,功能比較多
		request.getSession(true).setAttribute("allAttendance", list);
		RequestDispatcher rd = request.getRequestDispatcher("event/showAttendance.jsp");
		rd.forward(request, response);
		return;		
	}

}
