package dao;

import bean.Blogger;

public interface BloggerDao extends BaseDao<Blogger> {
	public Blogger findBloggerByInfo_id(int id);
}
