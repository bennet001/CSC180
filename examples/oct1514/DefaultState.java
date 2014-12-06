package examples.oct1514;

import java.util.Scanner;

import examples.oct1514.two.AuctionService;


public class DefaultState implements Event {
	private String _UserName;
	private AuctionService _auctionSiteList;
	
	public DefaultState(AuctionService _auctionSiteList2){
		_auctionSiteList = _auctionSiteList2;
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
			scan.close();
			return;
		}
		else{
			scan.close();
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
