package comment.service;

import java.util.List;

import comment.model.CommentBean;

public interface CommentService {

	// DiscussionBean變數名稱
	int insertComment(CommentBean commentData);

	List<CommentBean> selectAll();

	int deleteComment(int id);

	int updateComment(CommentBean cb);

	CommentBean selectUpdateitem(Integer commentId);

}