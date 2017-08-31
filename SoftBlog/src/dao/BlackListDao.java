package dao;

import java.util.List;

import bean.BlackList;

public interface BlackListDao extends BaseDao<BlackList>{
	
	public List<BlackList> findBlackListByBloggerId(int blogger_id1);

}
