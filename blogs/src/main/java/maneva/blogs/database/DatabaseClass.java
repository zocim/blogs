package maneva.blogs.database;

import java.util.HashMap;
import java.util.Map;

import maneva.blogs.model.Blog;
import maneva.blogs.model.Entry;
import maneva.blogs.model.User;

public class DatabaseClass {
	private static Map<Long, Blog> blogs = new HashMap<>();
	private static Map<Long, Entry> entries = new HashMap<>();
	private static Map<String, User> users = new HashMap<>();
	
	public static Map<Long, Blog> getBlogs() {
		return blogs;
	}
	
	public static Map<Long, Entry> getEntries() {
		return entries;
	}
	
	public static Map<String, User> getUsers() {
		return users;
	}
	
}
