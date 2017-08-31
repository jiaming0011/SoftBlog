package service.impl;

import java.util.List;
import java.util.Scanner;

import bean.BloggerInfo;
import bean.Comment;
import dao.impl.ArticleDaoImpl;
import dao.impl.BloggerDaoImpl;
import dao.impl.BloggerInfoDaoImpl;
import dao.impl.CommentDaoImpl;
import service.CommentService;
import util.BaseDaoUtil;

public class CommentServiceImpl implements CommentService {
	CommentDaoImpl ci=new CommentDaoImpl();
	BloggerInfoDaoImpl bi=new BloggerInfoDaoImpl();
	BaseDaoUtil bs=new BaseDaoUtil();
	
	Scanner in=new Scanner(System.in);
	
	@Override
	public boolean addComment(String Concent, String updatetime, int blogger_id, int article_id) {
		boolean isFlag=false;
//		BloggerInfo b=bi.findById(article_id);
		Comment co=new Comment();
		co.setContent(Concent);
		co.setUpdatetime(updatetime);
		BloggerDaoImpl bl=new BloggerDaoImpl();
		ArticleDaoImpl al=new ArticleDaoImpl();		
		co.setBlogger_id(bl.findById(blogger_id));
		co.setArticle_id(al.findById(article_id));
		isFlag=ci.add(co);
//		if(isFlag)
//		{
//			addreviews；
//		}
		return isFlag;
		
	}

	@Override
	public boolean deleteComent(int id) {
		boolean isFlag=false;
		isFlag=ci.deleteById(id);
//		ArticleServiceImpl al=new ArticleServiceImpl();
		return isFlag;
	}
	

	@Override
	public List<Comment> findCommentByArticle(int article_id) {
		BloggerInfo b =bi.findById(article_id);
		List<Comment> list=null;
		if(b!=null)
		{
			list=ci.findAll();
		}
		return list;
	}

}
