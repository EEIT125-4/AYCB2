package comment.service;

import java.util.List;

import comment.model.CommentBean;

public interface CommentService {

	// DiscussionBean變數名稱
	int insertComment(CommentBean commentData);

	List<CommentBean> selectComment();

	int deleteComment(int id);

	CommentBean selectUpdateitem(int id);

	int updateComment(CommentBean cb);

}