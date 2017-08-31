package service.impl;

import java.util.ArrayList;
import java.util.List;

import service.MessageService;
import bean.Blogger;
import bean.Message;
import dao.impl.BloggerDaoImpl;
import dao.impl.MessageDaoImpl;

public class MessageServiceImpl implements MessageService {
	
	MessageDaoImpl mdi = new MessageDaoImpl();
	BloggerDaoImpl bdi = new BloggerDaoImpl();
	
	@Override
	public List<Blogger> findBloggerByBlogger_id1(int blogger_id1) {
		List<Message> list = mdi.findMessageByBlogger_id1(blogger_id1);
		List<Blogger> list2 = new ArrayList<Blogger>();
		for(Message m:list){
			list2.add(m.getBlogger_id2());
		}
		return list2;
	}

	@Override
	public List<Message> findMessageByBlogger_id2(int blogger_id1,int blogger_id2) {
		List<Message> list = mdi.findMessageByBlogger_id1(blogger_id1);
		List<Message> list2 = new ArrayList<Message>();
		for(Message m:list){
			if(m.getBlogger_id2().getId()==blogger_id2){
				list2.add(m);
			}
		}
		return list2;
	}

	@Override
	public boolean updateMessage(Message m) {
		boolean isFlag = false;
		m.setState(1);
		isFlag = mdi.update(m);
		return isFlag;
	}

	@Override
	public boolean addMessage(String content, String sendtime,
			int blogger_id1, int blogger_id2) {
		boolean isFlag = false;
		Message m = new Message();
		m.setContent(content);
		m.setSendtime(sendtime);
		m.setState(0);
		m.setBlogger_id1(bdi.findById(blogger_id1));
		m.setBlogger_id2(bdi.findById(blogger_id2));
		isFlag = mdi.add(m);
		return isFlag;
	}

	@Override
	public boolean deleteMessage(int blogger_id1,int blogger_id2) {
		boolean isFlag = false;
		List<Message> list = mdi.findMessageByBlogger_id1(blogger_id1);
		for(Message m:list){
			if(m.getBlogger_id2().getId()==blogger_id2){
				isFlag=mdi.deleteById(m.getId());
			}
		}
		return isFlag;
	}

}
