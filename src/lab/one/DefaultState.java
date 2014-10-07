package lab.one;

import java.util.Scanner;

import lab.one.two.InMemoryAuctionService;

public class DefaultState implements Event {
	private String _UserName;
	private InMemoryAuctionService _auctionSiteList;
	
	public DefaultState(InMemoryAuctionService auctionSiteList){
		_auctionSiteList = auctionSiteList;
	}
	
	public String get_UserName() {
		return _UserName;
	}

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
		else{
			next();
		}
	}

	@Override
	public Event next() {
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
