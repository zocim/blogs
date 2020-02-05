package maneva.blogs.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import maneva.blogs.database.DatabaseClass;
import maneva.blogs.model.Blog;
import maneva.blogs.model.Entry;

public class EntryService {
	private Map<Long, Blog> blogs = DatabaseClass.getBlogs();
	
	
	public EntryService() {	
	}
	
	public List<Entry> getAllEntries(long blogId) {
		Map<Long, Entry> entries = blogs.get(blogId).getEntries();
		return new ArrayList<Entry>(entries.values());
	}

	public Entry getEntry(long blogId, long entryId) {
		Map<Long, Entry> entries = blogs.get(blogId).getEntries();
		return entries.get(entryId);
	}
	
	public Entry addEntry(long blogId, Entry entry) {
		Map<Long, Entry> entries = blogs.get(blogId).getEntries();
		entry.setId(entry.getId() + 1);
		entries.put(entry.getId(), entry);
		return entry;
	}
	
	public Entry updateEntry(long blogId, Entry entry) {
		Map<Long, Entry> entries = blogs.get(blogId).getEntries();
		if(entry.getId() <= 0) {
			return null;
		}
		entries.put(entry.getId(), entry);
		return entry;
	}
	
	public void removeEntry(long blogId, long entryId) {
		Map<Long, Entry> entries = blogs.get(blogId).getEntries();
		entries.remove(entryId);
	}
	
}
