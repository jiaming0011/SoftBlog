package dao.impl;

import java.util.ArrayList;
import java.util.List;

import bean.BloggerType;
import bean.Comment;
import dao.CommentDao;

public class CommentDaoImpl extends BaseDaoImpl<Comment>implements CommentDao {

	@Override
	public List<Comment> findCommentByArticleId(int article_id) {
		List<Comment> list=new ArrayList<Comment>();
		String sql="select * from comment where article_id=?";
		List<Object> args=new ArrayList<Object>();
		args.add(article_id);
		String classname="bean.Comment";	
		list=dbu.select(sql, args, classname);
		return list;
	}


	

}
