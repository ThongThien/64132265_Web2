package QLPagePost.ntu64132265.models;

public class Page implements Identifiable {
	int id;
	String pageName;
	String keyword;
	String content;
	int parentPageId;
	
    @Override
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPageName() {
		return pageName;
	}
	public void setPageName(String pageName) {
		this.pageName = pageName;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getParentPageId() {
		return parentPageId;
	}
	public void setParentPageId(int parentPageId) {
		this.parentPageId = parentPageId;
	}
	public Page(int id, String pageName, String keyword, String content, int parentPageId) {
		this.id = id;
		this.pageName = pageName;
		this.keyword = keyword;
		this.content = content;
		this.parentPageId = parentPageId;
	}
	public Page() {
		// TODO Auto-generated constructor stub
	}
	
}
