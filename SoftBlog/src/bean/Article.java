package bean;

public class Article {
 private int id;
 private String title;
 private String updatetime;
 private Blogger blogger_id;
 private ArticleContent articlecontent_id;
 private Tag tag_id;
 private ArticleStatus articlestatus_id;
 
public Article() {
	super();
}
public Article(int id, String title, String updatetime, Blogger blogger_id,
		ArticleContent articlecontent_id, Tag tag_id,
		ArticleStatus articlestatus_id) {
	super();
	this.id = id;
	this.title = title;
	this.updatetime = updatetime;
	this.blogger_id = blogger_id;
	this.articlecontent_id = articlecontent_id;
	this.tag_id = tag_id;
	this.articlestatus_id = articlestatus_id;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
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
public ArticleContent getArticlecontent_id() {
	return articlecontent_id;
}
public void setArticlecontent_id(ArticleContent articlecontent_id) {
	this.articlecontent_id = articlecontent_id;
}
public Tag getTag_id() {
	return tag_id;
}
public void setTag_id(Tag tag_id) {
	this.tag_id = tag_id;
}
public ArticleStatus getArticlestatus_id() {
	return articlestatus_id;
}
public void setArticlestatus_id(ArticleStatus articlestatus_id) {
	this.articlestatus_id = articlestatus_id;
}
 
}
