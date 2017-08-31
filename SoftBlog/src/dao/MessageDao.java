package dao;

import java.util.List;

import bean.Message;

public interface MessageDao extends BaseDao<Message> {
	public List<Message> findMessageByBlogger_id1(int blogger_id1);
	
	public List<Message> findMessageByBlogger_id2(int blogger_id2);
}
