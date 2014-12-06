package labs.three;

import java.util.Collection;
import java.util.Scanner;

public class SearchResultsState implements State {
	private String _search;
	private String _UserName;
	Collection<Auction> output;
	private String input;
	private AuctionService auctionSiteList;

	public SearchResultsState(String SearchCriteria, String userName, AuctionService list) {
		_search = SearchCriteria;
		_UserName = userName;
		auctionSiteList = list;
	}

	@SuppressWarnings("resource")
	@Override
	public void show() {
		// TODO Auto-generated method stub
		System.out.printf(_UserName + ", here are your search results:\n"
				+ "========================================\n"
				+ "===          Search Results          ===\n"
				+ "========================================\n"
				+ "%-12s, %-85s, %-10s, %-10s, %-10s, %-10s\n", "ID", "Name", "Current Bid",
				"Bid Count", "Owner", "Ends By");
		output = auctionSiteList.search(_search);
		if (output.size() > 0) {
			for (Auction auction : output) {
				System.out.println(auction.toString());
			}
		}
		System.out.println("========================================");
		System.out
				.println("Enter the item id to increase the bid by $1.\n"
						+ "Otherwise, enter another search: "
						+ "(Tap enter to go back to home page)");
		Scanner scan = new Scanner(System.in);
		input = scan.nextLine();
		
	}

	@Override
	public State next() {
		// TODO Auto-generated method stub
		try {
			auctionSiteList.bid(_UserName, Long.parseLong(input), output);
		} catch (Exception e) {
			// TODO: handle exception
			_search = input;
			if (_search.isEmpty()) {
				
			}
			else{
				return new SearchResultsState(_search, _UserName, auctionSiteList);
			}
		}
		return new UserHomeState(_UserName,auctionSiteList);
	}

	@Override
	public String toString() {
		return _UserName;
	}
}
