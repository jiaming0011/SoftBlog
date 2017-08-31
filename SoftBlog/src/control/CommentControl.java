package control;

public interface CommentControl {
	public int JudgeCommentNotEmpty(int blogger_id,int article_id);
	//根据网友的id，判断针对特定文章发送的评论是否为空，不为空返回1
	public int JudgeCommentNotEnough(int blogger_id,int article_id);
	//判断针对特定文章发送出来的评论是否足够15字
}
