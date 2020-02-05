package maneva.blogs.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import maneva.blogs.database.DatabaseClass;
import maneva.blogs.model.Blog;

public class BlogService {
	private Map<Long, Blog> blogs =  DatabaseClass.getBlogs();
	
	public BlogService() {
		blogs.put(1L, new Blog(1, "Prv blog na maneva"));
		blogs.put(2L, new Blog(2, "Vtor blog na maneva"));
	}
	
	public List<Blog> getAllBlogs() {
		return new ArrayList<Blog>(blogs.values());
	}
	
	public Blog getBlog(long id) {
		return blogs.get(id);
	}
	
	public Blog addBlog(Blog blog) {
		blog.setId(blogs.size() + 1);
		blogs.put(blog.getId(), blog);
		return blog;
	}
	
	public Blog updateBlog(Blog blog) {
		if(blog.getId() <= 0) {
			return null;
		}
		blogs.put(blog.getId(), blog);
		return blog;
	}
	
	public void removeBlog(long id) {
		blogs.remove(id);
	}


	public List<Blog> getAllBlogsPaginated(int start, int size) {
		ArrayList<Blog> list = new ArrayList<Blog>(blogs.values());
		if( start + size > list.size() ) return new ArrayList<Blog>();
		return list.subList(start, start + size);
	}
 }
