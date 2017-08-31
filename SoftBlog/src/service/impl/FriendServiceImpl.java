package service.impl;

import java.util.ArrayList;
import java.util.List;

import bean.BlackList;
import bean.Blogger;
import bean.BloggerFavorite;
import dao.impl.BlackListDaoImpl;
import dao.impl.BloggerDaoImpl;
import dao.impl.BloggerFavoriteDaoImpl;
import service.FriendService;

public class FriendServiceImpl implements FriendService {
	
	BloggerDaoImpl bdi=new BloggerDaoImpl();
	BloggerFavoriteDaoImpl bfdi=new BloggerFavoriteDaoImpl();
	BlackListDaoImpl bldi=new BlackListDaoImpl();

	@Override
	public boolean addFocus(int blogger_id1, int blogger_id2) {
		boolean isFlag=false;
		BloggerFavorite bf=new BloggerFavorite();
		bf.setBlogger_id1(bdi.findById(blogger_id1));
		bf.setBlogger_id2(bdi.findById(blogger_id2));
		isFlag=bfdi.add(bf);
		return isFlag;
	}

	@Override
	public List<Blogger> findFocusByBlogger_id1(int Blogger_id) {
		List<BloggerFavorite> lbf=new ArrayList<BloggerFavorite>();
		List<Blogger> lb=new ArrayList<Blogger>();
		lbf=bfdi.findBloggerFavoriteById_1(Blogger_id);
		for(BloggerFavorite b:lbf)
		{
			lb.add(b.getBlogger_id2());
		}
		return lb;
	}

	@Override
	public List<Blogger> findFansByBlogger_id2(int Blogger_id) {
		List<BloggerFavorite> lbf=new ArrayList<BloggerFavorite>();
		List<Blogger> lb=new ArrayList<Blogger>();
		lbf=bfdi.findBloggerFavoriteById_2(Blogger_id);
		for(BloggerFavorite b:lbf)
		{
			lb.add(b.getBlogger_id1());
		}
		return lb;
	}

	@Override
	public boolean addToBlackList(int blogger_id1, int blogger_id2) {
		boolean isFlag=false;
		BlackList bl=new BlackList();
		bl.setBlogger_id1(bdi.findById(blogger_id1));
		bl.setBlogger_id2(bdi.findById(blogger_id2));
		isFlag=bldi.add(bl);
		return isFlag;
	}

	@Override
	public List<Blogger> findBlackList(int blogger_id1) {
		List<BlackList> lbl=new ArrayList<BlackList>();
		List<Blogger> lb=new ArrayList<Blogger>();
		lbl=bldi.findBlackListByBloggerId(blogger_id1);
		for(BlackList b: lbl)
		{
			lb.add(b.getBlogger_id2());
		}
		return lb;
	}

	@Override
	public boolean delFocus(int blogger_id1, int blogger_id2) {
		boolean isFlag=false;
		List<BloggerFavorite> lbf=new ArrayList<BloggerFavorite>();
		lbf=bfdi.findBloggerFavoriteById_1(blogger_id1);
		for(BloggerFavorite b:lbf)
		{
			if(b.getBlogger_id2().getId()==blogger_id2)
			{
				isFlag=bfdi.deleteById(b.getId());
				break;
			}
		}
		return isFlag;
	}

	@Override
	public boolean delBlackList(int blogger_id1, int blogger_id2) {
		boolean isFlag=false;
		List<BlackList> lb=new ArrayList<BlackList>();
		lb=bldi.findBlackListByBloggerId(blogger_id1);
		for(BlackList b:lb)
		{
			if(b.getBlogger_id2().getId()==blogger_id2)
			{
				isFlag=bldi.deleteById(b.getId());
				break;
			}
		}
		return isFlag;
	}


}
