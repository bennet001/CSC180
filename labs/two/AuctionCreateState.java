package lab.two;

import java.util.Scanner;

import lab.two.Auction;
import lab.two.AuctionService;


public class AuctionCreateState implements State {
	private final String UserName;
	private static AuctionService List;
	
	String productName;
	String productDescription;
	int productPrice = 1;
	
	public AuctionCreateState(String username, AuctionService list){
		UserName = username;
		List = list;
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.print(UserName + " please enter a short name for the product:");
		productName = scan.nextLine();
		System.out.print(UserName + " Please seperate by commas or space\nplease enter a descrption for the product: ");
		productDescription = scan.nextLine();
		System.out.print(UserName + " finally, please enter an intial price for the product (Defaults to 1):");
		productPrice = scan.nextInt();
	}

	@Override
	public State next() {
		// TODO Auto-generated method stub
		List.create(new Auction((AuctionService.auctionmodel.size()+1), productName, productPrice, productDescription));
		return new UserHomeState(UserName, List);
	}

}
