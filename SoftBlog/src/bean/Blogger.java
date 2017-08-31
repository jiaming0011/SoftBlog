package bean;

public class Blogger {
	private int id;
	private BloggerType type_id;
	private BloggerInfo bloggerinfo_id;
	private LoginInfo logininfo_id;
		
	
	public Blogger() {
		super();
	}
	public Blogger(int id, BloggerType type_id, BloggerInfo bloggerinfo_id, LoginInfo logininfo_id) {
		super();
		this.id = id;
		this.type_id = type_id;
		this.bloggerinfo_id = bloggerinfo_id;
		this.logininfo_id = logininfo_id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public BloggerType getType_id() {
		return type_id;
	}
	public void setType_id(BloggerType type_id) {
		this.type_id = type_id;
	}
	public BloggerInfo getBloggerinfo_id() {
		return bloggerinfo_id;
	}
	public void setBloggerinfo_id(BloggerInfo bloggerinfo_id) {
		this.bloggerinfo_id = bloggerinfo_id;
	}
	public LoginInfo getLogininfo_id() {
		return logininfo_id;
	}
	public void setLogininfo_id(LoginInfo logininfo_id) {
		this.logininfo_id = logininfo_id;
	}
	

}
