package examples;

import java.util.HashMap;
import java.util.Map;

public class GraveSiteService implements Service<GraveSites> {
	private Map gravesites = new HashMap();
	
	@Override
	public GraveSites create(GraveSites g){
		gravesites.put(g.getId(), g);
		return g;
		
	}
	public GraveSites retrive(Integer Id){
		return (GraveSites) gravesites.get(Id);
		
	}
	public GraveSites update(Integer Id, GraveSites g){
		gravesites.put(Id, g);
		return retrive(Id) ;
		
	}
	public void delete(Integer Id){
		gravesites.remove(Id);
	}
}
