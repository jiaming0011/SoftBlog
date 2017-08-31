package dao;

import bean.Tag;

public interface TagDao extends BaseDao<Tag> {
	public Tag FindByName(String name);
}
