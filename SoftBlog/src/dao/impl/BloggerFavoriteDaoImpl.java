package dao.impl;

import java.util.ArrayList;
import java.util.List;



import bean.BloggerFavorite;
import dao.BloggerFavoriteDao;

public class BloggerFavoriteDaoImpl extends BaseDaoImpl<BloggerFavorite> implements BloggerFavoriteDao {

	@Override
	public List<BloggerFavorite> findBloggerFavoriteById_1(int blogger_id1) {
		List<BloggerFavorite> list=new ArrayList<BloggerFavorite>();
		String sql="select * from bloggerfavorite where blogger_id1=?";
		List<Object> args=new ArrayList<Object>();
		args.add(blogger_id1);
		String classname="bean.BloggerFavorite";	
		list=dbu.select(sql, args, classname);
		return list;
	}


	@Override
	public List<BloggerFavorite> findBloggerFavoriteById_2(int blogger_id2) {
		List<BloggerFavorite> list=new ArrayList<BloggerFavorite>();
		String sql="select * from bloggerfavorite where blogger_id2=?";
		List<Object> args=new ArrayList<Object>();
		args.add(blogger_id2);
		String classname="bean.BloggerFavorite";	
		list=dbu.select(sql, args, classname);
		return list;
	}

	

}
