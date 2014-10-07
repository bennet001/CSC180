package lab.one;

import java.util.Scanner;

import lab.one.two.InMemoryAuctionService;

public class UserHomeState implements Event {
	private String _CurrentUser;
	private String criteria;
	private InMemoryAuctionService _auctionSiteList;

	public UserHomeState(String user, InMemoryAuctionService auctionSiteList) {
		_CurrentUser = user;
		_auctionSiteList = auctionSiteList;
	}

	public UserHomeState(String user) {
		_CurrentUser = user;
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		System.out
				.println(_CurrentUser
						+ ", what would you like to search for? (Tap enter to log out)");
		Scanner scan = new Scanner(System.in);
		criteria = scan.next();
		
	}

	@Override
	public Event next() {
		// TODO Auto-generated method stub
		SearchResultsState auctionlist =  new SearchResultsState(criteria,_CurrentUser, _auctionSiteList);
		return auctionlist;
	}
	@Override
	public String toString(){
		return _CurrentUser;
	}

}
