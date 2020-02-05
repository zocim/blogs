package maneva.blogs.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import maneva.blogs.database.DatabaseClass;
import maneva.blogs.model.User;

public class UserService {

private Map<String, User> users = DatabaseClass.getUsers();
	
	public UserService() {
		users.put("maneva", new User(1L, "maneva", "Zorica", "Maneva"));
	}
	
	public List<User> getAllUsers() {
		return new ArrayList<User>(users.values()); 
	}
	
	public User getUser(String userName) {
		return users.get(userName);
	}
	
	public User addUser(User user) {
		user.setId(users.size() + 1);
		users.put(user.getUserName(), user);
		return user;
	}
	
	public User updateUser(User user) {
		if (user.getUserName().isEmpty()) {
			return null;
		}
		users.put(user.getUserName(), user);
		return user;
	}
	
	public User removeUser(String userName) {
		return users.remove(userName);
	}
}
