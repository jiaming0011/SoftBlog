package dao;

import java.util.List;

import bean.Article;


public interface ArticleDao extends BaseDao<Article>{
	public List<Article> findArticleByBloggerId(int blogger_id);
	public List<Article> findArticleByIndex(int startIndex, int pageCount);
	//startIndex表示起始行，每页表示要返回的行数
	public int findAllCount();
	//返回总记录数
	public List<Article> findPageByBloggerId(int id,int startIndex, int pageCount);
	
	public int findCountByBlogger_id(int id);
	
}
