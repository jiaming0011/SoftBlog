package dao;

import java.util.List;

import bean.Comment;

public interface CommentDao extends BaseDao<Comment> {
	
	public List<Comment> findCommentByArticleId(int article_id);

}
