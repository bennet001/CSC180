package examples;

import java.util.HashMap;
import java.util.Map;

public class GraveSiteService extends AbstractService<GraveSites> {
	
	public GraveSites create(GraveSites g){
		models.put(g.getId(), g);
		return g;
		
	}
	public GraveSites retrive(Integer Id){
		return models.get(Id);
		
	}
	public GraveSites update(Integer Id, GraveSites g){
		models.put(Id, g);
		return retrive(Id) ;
		
	}
}
