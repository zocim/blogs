package maneva.blogs.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class User {

	private long id;
    private String userName;
    private String firstName;
    private String lastName;
    private Date created;
    
    public User() {
    	
    }
    
	public User(long id, String userName, String firstName, String lastName) {
		this.id = id;
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
}
