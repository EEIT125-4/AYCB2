package message;

import javax.servlet.*;
//import javax.servlet.http.*;
//import java.io.PrintWriter;
//import java.io.IOException;

import java.io.*;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;


//import javax.rmi.*;
import javax.naming.*;
import javax.sql.*;



import message.MsgBean;
import tool.Common;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/MsgServlet")
@MultipartConfig

public class MsgServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String CONTENT_TYPE = "text/html; charset=UTF-8";
	private static final String CHARSET_CODE = "UTF-8";

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}

	public MsgServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding(CHARSET_CODE);
		response.setContentType(CONTENT_TYPE);
		System.out.println("do post msgservlet");
		// To prevent caching
		response.setHeader("Cache-Control", "no-cache"); // HTTP 1.1
		response.setHeader("Pragma", "no-cache"); // HTTP 1.0
		response.setDateHeader("Expires", -1); // Prevents caching at the proxy server

		String submit = request.getParameter("submit");
		System.out.println(submit);
		if (submit != null && !submit.equals("")) {
			// 蝺刻摩
			if (submit.equals("edit")) {
				System.out.println("goto edit");
				gotoEditProcess(request, response);
			}
			// ��
			if (submit.equals("delete")) {
				System.out.println("goto delete");
				gotoDeleteProcess(request, response);

			}
			// �
			if (submit.equals("�")) {
				System.out.println("go to  subit process");
				gotoSubmitProcess(request, response);
			}
			// ��
			if (submit.equals("��")) {
				System.out.println("goto update");
				gotoUpdateProcess(request, response);
			}

		} else {
			System.out.println("where's ur submit?");
		}

	}

	public void getMsgParam() {

	}

	public void gotoDeleteProcess(HttpServletRequest request, HttpServletResponse response) {

		System.out.println("in delete process");
		String msg_id = request.getParameter("msg_id");
		try {
			MsgDAO dao = new MsgDAO();

			if (dao.deleteMsg(msg_id)) {
				System.out.println("������");

			} else {
				System.out.println("��憭望��");
			}

		} finally {
			try {
				response.sendRedirect("./MsgPage.jsp");
			} catch (IOException e) {

				e.printStackTrace();
				System.out.println("delete蝯��,撠�仃���");
			}
		}

	}

	public void gotoUpdateProcess(HttpServletRequest request, HttpServletResponse response) {

		System.out.println("in update process");

		String msg_id = request.getParameter("id");
		String msg_title = request.getParameter("title").trim();
		String msg_desc = request.getParameter("desc").trim();
		String msg_type = request.getParameter("type").trim();
		String msg_path = request.getParameter("path");

		try {

			MsgDAO msgDAO = new MsgDAO();
			if (request.getPart("file") != null)

			{
				// 瘜冽��,�ㄐ�撠����楝敺�..
				if (msg_path != null && !msg_path.equals("")) {
					System.out.println("msg_path:" + msg_path);
					String path = msg_path.substring(msg_path.lastIndexOf("/"));
					path = "C:\\Users\\user\\eclipse-workspace\\AYCB\\WebContent\\myProject\\upload" + path;
					System.out.println("��摮瑼��?" + new File(path).exists());

					if (Common.deleteFile(path)) {

						System.out.println("delete file:" + path);
					} else {
						System.out.println("fail to delete file:" + path);
					}
				}
			}
			// 甇文遣瑽���request銝������,���店������蒂閮剔蔭�瑼�楝敺bean銝�
			MsgBean updateData = new MsgBean(msg_id, msg_title, msg_desc, msg_type, request);

			if (msgDAO.updateMsg(updateData)) {
				System.out.println("������");
				response.sendRedirect("./MsgPage.jsp");

			} else {
				System.err.println("��憭望��");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("sth error");
		}

		// �������

		/*
		 * String path = msgData.getMsg_imgpath(); if (path != null || !path.equals(""))
		 * {
		 * 
		 * if (deleteFile(path)) { System.out.println("���������"); } else {
		 * System.out.println("�����仃���"); } ;
		 * 
		 * }
		 */

	}

	public void gotoEditProcess(HttpServletRequest request, HttpServletResponse response) {

		// ��摩����d��迂閮剖�ession bean,�敺葆�NewMsg.jsp��,憒��ean�銵,��銵

		try {
			MsgDAO dao = new MsgDAO();

			String sql = ("select *from message where msg_id=") + "'" + request.getParameter("msg_id") + "'";
			System.out.println(sql);
			ResultSet rs = dao.getResultSet(sql);

			MsgBean msgBean = null;
			while (rs.next()) {
				// �����ean
				msgBean = new MsgBean(rs);

			}
			System.out.println("path" + msgBean.getMsg_imgpath());
			// 閮剖�迤閬楊頛舐�ean
			// request.getSession(true).setAttribute("edit_msg",msgBean);
			request.setAttribute("edit_msg", msgBean);
			request.getRequestDispatcher("/NewMsg.jsp").forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("error when create bean");
			try {
				response.sendError(400, "error when create bean");
			} catch (IOException e1) {
				e1.printStackTrace();
			}

		}

	}

	public void gotoSubmitProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// �����銝炎�����鞈�澈
		// ��憟質������,���s ��������憭拍��
		// �rs=null,�撱箸���偌蝺函洵銝�蝑�
		// �rs!=null,蝺刻�����+(����+1)

		System.out.println("in subit process");
		// ���ubmit�������
		String msg_title = request.getParameter("title").trim();
		String msg_desc = request.getParameter("desc").trim();
		System.out.println("textArea:" + msg_desc);
		String msg_type = request.getParameter("type").trim();
		// 隞仔AVADATE����予����ong,���SQLDATE
		java.sql.Date msg_date = new java.sql.Date(new Date().getTime());
		MsgBean msgBean = new MsgBean("", msg_title, msg_desc, msg_type, msg_date);

		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
		String sqlCondition = f.format(msgBean.getMsg_date());
		System.out.println(sqlCondition);

		try {
			MsgDAO dao = new MsgDAO();
			// ����偌��D
			String sql = ("select *from message where msg_date=") + "'" + sqlCondition + "'" + "order by msg_id";
			System.out.println(sql);
			ResultSet rs = dao.getResultSet(sql);
			String ID = "";
			int count = 1;
			while (rs.next()) {
				count++;
				ID = rs.getString("msg_id");

				System.out.println("count=" + count + ":" + ID);

			}
			int lastIndex;
			if (count == 1) {
				lastIndex = 1;
			} else {
				lastIndex = Integer.parseInt(ID.substring(ID.length() - 3)) + 1;
			}

			// System.out.printf("count=%d,lastIndex=%d\n", count, lastIndex);

			String tempID = sqlCondition.replaceAll("-", "") + String.format("%03d", lastIndex);
			// System.out.println("tempId=" + tempID);

			msgBean.setMsg_id(tempID);

			// �敺���挾�脰��,�閬��迤蝣箏停��nsert�脰��澈,敺��岫������,�雿踹�������憓�蝑�
			if (dao.insertMsg(msgBean)) {
				// 憒��鞈�澈����,��岫�����撠��
				System.out.println("���nsert�脰��澈,撖怠���鞈�冗");
				String path = dao.uploadImage(request);

				if (path != null && !path.equals("")) {
					// ����������楝敺�,憒���停��鞈�澈���楝敺�
					msgBean.setMsg_imgpath(path);
					dao.updateImgPath(msgBean);
				} else {
					System.err.println("瘝������");
				}

			}
			dao.closeConn();

		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("銝�����撣�");

		} finally {
			response.sendRedirect("./MsgPage.jsp");

		}

		// 憭���銋����
		/*
		 * Collection<Part> list = request.getParts(); for (Part p : list) {
		 * 
		 * // ��������迂
		 * 
		 * String filename = p.getSubmittedFileName(); // 撱箇��摮���隞� File file = new
		 * File(createDir(getServletContext()), createName(filename));
		 * 
		 * // �摮��� p.write(file.getAbsolutePath());
		 * System.out.printf("���神�����,蝯�楝敺�:%s\n",file.getAbsoluteFile());
		 * 
		 * 
		 * }
		 */

		// request.getRequestDispatcher("/NewMsg.jsp").forward(request, response);
		// 撠�������

		// getServletContext().getRequestDispatcher("/MsgPage.jsp").forward(request,
		// response);

	}

}
