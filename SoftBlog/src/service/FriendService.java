package service;

import java.util.List;

import bean.Blogger;

public interface FriendService {
	public boolean addFocus(int blogger_id1,int blogger_id2);
	//关注
	public List<Blogger> findFocusByBlogger_id1(int Blogger_id);
	//查看自己关注的(BloggerFavoriteDao要增加一个方法根据Blogger_id1返回
	//List<BloggerFavorite>)然后再根据BloggerFavorite里的Blogger_id2
	//返回List<Blogger>即关注
	public List<Blogger> findFansByBlogger_id2(int Blogger_id);
	//查看自己的粉丝(BloggerFavoriteDao要增加一个方法根据Blogger_id2返回
	//List<BloggerFavorite>)然后再根据BloggerFavorite里的Blogger_id1
	//返回List<Blogger>即粉丝
	public boolean addToBlackList(int blogger_id1,int blogger_id2);
	//如是好友 ???是否删粉丝??? 将好友拉进黑名单，先在黑名单表中进行增加操作，然后删除好友，即BloggerFavorite的delete
	//方法

	public List<Blogger> findBlackList(int blogger_id1);
	//查看自己的黑名单（需在BlackListDao增加一个根据Blogger_id1返回List<BlackList>）
	//然后再去查出List<Blogger>
	
	public boolean delFocus(int blogger_id1,int blogger_id2);
	//取消关注
	public boolean delBlackList(int blogger_id1,int blogger_id2);
	//解除黑名单
}
