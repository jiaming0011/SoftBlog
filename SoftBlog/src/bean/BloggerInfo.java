package bean;

public class BloggerInfo {
	private int id;
	private String name;
	private String email;
	private String brief;
	private String image;
		
	public BloggerInfo() {
		super();
	}
	public BloggerInfo(int id, String name, String email, String brief, String image) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.brief = brief;
		this.image = image;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getBrief() {
		return brief;
	}
	public void setBrief(String brief) {
		this.brief = brief;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
		

	
}
