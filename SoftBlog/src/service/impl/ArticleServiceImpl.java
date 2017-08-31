package service.impl;

import java.util.List;

import service.ArticleService;
import util.BaseDaoUtil;
import bean.Article;
import bean.ArticleContent;
import bean.ArticleStatus;
import dao.impl.ArticleContentDaoImpl;
import dao.impl.ArticleDaoImpl;
import dao.impl.ArticleStatusDaoImpl;
import dao.impl.BloggerDaoImpl;
import dao.impl.TagDaoImpl;

public class ArticleServiceImpl implements ArticleService {

	
	//写博客,先对ArticleContent，articlestatus进行操作，然后对表article进行操作
	@Override
	public boolean addArticle(String content, String title, int Blogger_id,
			int Tag_id, String updatetime) {
		
		if(content.equals(" ")||title.equals(" ")){
			return false;
		}
		
		ArticleContentDaoImpl acd = new ArticleContentDaoImpl();
		ArticleStatusDaoImpl asd = new ArticleStatusDaoImpl();
		
		ArticleContent ac = new ArticleContent();
		ArticleStatus as = new ArticleStatus();
		Article a = new Article();
		
		
		ac.setContent(content);
		as.setEnjoy(0);
		as.setReading(0);
		as.setReviews(0);
		
		if(acd.add(ac)&&asd.add(as)){
			BaseDaoUtil bdu = new BaseDaoUtil();
			ac.setId(bdu.getMaxId("articlecontent"));
			as.setId(bdu.getMaxId("articlestatus"));
			
			TagDaoImpl tdi = new TagDaoImpl();
			BloggerDaoImpl bdi = new BloggerDaoImpl();
			
			a.setTag_id(tdi.findById(Tag_id));
			a.setBlogger_id(bdi.findById(Blogger_id));
			a.setTitle(title);
			a.setArticlecontent_id(ac);
			a.setArticlestatus_id(as);
			a.setUpdatetime(updatetime);
			ArticleDaoImpl adi = new ArticleDaoImpl();
			if(adi.add(a)){
				return true;
			}
		}
		return false;
	}

	
	
	@Override
	public boolean updateArticle(int Article_id,String Updatetime,String Title,String content) {
		
		ArticleDaoImpl ad = new ArticleDaoImpl();
		ArticleContentDaoImpl acd = new ArticleContentDaoImpl();
		
		Article at = ad.findById(Article_id);
		ArticleContent ac = acd.findById(at.getArticlecontent_id().getId());
		
		ac.setContent(content);
		at.setTitle(Title);
		at.setUpdatetime(Updatetime);
		
		if(ad.update(at)&&acd.update(ac)){
			return true;
		}
		return false;
	}

	
	
	@Override
	public boolean deleteArticle(int id) {
		
		ArticleContentDaoImpl acd = new ArticleContentDaoImpl();
		ArticleStatusDaoImpl asd = new ArticleStatusDaoImpl();
		ArticleDaoImpl ad = new ArticleDaoImpl();
		
		Article at = ad.findById(id);
		
		int acid = at.getArticlecontent_id().getId();
		int asid = at.getArticlestatus_id().getId();
		
		if(ad.deleteById(id)){
			if(acd.deleteById(acid)&&asd.deleteById(asid)){
				return true;
			}
		}
		return false;
	}



	@Override
	public List<Article> findArticleByBlggerId(int Blogger_id) {
		//根据博客id查找其写过的所有文章(ArticleDao要额外添加一个方法)
		ArticleDaoImpl adi=new ArticleDaoImpl();
		List<Article> la=adi.findArticleByBloggerId(Blogger_id);
		return la;
	}

	@Override
	public boolean addReading(int id) {
		//阅读量加1，先根据文章id查找出ArticleStatus_id,然后根据ArticleStatus_id得到reading加1后再更新回去（或者另外写sql语句？）
		ArticleStatusDaoImpl asdi=new ArticleStatusDaoImpl();
		ArticleDaoImpl ad = new ArticleDaoImpl();
		Article at = ad.findById(id);
		ArticleStatus as=at.getArticlestatus_id();
		int nre=asdi.findById(as.getId()).getReading() + 1;
		as.setReading(nre);
		if(asdi.update(as)){
			return true;
		}
		return false;
	}

	@Override
	public boolean addEnjoy(int id) {
		//点赞数加1
		ArticleStatusDaoImpl asdi=new ArticleStatusDaoImpl();
		ArticleDaoImpl ad = new ArticleDaoImpl();
		Article at = ad.findById(id);
		ArticleStatus as=at.getArticlestatus_id();
		int nre=asdi.findById(as.getId()).getEnjoy() + 1;
		as.setEnjoy(nre);
		if(asdi.update(as)){
			return true;
		}
		return false;
	}

	@Override
	public boolean addReview(int id) 
	//评论数加1
	{
		ArticleStatusDaoImpl asdi=new ArticleStatusDaoImpl();
		ArticleDaoImpl ad = new ArticleDaoImpl();
		Article at = ad.findById(id);
		ArticleStatus as=at.getArticlestatus_id();
		int nre=asdi.findById(as.getId()).getReviews() + 1;
		as.setReviews(nre);
		if(asdi.update(as)){
			return true;
		}
		return false;
	}

	@Override
	public boolean delReview(int id) {
		ArticleStatusDaoImpl asdi=new ArticleStatusDaoImpl();
		ArticleDaoImpl ad = new ArticleDaoImpl();
		Article at = ad.findById(id);
		ArticleStatus as=at.getArticlestatus_id();
		int nre=asdi.findById(as.getId()).getReviews() - 1;
		as.setReviews(nre);
		if(asdi.update(as)){
			return true;
		}
		return false;
	}

}
