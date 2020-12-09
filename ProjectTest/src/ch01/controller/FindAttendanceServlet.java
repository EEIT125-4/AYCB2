package ch01.controller;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Attendance;
import service.AttendanceService;
import service.AttendanceServiceImpl;


@WebServlet("/FindAttendance.do")
public class FindAttendanceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		Integer key = Integer.valueOf(request.getParameter("key"));//注意大小寫
		//int pk = Integer.parseInt(key);
		AttendanceService as = new AttendanceServiceImpl();
		Attendance a = as.getAttendance(key);
		request.getSession(true).setAttribute("a", a);
		RequestDispatcher rd = request.getRequestDispatcher("update.jsp");
		rd.forward(request, response);
		return;
	}
}
