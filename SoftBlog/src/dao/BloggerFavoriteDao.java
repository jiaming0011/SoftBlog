package dao;

import java.util.List;

import bean.BloggerFavorite;

public interface BloggerFavoriteDao extends BaseDao<BloggerFavorite> {
	
	public List<BloggerFavorite> findBloggerFavoriteById_1(int blogger_id1);
	
	public List<BloggerFavorite> findBloggerFavoriteById_2(int blogger_id2);

}
