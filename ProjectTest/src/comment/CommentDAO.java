
package comment;

//專責與Comment Table之新增,修改,刪除與查詢

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CommentDAO {

	private Connection conn;

	// 建構子
	public CommentDAO(Connection conn) {
		this.conn = conn;
	}

	// DiscussionBean變數名稱
	public boolean insertComment(DiscussionBean commentData) {
		try {
			String sqlString = "insert into comment values('" + commentData.getName()
					+ "','" + commentData.getGender() + "','" + commentData.getAge() + "','" + commentData.getStatus()
					+ "','" + commentData.getCommentTime() + "','" + commentData.getContentBox() + "')";

			Statement stmt = conn.createStatement();
			System.out.println(sqlString);
			int updatecount = stmt.executeUpdate(sqlString);
			stmt.close();
			if (updatecount >= 1)
				return true;
			else
				return false;
		} catch (Exception e) {
			System.err.println("Error:" + e);
			return false;
		}
	}

	public ArrayList<DiscussionBean> selectComment(String data) {
		List<DiscussionBean> list = new ArrayList<DiscussionBean>();
		DiscussionBean discussion = new DiscussionBean();
		try (Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT * FROM comment WHERE name ='" + data + "'");) {
			while (rs.next()) {

				discussion.setName(rs.getString("name"));
				discussion.setGender(rs.getString("gender"));
				discussion.setAge(rs.getInt("age"));
				discussion.setStatus(rs.getInt("status"));
				discussion.setCommentTime(rs.getString("commentTime"));
				discussion.setContentBox(rs.getString("contentBox"));
				list.add(discussion);
			}
			System.out.println(1);
			return (ArrayList<DiscussionBean>) list;

		} catch (Exception e) {
			System.err.println("錯誤" + e);
		}
		return null;
	}

	// 刪除留言
	public boolean deleteComment(String name) {
		try {
//			String sqlString = "DELETE FROM comment WHERE name =' " + name+"'"
			Statement stmt = conn.createStatement();
			int deletecount = stmt.executeUpdate("DELETE FROM comment WHERE name ='" + name + "'");
			stmt.close();
			if (deletecount >= 1)
				return true;
			else
				return false;
		} catch (Exception e) {
			System.err.println("刪除留言時發生錯誤: " + e);
			return false;
		}
	}

	public DiscussionBean selectUpdateitem(String pno) {

		DiscussionBean order = new DiscussionBean();
		try (Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("select * from comment where id = '" + pno + "'");) {
			while (rs.next()) {
				order.setId(rs.getString("id"));
				System.out.println("order"+order.getId());
				order.setName(rs.getString("name"));
				order.setGender(rs.getString("gender"));
				order.setAge(rs.getInt("age"));
				order.setStatus(rs.getInt("status"));
				order.setCommentTime(rs.getString("commentTime"));
				order.setContentBox(rs.getString("contentBox"));

			}
			stmt.close();
			conn.close();
			System.out.println("DAO" + order.getId());
			return order;
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return null;

	}

	public boolean updateComment(DiscussionBean order) {

		try (PreparedStatement pstmt = conn.prepareStatement(
				"update comment set name=?, gender=?, age=?, status=?, commentTime=?, contentBox=? from comment where id = ?");) {
			System.out.println("innnnnnnnnnnnn");
			
			System.out.println(order);
			
			pstmt.setString(7, order.getId());
			pstmt.setString(1, order.getName());
			pstmt.setString(2, order.getGender());
			pstmt.setInt(3, order.getAge());
			pstmt.setInt(4, order.getStatus());
			pstmt.setString(5, order.getCommentTime());
			pstmt.setString(6, order.getContentBox());

			System.out.println("outtttttttttt");
			int updatecount = pstmt.executeUpdate();
			pstmt.clearParameters();
			System.out.println("update" + updatecount);
			if (updatecount >= 1)
				return true;
			else
				return false;

		} catch (SQLException e) {

			e.printStackTrace();
			return false;
		}

	}
}
