package bean;


public class TagFavorite {
	private int id;
	private Blogger blogger_id;
	private Tag tag_id;
	
	public TagFavorite() {
		super();
	}
	public TagFavorite(int id, Blogger blogger_id, Tag tag_id) {
		super();
		this.id = id;
		this.blogger_id = blogger_id;
		this.tag_id = tag_id;
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
	public Tag getTag_id() {
		return tag_id;
	}
	public void setTag_id(Tag tag_id) {
		this.tag_id = tag_id;
	}
	
}
