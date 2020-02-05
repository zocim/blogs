package maneva.blogs.beans;

import javax.ws.rs.QueryParam;

public class BlogFilterBean {
	
	private @QueryParam("start") int strat;
	private @QueryParam("size") int size;
	
	public int getStrat() {
		return strat;
	}
	public void setStrat(int strat) {
		this.strat = strat;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
}
