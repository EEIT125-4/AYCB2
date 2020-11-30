package message;

import java.io.*;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import tool.Common;

public class MsgBean implements Serializable {
	String msg_id,msg_title,msg_desc,msg_type,msg_imgpath;
	Date msg_date;
	
	
	//javaBean規定要放的空建構式
	public MsgBean() {
	}
	
	public MsgBean(ResultSet rs) {
		
		try {
			this.msg_id=rs.getString("msg_id");
			this.msg_title=rs.getString("msg_title");
			this.msg_desc=rs.getString("msg_desc");
			this.msg_type=rs.getString("msg_type");
			this.msg_date=rs.getDate("msg_date");
			this.msg_imgpath=rs.getString("msg_imgpath");
		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("rs取得msg錯誤");
			e.printStackTrace();
		}
		
	}
	
	public MsgBean(String msg_id, String msg_title, String msg_desc, String msg_type, Date msg_date) {
		super();
		this.msg_id = msg_id;
		this.msg_title = msg_title;
		this.msg_desc = msg_desc;
		this.msg_type = msg_type;
		this.msg_date = msg_date;
		
	}
	
	public MsgBean(String msg_id, String msg_title, String msg_desc, String msg_type,HttpServletRequest request) throws IOException, ServletException {
		
		this.msg_id = msg_id;
		this.msg_title = msg_title;
		this.msg_desc = msg_desc;
		this.msg_type = msg_type;
		
		this.msg_date =new Date(new java.util.Date().getTime());
		
		if(request.getPart("file")!=null) {//如果有夾帶檔案
			
			
			this.msg_imgpath=saveImg(request);
		}

	}
	
	private File createDir() {
		
		String p1 = "C:/iii/Java/JavaWebWorkspace/ProjectTest/WebContent/upload";
		// 建立目錄---以日期，一天一個資料夾
		// File file = new File(p1, new
		// SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime()));
		File file = new File(p1);
		if (!file.exists()) {
			file.mkdirs();
		}
		return file;
	}

	private String createName(String name) {
		// 建立檔名--區分同名檔案,在檔名前加上當前的時間
		return new SimpleDateFormat("yyyyMMddHHmmssSSS").format(Calendar.getInstance().getTime()) + "_" + name;
	}
	
	public String saveImg(HttpServletRequest request ) throws IOException, ServletException {
		
			
	
		Part part = request.getPart("file");
		String filename = part.getSubmittedFileName();
		// 建立要儲存的檔案物件
		filename = createName(filename);
		File file = new File(createDir(), filename);

		// 儲存檔案
		part.write(file.getAbsolutePath());
		System.out.printf("成功寫入圖片,路徑:%s\n", file.getAbsoluteFile());
		return "./upload/" + filename;
		
		
		
	}
	
	

	public String getMsg_imgpath() {
		return msg_imgpath;
	}

	public void setMsg_imgpath(String msg_imgpath) {
		this.msg_imgpath = msg_imgpath;
	}

	public String getMsg_id() {
		return msg_id;
	}


	public void setMsg_id(String msg_id) {
		this.msg_id = msg_id;
	}


	public String getMsg_title() {
		return msg_title;
	}


	public void setMsg_title(String msg_title) {
		this.msg_title = msg_title;
	}


	public String getMsg_desc() {
		return msg_desc;
	}


	public void setMsg_desc(String msg_desc) {
		this.msg_desc = msg_desc;
	}


	public String getMsg_type() {
		return msg_type;
	}


	public void setMsg_type(String msg_type) {
		this.msg_type = msg_type;
	}


	public Date getMsg_date() {
		return msg_date;
	}


	public void setMsg_date(Date msg_date) {
		this.msg_date = msg_date;
	}
	
	public void setMsg_date() {
		//將javaDate透過long值轉為sqlDate,
		this.msg_date =new Date(new java.util.Date().getTime());
	}


	
	
	

}