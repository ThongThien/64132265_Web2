package QLPagePost.ntu64132265.models;

public class Post implements Identifiable{
	int id;
	String title;
	String content;
	int categoryId;
	
    @Override
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public Post(int id, String title, String content, int categoryId) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.categoryId = categoryId;
	}
	public Post() {
		// TODO Auto-generated constructor stub
	}
	
}
