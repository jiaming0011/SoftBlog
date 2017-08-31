package bean;

public class ArticleStatus {
	private int id;
	private int reading;
	private int enjoy;
	private int reviews;
	public ArticleStatus() {
		super();
	}
	public ArticleStatus(int id, int reading, int enjoy, int reviews) {
		super();
		this.id = id;
		this.reading = reading;
		this.enjoy = enjoy;
		this.reviews = reviews;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getReading() {
		return reading;
	}
	public void setReading(int reading) {
		this.reading = reading;
	}
	public int getEnjoy() {
		return enjoy;
	}
	public void setEnjoy(int enjoy) {
		this.enjoy = enjoy;
	}
	public int getReviews() {
		return reviews;
	}
	public void setReviews(int reviews) {
		this.reviews = reviews;
	}
	
}
