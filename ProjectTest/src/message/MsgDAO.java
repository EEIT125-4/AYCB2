package message;

import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import javax.sql.DataSource;

public class MsgDAO {

	private Connection conn = null;
	private DataSource ds = null;
	private InitialContext ctxt = null;
	private Statement st = null;

	public MsgDAO() {
		try {
			ctxt = new InitialContext();
			ds = (DataSource) ctxt.lookup("java:comp/env/jdbc/EmployeeDB");
			conn = ds.getConnection();
			st = conn.createStatement();
		} catch (NamingException e) {

			e.printStackTrace();
			System.err.println("NamingException");
		} catch (SQLException e) {

			e.printStackTrace();
			System.err.println("SQLException");
		}

	}

	public void closeConn() {
		try {
			this.conn.close();
		} catch (SQLException e) {

			e.printStackTrace();
			System.err.println("SQL error");
		}

	}



	/**
	 * 特別小心這裡的路徑,合併專案時要改到對應位置
	 * 
	 * @return
	 */
	private File createDir() {
		/*
		 * 建立目錄---以日期，一天一個資料夾 // File file = new File(p1, new //
		 * SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime()));
		 */

		String p1 = "C:/iii/Java/JavaWebWorkspace/ProjectTest/WebContent/upload";

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

	public String uploadImage(HttpServletRequest request) {
		try {
			Part part = request.getPart("file");
			if (part != null) {
				String filename = part.getSubmittedFileName();
				filename = createName(filename);
				File file = new File(createDir(), filename);

				part.write(file.getAbsolutePath());// 寫入真實路徑

				System.out.printf("成功寫入圖片,路徑:%s\n", file.getAbsoluteFile());
				
				String path = "./upload/" + filename;

				return path;

			} else {
				return null;

			}

		} catch (IOException | ServletException e) {

			e.printStackTrace();
			System.err.println("IOException,回傳空路徑");
			return null;
		}
	}

	public ResultSet getResultSet(String sql) {

		try {
			return st.executeQuery(sql);
		} catch (SQLException e) {

			e.printStackTrace();
			return null;
		}
	}

	public boolean deleteMsg(String id) {

		try {
			String sqlString = "delete from message where msg_id=" + id;

			Statement stmt = conn.createStatement();
			System.out.println(sqlString);
			int updatecount = stmt.executeUpdate(sqlString);
			stmt.close();
			if (updatecount >= 1) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			System.err.println("" + e);
			return false;
		}

	}

	public boolean insertMsg(MsgBean msgData) {
		try {
			String sqlString = "insert into message values('" + msgData.getMsg_id() + "','" + msgData.getMsg_title()
					+ "','" + msgData.getMsg_desc() + "','" + msgData.getMsg_type() + "','" + msgData.getMsg_date()
					+ "','" + "''" + "')";

			Statement stmt = conn.createStatement();
			System.out.println(sqlString);
			int updatecount = stmt.executeUpdate(sqlString);
			stmt.close();
			if (updatecount >= 1) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			System.err.println("" + e);
			return false;
		}
	}

	public boolean updateMsg(MsgBean msgData) {
		
		
		try {
			String sql = "update message set " + "msg_title='" + msgData.getMsg_title() + "'," + "msg_desc='"
					+ msgData.getMsg_desc() + "'," + "msg_type='" + msgData.getMsg_type() + "'," + "msg_date='"
					+ msgData.getMsg_date() + "'," + "msg_imgpath='" + msgData.getMsg_imgpath() + "'"
					+ " where msg_id='" + msgData.getMsg_id() + "'";

			System.out.println("check sql:" + sql);
			Statement st = conn.createStatement();
			int updatecount = st.executeUpdate(sql);
			st.close();
			if (updatecount >= 1) {
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	public boolean updateImgPath(MsgBean msgData) {

		try {
			String sql = "update message set msg_imgpath='" + msgData.getMsg_imgpath() + "'" + " where msg_id='"
					+ msgData.getMsg_id() + "'";
			System.out.println("check sql:" + sql);
			Statement st = conn.createStatement();
			int updatecount = st.executeUpdate(sql);
			st.close();
			if (updatecount >= 1) {
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}