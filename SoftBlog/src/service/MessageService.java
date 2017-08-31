package service;

import java.util.List;

import bean.Blogger;
import bean.Message;

public interface MessageService {
	public List<Blogger> findBloggerByBlogger_id1(int blogger_id1);
	//先根据博主找到与之有联系的博友
	public List<Message> findMessageByBlogger_id2(int blogger_id1,int blogger_id2);
	//选择一个博友显示出与之所有的信息来往，要利用到上一个表
	public boolean updateMessage(Message m);
	//改为已读
	public boolean addMessage(String content,String sendtime,int blogger_id1, int blogger_id2);
	//写私信
	public boolean deleteMessage(int blogger_id1,int blogger_id2);
	//删除私信
	
}
