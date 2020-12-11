package comment.dao;

import java.util.List;

import comment.model.CommentBean;

public interface CommentDao {

	//新增一筆留言
	int insertComment(CommentBean cb);

	//查詢所有留言
	List<CommentBean> selectAll();

	// 刪除一筆留言
	int deleteComment(int id);

	//選擇一筆需要更新的留言
	CommentBean selectUpdateitem(Integer id);


	//更新留言


	Integer updateComment(CommentBean cb);


}