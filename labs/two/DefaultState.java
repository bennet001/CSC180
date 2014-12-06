package labs.two;

import java.util.Scanner;

import labs.two.two.AuctionService;


public class DefaultState implements State {
	private String _UserName;
	private AuctionService _auctionSiteList;
	
	public DefaultState(AuctionService auctionSiteList){
		_auctionSiteList = auctionSiteList;
	}
	
	public String get_UserName() {
		return _UserName;
	}

	@SuppressWarnings("resource")
	@Override
	public void show() {
		// TODO Auto-generated method stub
		System.out.println("New User, would you like to log in? (Tap enter to decline)");
		Scanner scan = new Scanner(System.in);
		String responce = scan.nextLine();
		if (!responce.equalsIgnoreCase("Enter") && responce.length()>0){
			_UserName = responce;
			return;
		}
		
	}

	@Override
	public State next() {
		// TODO Auto-generated method stub
		if(_UserName != null){
		return new UserHomeState(_UserName, _auctionSiteList);
		}
		return null;
	}
	
	@Override
	public String toString(){
		return _UserName;
	}

}
