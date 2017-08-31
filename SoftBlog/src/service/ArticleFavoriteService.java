package service;

import java.util.List;

import bean.Article;
import bean.ArticleFavorite;


public interface ArticleFavoriteService {
	
	public boolean addArticleFavorite(int blogger_id,int article_id);
	//收藏文章
	
	public List<Article> findArticleByBlogger(int blogger_id);
	//根据博主查询其收藏的所有文章(ArticleFavoriteDao新增加一个方法),并且在内部要根据
	//List<ArticleFavorite>找出对应的List<Article>
	
	public boolean deleteArticle(int Article_id,int blogger_id );
	//先根据blogger_id找出所有ArticleFavorite，然后在ArticleFavorite中找到
	//Article_id的id，然后删除
	
	public List<Article> SearcheArticleInArticleFavorite(int blogger_id,String title);
	//先根据blogger_id找出所有ArticleFavorite,然后根据用户输入的文章题目搜索文章，存在该文章，则返回该文章
	
	public List<Article> FindArticleByBloggerAndArticle_id(int blogger_id,int article_id);
	//根据blogger_id,article_id找到特定的文章
	
	public ArticleFavorite FindArticleFavoriteById(int blogger_id,int articleFavorite_id);
	//先根据blogger_id找出所有ArticleFavorite,然后根据articleFavorite_id找到特定的收藏文章

}
