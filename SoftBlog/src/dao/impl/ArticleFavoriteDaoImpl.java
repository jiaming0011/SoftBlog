package dao.impl;

import java.util.ArrayList;
import java.util.List;

import bean.ArticleFavorite;
import dao.ArticleFavoriteDao;

public class ArticleFavoriteDaoImpl extends BaseDaoImpl<ArticleFavorite> implements ArticleFavoriteDao {

	@Override
	public List<ArticleFavorite> findArticleFavoriteByBloggerId(int blogger_id) {
		List<ArticleFavorite> list=new ArrayList<ArticleFavorite>();
		String sql="select * from articlefavorite where blogger_id=?";
		List<Object> args=new ArrayList<Object>();
		args.add(blogger_id);
		String classname="bean.ArticleFavorite";	
		list=dbu.select(sql, args, classname);
		return list;
	}

	

}
