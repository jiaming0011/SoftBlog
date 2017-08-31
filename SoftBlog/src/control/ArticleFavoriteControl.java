package control;

import java.util.List;

import bean.Article;

public interface ArticleFavoriteControl {
	
	public int JudgeArticleInArticleFavorite(int blogger_id);
	//根据博主id，判断博主收藏夹中是否存在文章，没有则返回0，有则返回1
	
	public int JudgeArticleInSearching(int blogger_id,String title);
	//先根据博客ID找到博客，后根据输入的title，判断文章是否存在，没有返回0，有则返回1
	
	public int JudgeArticleStatus(int blogger_id,int article_id);
	//先根据博客ID找到博客，后根据article_id判断该文章是否在ArticleFavorite中，判断文章是否已经被收藏（即不得二次收藏）
	//已经被收藏返回1，没有则返回0
	
	public int CancelArticleFavorite(int blogger_id,int article_id);
	//先根据博客ID找到博客，后根据article_id取消文章收藏（即将该文章从ArticleFavorite中删除）
	//已经删除返回1，没有返回0
	
	public int AddArticleFavorite(int blogger_id,int article_id);
	//先根据博客ID找到博客，后根据article_id将该文章收藏
	//收藏成功返回1，收藏失败返回0
	
	
	
}
