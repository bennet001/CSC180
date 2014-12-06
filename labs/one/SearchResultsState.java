package labs.one;

import java.util.Scanner;

import labs.one.two.Auction;
import labs.one.two.InMemoryAuctionService;

public class SearchResultsState implements Event {
	private String _search;
	private String _UserName;
	Auction[] output;
	private String input;
	private InMemoryAuctionService auctionSiteList;

	public SearchResultsState(String SearchCriteria, String userName, InMemoryAuctionService list) {
		_search = SearchCriteria;
		_UserName = userName;
		auctionSiteList = list;
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		System.out.println(_UserName + ", here are your search results:\n"
				+ "========================================\n"
				+ "===          Search Results          ===\n"
				+ "========================================");
		output = auctionSiteList.search(_search);
		if (output.length > 0) {
			for (Auction auction : output) {
				System.out.println(auction.toString());
			}
		}
		System.out.println("========================================");
		System.out
				.println("Enter the item id to increase the bid by $1.\n"
						+ "Otherwise, enter another search: (Tap enter to go back to home page)");
		Scanner scan = new Scanner(System.in);
		input = scan.nextLine();
		try {
			auctionSiteList.bid(_UserName, Integer.parseInt(input));
		} catch (Exception e) {
			// TODO: handle exception
			_search = input;
			if (_search.isEmpty()) {
				next();
				scan.close();
			}
			else{
				show();
				scan.close();
			}
		}
	}

	@Override
	public Event next() {
		// TODO Auto-generated method stub
			return new UserHomeState(_UserName,auctionSiteList);
	}

	@Override
	public String toString() {
		return _UserName;
	}
}
