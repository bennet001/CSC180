package labs.three;

import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

public class SearchResultsStateTest {
	SearchResultsState tester;
	@Before
	public void setUp() throws Exception {
		tester = new SearchResultsState("Batman", "User--1", new InMemoryAuctionService());
	}

	@Test
	public void testSearchResultsStateStringStringAuctionService() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testSearchResultsStatePrintStreamStringAuctionService() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testShow() {
		tester.show(); // TODO
	}

	@Test
	public void testNext() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testToString() {
		fail("Not yet implemented"); // TODO
	}

}
