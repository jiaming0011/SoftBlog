package service;

import java.util.List;

import bean.Article;

public interface ArticleService {
	public boolean addArticle(String content,String title,int Blogger_id,int Tag_id,String updatetime);
	//写博客,先对ArticleContent，articlestatus进行操作，然后对表article进行操作
	public boolean updateArticle(int Article_id,String Updatetime,String Title,String content);
	//修改文章,根据对象at传进来的ArticleContent_id，Tag_id修改博客内容和标签，再在Article修改其他内容
	public boolean deleteArticle(int id);
	//删除博客,先根据id找出articleContent_id和ArticleStatus_id，然后删除article，再删除内容和文章状态
	public List<Article> findArticleByBlggerId(int Blogger_id);
	//根据博客id查找其写过的所有文章(ArticleDao要额外添加一个方法)
	public boolean addReading(int id);
	//阅读量加1，先根据文章id查找出ArticleStatus_id,然后根据ArticleStatus_id得到reading加1后再更新回去（或者另外写sql语句？）
	public boolean addEnjoy(int id);
	//点赞数加1，
	public boolean addReview(int id);
	//评论数加1
	public boolean delReview(int id);
	//评论数减1
}
