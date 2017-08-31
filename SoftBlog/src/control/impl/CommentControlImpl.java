package control.impl;

import java.util.List;

import bean.Comment;

import service.impl.CommentServiceImpl;
import control.CommentControl;

public class CommentControlImpl implements CommentControl {

	@Override
	public int JudgeCommentNotEmpty(int blogger_id,int article_id) {
		//根据网友的id，针对特定文章判断发送的评论是否为空，不为空返回1
		CommentServiceImpl csi=new CommentServiceImpl();
		List<Comment> lc=csi.findCommentByArticle(article_id);
		int flag=0;
		for(Comment c:lc)
		{
			if(c.getBlogger_id().getId()==blogger_id)
			{
				if(c.getContent().isEmpty())
				{
					continue;
				}
				else{
					flag=1;
					break;
				}
			}
		}
		return flag;
	}

	@Override
	public int JudgeCommentNotEnough(int blogger_id,int article_id) {
		//判断针对特定文章发送出来的评论是否足够15字
		CommentServiceImpl csi=new CommentServiceImpl();
		List<Comment> lc=csi.findCommentByArticle(article_id);
		int flag=0;
		for(Comment c:lc){
			if(c.getBlogger_id().getId()==blogger_id){
				if(c.getContent().length()<15)
				{
					break;
				}else{
					flag=1;
					break;
				}
			}
		}
		return flag;
	}

}
