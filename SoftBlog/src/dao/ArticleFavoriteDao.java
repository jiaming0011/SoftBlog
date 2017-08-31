package dao;

import java.util.List;

import bean.ArticleFavorite;

public interface ArticleFavoriteDao extends BaseDao<ArticleFavorite> {
	
	public List<ArticleFavorite> findArticleFavoriteByBloggerId(int blogger_id);

}
