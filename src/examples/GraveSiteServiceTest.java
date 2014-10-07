package examples;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GraveSiteServiceTest {
	private GraveSiteService service = new GraveSiteService();
	
	@Before
	public void serUp(){
		service = new GraveSiteService();
	}
	@Test
	public void test() {
		GraveSites g = new GraveSites(1234,0,0,"obsidian");
		GraveSites actual = service.create(g);
		Assert.assertEquals(g, actual);
		
	}

}
