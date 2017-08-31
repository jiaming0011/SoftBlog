package service.impl;

import java.util.ArrayList;
import java.util.List;

import dao.impl.ArticleDaoImpl;
import dao.impl.ArticleFavoriteDaoImpl;
import dao.impl.BloggerDaoImpl;

import bean.Article;
import bean.ArticleFavorite;
import bean.Blogger;
import service.ArticleFavoriteService;
import util.BaseDaoUtil;

public class ArticleFavoriteServiceImpl implements ArticleFavoriteService {

	@Override
	public boolean addArticleFavorite(int blogger_id, int article_id) //收藏文章
	{
		ArticleFavoriteDaoImpl afdi=new ArticleFavoriteDaoImpl();
		BloggerDaoImpl bdi=new BloggerDaoImpl();
		ArticleDaoImpl adi=new ArticleDaoImpl();
		ArticleFavorite af=new ArticleFavorite();
		af.setBlogger_id(bdi.findById(blogger_id));
		af.setArticle_id(adi.findById(article_id));
		boolean t=afdi.add(af);
		return t;
	}

	@Override
	public List<Article> findArticleByBlogger(int blogger_id)
	//根据博主查询其收藏的所有文章(ArticleFavoriteDao新增加一个方法),并且在内部要根据
	//List<ArticleFavorite>找出对应的List<Article>
	{
		ArticleFavoriteDaoImpl afdi=new ArticleFavoriteDaoImpl();
		List<ArticleFavorite> laf=afdi.findArticleFavoriteByBloggerId(blogger_id);
		List<Article> la=new ArrayList<Article>();
		for(ArticleFavorite af:laf)
		{
			la.add(af.getArticle_id());
		}
		return la;
	}

	@Override
	public boolean deleteArticle(int Article_id, int blogger_id) 
	//先根据blogger_id找出所有ArticleFavorite，然后在ArticleFavorite中找到
	//Article_id的id，然后删除
	{
		ArticleFavoriteDaoImpl afdi=new ArticleFavoriteDaoImpl();
		List<ArticleFavorite> laf=afdi.findArticleFavoriteByBloggerId(blogger_id);
		boolean t=false;
		for(ArticleFavorite af:laf)
		{
			if(af.getArticle_id().getId()==Article_id)
			{
				t= afdi.deleteById(af.getId());
				break;
			}
		}
		return t;
	}

	@Override
	public List<Article> SearcheArticleInArticleFavorite(int blogger_id,String title) {
		ArticleFavoriteServiceImpl afsi=new ArticleFavoriteServiceImpl();
		List<Article> la=afsi.findArticleByBlogger(blogger_id);
		List<Article> la2=new ArrayList<Article>();
		for(Article a:la)
		{
			if(a.getTitle().equals(title))
			{
				la2.add(a);
			}
		}
		return la2;
	}

	@Override
	public List<Article> FindArticleByBloggerAndArticle_id(int blogger_id,int article_id) {
		ArticleFavoriteServiceImpl afsi=new ArticleFavoriteServiceImpl();
		List<Article> la=afsi.findArticleByBlogger(blogger_id);
		List<Article> la2=new ArrayList<Article>();
		for(Article a:la)
		{
			if(a.getId()==article_id)
			{
				la2.add(a);
			}
		}
		return la2;
	}

	@Override
	public ArticleFavorite FindArticleFavoriteById(int blogger_id,
			int articleFavorite_id) {
		ArticleFavoriteDaoImpl afdi=new ArticleFavoriteDaoImpl();
		List<ArticleFavorite> laf=afdi.findArticleFavoriteByBloggerId(blogger_id);
		ArticleFavorite af1=new ArticleFavorite();
		for(ArticleFavorite af2:laf)
		{
			if(af2.getId()==articleFavorite_id)
			{
				af1=af2;
				break;
			}
		}
		return af1;
	}



}
