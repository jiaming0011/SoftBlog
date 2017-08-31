package dao.impl;

import java.util.ArrayList;
import java.util.List;

import bean.BloggerFavorite;
import bean.Message;
import dao.MessageDao;

public class MessageDaoImpl extends BaseDaoImpl<Message> implements MessageDao {

	@Override
	public List<Message> findMessageByBlogger_id1(int blogger_id1) {
		List<Message> list=new ArrayList<Message>();
		String sql="select * from Message where blogger_id1=?";
		List<Object> args=new ArrayList<Object>();
		args.add(blogger_id1);
		String classname="bean.Message";	
		list=dbu.select(sql, args, classname);
		return list;
	}

	@Override
	public List<Message> findMessageByBlogger_id2(int blogger_id2) {
		List<Message> list=new ArrayList<Message>();
		String sql="select * from Message where blogger_id2=?";
		List<Object> args=new ArrayList<Object>();
		args.add(blogger_id2);
		String classname="bean.Message";	
		list=dbu.select(sql, args, classname);
		return list;
	}

	

}
