package maneva.blogs.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import maneva.blogs.model.Entry;
import maneva.blogs.service.EntryService;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EntryResource {

	private EntryService entryService = new EntryService();
	
	@GET
	public List<Entry> getAllEntries(@PathParam("blogId") long blogId) {
		return entryService.getAllEntries(blogId);
	}
	
	@POST
	@Path("/{entryId}")
	public Entry addEntry(@PathParam("blogId") long blogId,
			@PathParam("entryId") long entryId, Entry entry ) {
		return entryService.getEntry(blogId, entryId);
	}
			
	@PUT
	@Path("/{entryId}")
	public Entry updateEntry(@PathParam("blogId") long blogId,
			@PathParam("entryId") long entryId, Entry entry ) {
		entry.setId(entryId);
		return entryService.updateEntry(blogId, entry);
	}
	
	@DELETE
	@Path("/{entryId}")
	public void removeEntry(@PathParam("blogId") long blogId,
			@PathParam("entryId") long entryId ) {
		entryService.removeEntry(blogId, entryId);
	}
	
}
