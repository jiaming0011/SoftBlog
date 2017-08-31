package control.impl;

import java.util.List;

import bean.Article;
import bean.ArticleFavorite;

import service.impl.ArticleFavoriteServiceImpl;
import control.ArticleFavoriteControl;

public class ArticleFavoriteControlImpl implements ArticleFavoriteControl {

	@Override
	public int JudgeArticleInArticleFavorite(int blogger_id) {
		ArticleFavoriteServiceImpl afsi=new ArticleFavoriteServiceImpl();
		List<Article> af=afsi.findArticleByBlogger(blogger_id);
		if(af.isEmpty())
		{
			return 0;
		}
		return 1;
	}

	@Override
	public int JudgeArticleInSearching(int blogger_id, String title) {
		ArticleFavoriteServiceImpl afsi=new ArticleFavoriteServiceImpl();
		List<Article> af=afsi.SearcheArticleInArticleFavorite(blogger_id, title);
		if(af.isEmpty())
		{
			return 0;
		}
		return 1;
	}

	@Override
	public int JudgeArticleStatus(int blogger_id,int article_id) {
		ArticleFavoriteServiceImpl afsi=new ArticleFavoriteServiceImpl();
		List<Article> af=afsi.FindArticleByBloggerAndArticle_id(blogger_id, article_id);
		if(af.isEmpty())
		{
			return 0;
		}
		return 1;
	}

	@Override
	public int CancelArticleFavorite(int blogger_id, int article_id) {
		ArticleFavoriteServiceImpl afsi=new ArticleFavoriteServiceImpl();
		ArticleFavorite af=afsi.FindArticleFavoriteById(blogger_id, article_id);
		boolean t=afsi.deleteArticle(article_id, blogger_id);
		if(t)
		{
			return 1;
		}
		return 0;
	}

	@Override
	public int AddArticleFavorite(int blogger_id, int article_id) {
		ArticleFavoriteServiceImpl afsi=new ArticleFavoriteServiceImpl();
		boolean t=afsi.addArticleFavorite(blogger_id, article_id);
		if(t)
		{
			return 1;
		}
		return 0;
	}



}
