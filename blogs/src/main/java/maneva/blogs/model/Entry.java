package maneva.blogs.model;

import java.util.Date;

public class Entry {
	
	private long id;
	private String title;
	private String content;
	private Date created;
	
	public Entry() {
		
	}

	public Entry(long id, String title, String content) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.created = new Date();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
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

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	
}
