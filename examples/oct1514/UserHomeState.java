package examples.oct1514;

import java.util.Scanner;

import examples.oct1514.two.AuctionService;

public class UserHomeState implements Event {
	private String _CurrentUser;
	private String criteria;
	private AuctionService _auctionSiteList;

	public UserHomeState(String user, AuctionService auctionSiteList) {
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
		criteria = scan.nextLine();
		scan.close();
		
	}

	@Override
	public Event next() {
		// TODO Auto-generated method stub
		if(!criteria.isEmpty()){
		SearchResultsState auctionlist =  new SearchResultsState(criteria,_CurrentUser, (AuctionService) _auctionSiteList);
		return auctionlist;
		} else{
			return new DefaultState(_auctionSiteList);
		}
	}
	@Override
	public String toString(){
		return _CurrentUser + " " + criteria + " " + _auctionSiteList.toString();
	}

}
