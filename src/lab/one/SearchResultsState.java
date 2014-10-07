package lab.one;

import java.util.Scanner;

import lab.one.two.Auction;
import lab.one.two.InMemoryAuctionService;

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
		for (Auction auction : output) {
			System.out.println(auction.toString());
		}
		System.out.println("========================================");
		System.out
				.println("Enter the item id to increase the bid by $1.\n"
						+ "Otherwise, enter another search: (Tap enter to go back to home page)");
		Scanner scan = new Scanner(System.in);
		input = scan.next();
		try {
			auctionSiteList.bid(_UserName, Integer.parseInt(input));
		} catch (Exception e) {
			// TODO: handle exception
			_search = input;
			show();
		}
	}

	@Override
	public Event next() {
		// TODO Auto-generated method stub
			return new UserHomeState(_UserName);
	}

	@Override
	public String toString() {
		return _UserName;
	}
}
