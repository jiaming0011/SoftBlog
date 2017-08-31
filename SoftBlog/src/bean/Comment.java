package bean;

public class Comment {
	private int id;
	private String content;
	private String updatetime;
	private Blogger blogger_id;
	private Article article_id;
	public Comment(int id, String content, String updatetime,
			Blogger blogger_id, Article article_id) {
		super();
		this.id = id;
		this.content = content;
		this.updatetime = updatetime;
		this.blogger_id = blogger_id;
		this.article_id = article_id;
	}
	public Comment() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getUpdatetime() {
		return updatetime;
	}
	public void setUpdatetime(String updatetime) {
		this.updatetime = updatetime;
	}
	public Blogger getBlogger_id() {
		return blogger_id;
	}
	public void setBlogger_id(Blogger blogger_id) {
		this.blogger_id = blogger_id;
	}
	public Article getArticle_id() {
		return article_id;
	}
	public void setArticle_id(Article article_id) {
		this.article_id = article_id;
	}
	
}
