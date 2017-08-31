package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.MySqlDBUtil;
import bean.Article;
import dao.ArticleDao;

public class ArticleDaoImpl extends BaseDaoImpl<Article> implements ArticleDao {

	MySqlDBUtil md=new MySqlDBUtil();
	@Override
	public List<Article> findArticleByBloggerId(int blogger_id) {
		List<Article> list=new ArrayList<Article>();
		String sql="select * from article where blogger_id=?";
		List<Object> args=new ArrayList<Object>();
		args.add(blogger_id);
		String classname="bean.Article";	
		list=dbu.select(sql, args, classname);
		return list;
	}

	@Override
	public List<Article> findArticleByIndex(int startIndex, int pageCount) {
		List<Article> list=new ArrayList<Article>();
		String sql="select * from article order by updatetime desc limit ?, ?";
		List<Object> args=new ArrayList<Object>();
		startIndex = startIndex-1;
		args.add(startIndex);
		args.add(pageCount);
		String classname="bean.Article";	
		list=dbu.select(sql, args, classname);
		return list;
	}

	@Override
	public int findAllCount() {
		Connection conn = md.getConnection();
		PreparedStatement prestm=null;
		ResultSet rs=null;
		String sql = "SELECT count(*) cnum FROM article";
		try {
			prestm = conn.prepareStatement(sql);
			rs = prestm.executeQuery();
			if(rs!=null){
				if(rs.next()){
					return rs.getInt("cnum");
				}
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return 0 ;
		
	}

	@Override
	public List<Article> findPageByBloggerId(int id, int startIndex,
			int pageCount) {
		List<Article> list=new ArrayList<Article>();
		String sql="select * from article where blogger_id=? order by updatetime desc limit ?, ?";
		List<Object> args=new ArrayList<Object>();
		startIndex = startIndex-1;
		args.add(id);
		args.add(startIndex);
		args.add(pageCount);
		String classname="bean.Article";	
		list=dbu.select(sql, args, classname);
		return list;
	}

	@Override
	public int findCountByBlogger_id(int id) {
		Connection conn = md.getConnection();
		PreparedStatement prestm=null;
		ResultSet rs=null;
		String sql = "SELECT count(*) cnum FROM article where blogger_id="+id;
		try {
			prestm = conn.prepareStatement(sql);
			rs = prestm.executeQuery();
			if(rs!=null){
				if(rs.next()){
					return rs.getInt("cnum");
				}
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return 0 ;
	}

	

}
