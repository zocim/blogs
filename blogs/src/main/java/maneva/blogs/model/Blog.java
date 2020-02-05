package maneva.blogs.model;

import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement
public class Blog {

	private long id;
	private String title;
	private String author;

	private Map<Long, Entry> entries = new HashMap<>();
	
	public Blog() {
		
	}

	public Blog(long id, String title) {
		this.id = id;
		this.title = title;
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
	
	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@XmlTransient
	public Map<Long, Entry> getEntries() {
		return entries;
	}

	public void setEntries(Map<Long, Entry> entries) {
		this.entries = entries;
	}
	
	
	
}
