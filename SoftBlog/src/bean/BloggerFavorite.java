package bean;

public class BloggerFavorite {
	private int id;
	private Blogger blogger_id1;
	private Blogger blogger_id2;
	public BloggerFavorite(int id, Blogger blogger_id1, Blogger blogger_id2) {
		super();
		this.id = id;
		this.blogger_id1 = blogger_id1;
		this.blogger_id2 = blogger_id2;
	}
	public BloggerFavorite() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Blogger getBlogger_id1() {
		return blogger_id1;
	}
	public void setBlogger_id1(Blogger blogger_id1) {
		this.blogger_id1 = blogger_id1;
	}
	public Blogger getBlogger_id2() {
		return blogger_id2;
	}
	public void setBlogger_id2(Blogger blogger_id2) {
		this.blogger_id2 = blogger_id2;
	}
	
}
