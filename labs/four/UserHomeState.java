package labs.four;

import java.util.Scanner;

public class UserHomeState implements State {
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

	@SuppressWarnings("resource")
	@Override
	public void show() {
		// TODO Auto-generated method stub
		System.out
				.println(_CurrentUser
						+ ", what would you to do. (Tap enter to log out)\n"
						+ "1) Search for auction item\n"
						+ "2) Create new auction item");
		Scanner scanner = new Scanner(System.in);
		criteria = scanner.nextLine();
	}

	@SuppressWarnings("resource")
	@Override
	public State next() {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		try{
		switch (Integer.parseInt(criteria)) {
		
		case 1:
			System.out.println("Enter search criteria.");
			criteria = scan.nextLine();
			return new SearchResultsState(criteria,_CurrentUser, _auctionSiteList);
		case 2:
			return new AuctionCreateState(_CurrentUser, _auctionSiteList);			
		default:
			return new DefaultState(_auctionSiteList);
		}
		}catch(Exception e){
			return new DefaultState(_auctionSiteList);
		}
	}

	@Override
	public String toString() {
		return _CurrentUser + " " + criteria + " "
				+ _auctionSiteList.toString();
	}

}
