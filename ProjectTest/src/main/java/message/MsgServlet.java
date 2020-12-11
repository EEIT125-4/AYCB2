package message;

import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

//import javax.rmi.*;
import javax.naming.*;
import javax.sql.*;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import tool.Common;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import message.model.MessageBean;
import message.service.MessageService;
import message.service.impl.MessageServiceImpl;
import tool.Common;

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
			// 刪除
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
			
			MessageService ms=new MessageServiceImpl();	
			if (ms.deleteMessage(msg_id)==1) {
				System.out.println("刪除成功");

			} else {
				System.out.println("刪除失敗");
			}

		} finally {
			try {
				String editUrl = request.getContextPath() + "/queryMessage.do";///queryMessage.do
				String targetURL = "";
				targetURL = response.encodeRedirectURL(editUrl);
				response.sendRedirect(targetURL);
			} catch (IOException e) {

				e.printStackTrace();
				System.out.println("delete結束,導向失敗");
			}
		}

	}

	public void gotoUpdateProcess(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		System.out.println("in update process");

		String msg_id = request.getParameter("id");
		String msg_title = request.getParameter("title").trim();
		String msg_content = request.getParameter("desc").trim();
		String msg_type = request.getParameter("type").trim();
		String msg_path = request.getParameter("path");

		Part part = request.getPart("file");

		MessageService ms =new MessageServiceImpl();
		boolean success = false;

		try {

			// 如果存在檔案,表示圖片有更新,嘗試把舊圖片刪除
			if (part != null && part.getSize()>0) {

				File oldFile = new File(Common.getImgRealPath(msg_path));
				if (oldFile.exists()) {
					System.out.println("存在舊檔案,路徑為:" + oldFile.getAbsolutePath());
					if (Common.deleteFile(Common.getImgRealPath(msg_path))) {

						System.out.println("delete file:" + msg_path);
						System.out.println("刪除舊圖檔成功");
					} else {
						System.out.println("fail to delete file:" + msg_path);
						System.out.println("刪除舊圖檔失敗");
					}

					msg_path = Common.saveImage(part);
				}

				// 圖片實際路徑轉換

			} else {
				System.out.println("沒有舊檔案");
			}
			MessageBean mb = ms.getMessage(msg_id);
			mb.setMsg_title(msg_title);
			mb.setMsg_desc(msg_content);
			mb.setMsg_type(msg_type);
			mb.setMsg_imgpath(msg_path);
			mb.setEditDate(new java.sql.Date(new Date().getTime()));

			if (ms.updateMessage(mb) == 1) {
				success = true;
			}

		} catch (Exception e) {
			e.printStackTrace();

		}
		String targetURL = "";

		String url = request.getContextPath() + "/message/msgPage2.jsp";
		url = response.encodeRedirectURL(url);
		response.sendRedirect(url);
		if (success) {

		} else {

		}

	}

	public void gotoEditProcess(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		// 邏輯是根據id名稱設定session bean,然後帶去NewMsg.jsp頁面,如果有bean執行A,否執行B
		String id = request.getParameter("msg_id");

		MessageService ms = new MessageServiceImpl();
		boolean success = false;
		String editUrl = request.getContextPath() + "/message/newMsg.jsp";
		String url = request.getContextPath() + "/queryMessage.do";

		if (ms.isDup(id)) {// 如果查詢的物件存在
			try {
				MessageBean mb = ms.getMessage(id);
				request.setAttribute("edit_msg", mb);
				request.getRequestDispatcher("/message/newMsg.jsp").forward(request, response);
				success = true;

			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("error when create bean");

			}
			String targetURL = "";

			if (success) {
				targetURL = response.encodeRedirectURL(editUrl);
				response.sendRedirect(targetURL);

			} else {
				RequestDispatcher rd = request.getRequestDispatcher(url);
				rd.forward(request, response);

			}

		} else {

			System.out.println("不存在");
		}
	}

	public void gotoSubmitProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 原則上送出不檢查直接加入資料庫
		// 最好能自動取號,取得rs 日期與現在同一天的筆數
		// 若rs=null,創建日期流水編第一筆
		// 若rs!=null,編號為日期+(目前筆數+1)
		System.out.println("in subit process");

		try {

			// 取得submit過來的資料
			String msg_title = request.getParameter("title").trim();
			String msg_desc = request.getParameter("desc").trim();
			System.out.println("textArea:" + msg_desc);
			String msg_type = request.getParameter("type").trim();
			String msg_imgPath = "";
			// 以JAVADATE取得今天日期的long,再轉為SQLDATE
			java.sql.Date msg_date = new java.sql.Date(new Date().getTime());
			Part part = request.getPart("file");
			if (part != null &&part.getSize()>0) {// 如果有傳檔案過來
				msg_imgPath = Common.saveImage(part);
			}else {
				System.out.println("沒有圖片");
			}

			MessageBean mb = new MessageBean(msg_title, msg_desc, msg_type, msg_imgPath, msg_date);
			
			MessageService ms = new MessageServiceImpl();
			ms.save(mb);

		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("上傳過程發生異常");
			String url = request.getContextPath() + "/queryMessage.do";
			String targetURL = response.encodeRedirectURL(url);
			response.sendRedirect(targetURL);
			
			return;

		}
		System.out.println("前往msgpage");
		String url = request.getContextPath() + "/queryMessage.do";
		String targetURL = response.encodeRedirectURL(url);
		response.sendRedirect(targetURL);

	}


}
