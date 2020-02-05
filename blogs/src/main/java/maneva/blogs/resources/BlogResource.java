package maneva.blogs.resources;

import java.net.URI;
import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import maneva.blogs.beans.BlogFilterBean;
import maneva.blogs.model.Blog;
import maneva.blogs.service.BlogService;

@Path("/blogs")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class BlogResource {
	private BlogService blogService = new BlogService();
	
	@GET
	public List<Blog> getBlogs() {
		return blogService.getAllBlogs();
	}
	
	@POST
	public Blog addBlog(Blog blog) {
		return blogService.addBlog(blog);
	}
	
	@PUT
	@Path("/{blogId}")
	public Blog updateBlog(@PathParam("blogId") long blogId, Blog blog) {
		blog.setId(blogId);
		return blogService.updateBlog(blog);
	}
	
	@DELETE
	@Path("/{blogId}")
	public void deleteBlog(@PathParam("blogId") long blogId) {
		blogService.removeBlog(blogId);
	}
	
	@GET
	@Path("/{blogId}")
	public Blog getBlog(@PathParam("blogId") long blogId) {
		return blogService.getBlog(blogId);
	}
	
//	@GET
//	public List<Blog> getBlogs(@BeanParam BlogFilterBean filterBean){
//		if(filterBean.getStrat() >= 0 && filterBean.getSize() > 0) {
//			return blogService.getAllBlogsPaginated(filterBean.getStrat(), filterBean.getSize());
//		}
//		return blogService.getAllBlogs();
//	}
	
	private String getUriForEntries(UriInfo uriInfo, Blog blog) {
		URI uri = uriInfo.getBaseUriBuilder()
				.path(BlogResource.class)
	       		.path(BlogResource.class, "getEntryResource")
	       		.path(EntryResource.class)
	       		.resolveTemplate("blogId", blog.getId())
	            .build();
	    return uri.toString();
	}

	private String getUriForUser(UriInfo uriInfo, Blog blog) {
		URI uri = uriInfo.getBaseUriBuilder()
       		 .path(UserResource.class)
       		 .path(blog.getAuthor())
             .build();
        return uri.toString();
	}

	private String getUriForSelf(UriInfo uriInfo, Blog blog) {
		String uri = uriInfo.getBaseUriBuilder()
		 .path(BlogResource.class)
		 .path(Long.toString(blog.getId()))
		 .build()
		 .toString();
		return uri;
	}

	@Path("/{blogId}/entries")
	public EntryResource getEntryResource() {
		return new EntryResource();
	}
}
