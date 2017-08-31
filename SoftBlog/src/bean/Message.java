package bean;

public class Message {
	private int id;
	private String content;
	private String sendtime;
	private Blogger blogger_id1;
	private Blogger blogger_id2;
	private int state;
	
	
	public Message() {
		super();
	}
	public Message(int id, String content, String sendtime,
			Blogger blogger_id1, Blogger blogger_id2, int state) {
		super();
		this.id = id;
		this.content = content;
		this.sendtime = sendtime;
		this.blogger_id1 = blogger_id1;
		this.blogger_id2 = blogger_id2;
		this.state = state;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
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
	public String getSendtime() {
		return sendtime;
	}
	public void setSendtime(String sendtime) {
		this.sendtime = sendtime;
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
