package service;

import java.util.List;

import bean.Comment;

public interface CommentService {
	public boolean addComment(String Concent,String updatetime,int blogger_id,int article_id);
	//添加评论，直接添加即可,调用ArticleService的评论加1方法
	public boolean deleteComent(int id);
	//从列出的所有评论中点击一条评论去删除，调用ArticleService的评论减1方法
	public List<Comment> findCommentByArticle(int article_id);
	//根据文章列出所有评论(CommentDao得额外增加一个根据文章id返回所有评论的方法)
}
