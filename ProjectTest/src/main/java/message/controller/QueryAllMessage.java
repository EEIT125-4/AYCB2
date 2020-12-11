package message.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import message.model.MessageBean;
import message.service.MessageService;
import message.service.impl.MessageServiceImpl;

import javax.servlet.http.HttpServlet;

@WebServlet("/queryMessage.do")
public class QueryAllMessage extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("query all message");
		MessageService ms = new MessageServiceImpl();
		List<MessageBean> list = new ArrayList<MessageBean>();//訊息
		List<String> types=ms.queryMessageType();//訊息types
		
		String type = request.getParameter("type");
		String count=request.getParameter("count");
		String sort=request.getParameter("sort");
		String word=request.getParameter("word");
		if(type!=null || count!=null || sort!=null || word!=null) {
			String sql="";
			//如果有手動輸入的關鍵字,視為最優先
			if(word!=null && !word.equals("")) {
				
				sql=" select*from message_table where type like'%" + word + "%'" + " or content like'%" + word + "%'"
						+ " or title like '%" + word + "%'" + " or date like '%" + word + "%'";			
				
			}else {
				
				sql = "select " + count + " *from message_table where type like '%" +type + "%' order by id " + sort;
				
			}			
			System.out.println("sql:"+sql);			
			list=ms.queryMessage(sql);
			
		}else {
			list = ms.getAllMessages();			
		}
			
		request.setAttribute("allMessage", list);
		request.setAttribute("types", types);
		RequestDispatcher rd = request.getRequestDispatcher("message/msgPage2.jsp");
		rd.forward(request, response);

		return;

	}

}
