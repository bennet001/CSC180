package examples.oct1514;

import static org.junit.Assert.fail;

import org.junit.Assert;
import org.junit.Test;

import examples.oct1514.two.Auction;
import examples.oct1514.two.AuctionService;

public class SearchResultStateTest {
	private AuctionService as = new AuctionService(){
		private Auction dummy = new Auction(1234, "Batman", 1);
		@Override
		public Auction[] search(String criteria) {
			// TODO Auto-generated method stub
			return new Auction[]{dummy};
		}

		@Override
		public void bid(String username, Integer itemId) {
			// TODO Auto-generated method stub
			
		}
		
	};
	@Test
	public void testEmptyResponce() {
		SearchResultsState tester = new SearchResultsState("Batman", "Batman", as);
		Event s  = tester.next();
		Assert.assertTrue("Should have returned a user homestate", s instanceof UserHomeState);
	}
	
	@Test
	public void testBidRespomce(){
		fail("Not yet implemented");
	}
	
	@Test
	public void testSearchResponce(){
		
		fail("Not yet implemented");
	}

}
