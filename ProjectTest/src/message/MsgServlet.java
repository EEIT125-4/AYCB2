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

import javax.annotation.PostConstruct;
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
			// 編輯
			if (submit.equals("edit")) {
				System.out.println("goto edit");
				gotoEditProcess(request, response);
			}
			// 刪除
			if (submit.equals("delete")) {
				System.out.println("goto delete");
				gotoDeleteProcess(request, response);

			}
			// 送出
			if (submit.equals("送出")) {
				System.out.println("go to  subit process");
				gotoSubmitProcess(request, response);
			}
			// 更新
			if (submit.equals("更新")) {
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
				System.out.println("刪除成功");

			} else {
				System.out.println("刪除失敗");
			}

		} finally {
			try {
				response.sendRedirect("./MsgPage.jsp");
			} catch (IOException e) {

				e.printStackTrace();
				System.out.println("delete結束,導向失敗");
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
				// 注意,這裡是專案下絕對路徑..
				if (msg_path != null && !msg_path.equals("")) {
					System.out.println("msg_path:" + msg_path);
					String path = msg_path.substring(msg_path.lastIndexOf("/"));
					path = "C:\\Users\\user\\eclipse-workspace\\AYCB\\WebContent\\myProject\\upload" + path;
					System.out.println("是否存在檔案?" + new File(path).exists());

					if (Common.deleteFile(path)) {

						System.out.println("delete file:" + path);
					} else {
						System.out.println("fail to delete file:" + path);
					}
				}
			}
			// 此建構式會判斷request下有沒有檔案,有的話會刪除舊檔並設置新檔案路徑到bean中
			MsgBean updateData = new MsgBean(msg_id, msg_title, msg_desc, msg_type, request);

			if (msgDAO.updateMsg(updateData)) {
				System.out.println("更新成功");
				response.sendRedirect("./MsgPage.jsp");

			} else {
				System.err.println("更新失敗");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("sth error");
		}

		// 先把舊圖片刪除

		/*
		 * String path = msgData.getMsg_imgpath(); if (path != null || !path.equals(""))
		 * {
		 * 
		 * if (deleteFile(path)) { System.out.println("成功刪除舊檔案"); } else {
		 * System.out.println("刪除舊檔失敗"); } ;
		 * 
		 * }
		 */

	}

	public void gotoEditProcess(HttpServletRequest request, HttpServletResponse response) {

		// 邏輯是根據id名稱設定session bean,然後帶去NewMsg.jsp頁面,如果有bean執行A,否執行B

		try {
			MsgDAO dao = new MsgDAO();

			String sql = ("select *from message where msg_id=") + "'" + request.getParameter("msg_id") + "'";
			System.out.println(sql);
			ResultSet rs = dao.getResultSet(sql);

			MsgBean msgBean = null;
			while (rs.next()) {
				// 產生一個bean
				msgBean = new MsgBean(rs);

			}
			System.out.println("path" + msgBean.getMsg_imgpath());
			// 設定正要編輯的bean
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
		// 原則上送出不檢查直接加入資料庫
		// 最好能自動取號,取得rs 日期與現在同一天的筆數
		// 若rs=null,創建日期流水編第一筆
		// 若rs!=null,編號為日期+(目前筆數+1)

		System.out.println("in subit process");
		// 取得submit過來的資料
		String msg_title = request.getParameter("title").trim();
		String msg_desc = request.getParameter("desc").trim();
		System.out.println("textArea:" + msg_desc);
		String msg_type = request.getParameter("type").trim();
		// 以JAVADATE取得今天日期的long,再轉為SQLDATE
		java.sql.Date msg_date = new java.sql.Date(new Date().getTime());
		MsgBean msgBean = new MsgBean("", msg_title, msg_desc, msg_type, msg_date);

		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
		String sqlCondition = f.format(msgBean.getMsg_date());
		System.out.println(sqlCondition);

		try {
			MsgDAO dao = new MsgDAO();
			// 產生流水號ID
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

			// 考慮後還是分段進行,只要資料正確就先insert進資料庫,後再嘗試加入圖片,即使圖片有問題也先新增一筆訊息
			if (dao.insertMsg(msgBean)) {
				// 如果插入資料庫成功,嘗試加入圖片到專案
				System.out.println("成功insert進資料庫,寫入圖片到資料夾");
				String path = dao.uploadImage(request);

				if (path != null && !path.equals("")) {
					// 成功上傳圖片才會有路徑,如果成功就更新資料庫圖片路徑
					msgBean.setMsg_imgpath(path);
					dao.updateImgPath(msgBean);
				} else {
					System.err.println("沒有上傳圖片");
				}

			}
			dao.closeConn();

		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("上傳過程發生異常");

		} finally {
			response.sendRedirect("./MsgPage.jsp");

		}

		// 多檔案上傳之後再做
		/*
		 * Collection<Part> list = request.getParts(); for (Part p : list) {
		 * 
		 * // 獲取上傳的檔名稱
		 * 
		 * String filename = p.getSubmittedFileName(); // 建立要儲存的檔案物件 File file = new
		 * File(createDir(getServletContext()), createName(filename));
		 * 
		 * // 儲存檔案 p.write(file.getAbsolutePath());
		 * System.out.printf("成功寫入圖片,絕對路徑:%s\n",file.getAbsoluteFile());
		 * 
		 * 
		 * }
		 */

		// request.getRequestDispatcher("/NewMsg.jsp").forward(request, response);
		// 導引回留言列

		// getServletContext().getRequestDispatcher("/MsgPage.jsp").forward(request,
		// response);

	}

}
