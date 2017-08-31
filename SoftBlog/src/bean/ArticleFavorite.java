package bean;

public class ArticleFavorite {
	private int id;
	private Blogger blogger_id;
	private Article article_id;
	public ArticleFavorite(int id, Blogger blogger_id, Article article_id) {
		super();
		this.id = id;
		this.blogger_id = blogger_id;
		this.article_id = article_id;
	}
	public ArticleFavorite() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
