package exercises.five;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import exercises.five.two.Auction;

public class TableRowAuctionConverterTest {

	Auction[] list;
	@Before
	public void setUp() {
		list = new Auction[]{
				new Auction(001,"Grimoire",035), new Auction(002,"Comic",012),
				new Auction(002,"Grimoire asdfasdf",035), new Auction(002,"Comicsans",012),
				new Auction(003,"Grimoire asdf",035), new Auction(002,"Comiccon",012),
				new Auction(004,"Grimoire as",035), new Auction(002,"Comicon",012),
				new Auction(005,"Grimoire a",035), new Auction(002,"Comicooon ",012)
		};	
	}

	@Test
	public void testFormat() {
		TableRowAuctionConverter c = new TableRowAuctionConverter();
		for ( Auction a : list ) {
			System.out.println(c.format(a));
		}
	}

}
