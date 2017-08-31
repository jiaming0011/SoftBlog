package dao;

import bean.BloggerInfo;


public interface BloggerInfoDao extends BaseDao<BloggerInfo> {
	public BloggerInfo findBloggerInfoByEmail(String email);
}
