package labs.three;

import java.text.SimpleDateFormat;
import java.util.Scanner;

public class AuctionCreateState implements State {
	private final String UserName;
	private static AuctionService List;
	private SimpleDateFormat param = new SimpleDateFormat("M-dd-yyyy");
	private SimpleDateFormat param2 = new SimpleDateFormat("M.dd.yyyy");
	private AuctionDateFormat firstFormat = new AuctionDateFormat(param2);
	private AuctionDateFormat secondFormat = new AuctionDateFormat(param);

	String productName;
	String productDescription;
	Double productPrice = 1.0;
	String productendDate;
	Long parsedendDate;

	public AuctionCreateState(String username, AuctionService list) {
		UserName = username;
		List = list;
	}

	@SuppressWarnings("resource")
	@Override
	public void show() {
		Scanner scan = new Scanner(System.in);
		System.out.print(UserName
				+ ", please enter a short name for the product:");
		
		productName = scan.nextLine();
		
		System.out.print(UserName +
				", please seperate by commas or space\n"
				+ "please enter a descrption for the product: ");
		
		productDescription = scan.nextLine();
		
		System.out.print(UserName
				+ ", please enter an intial price for the product  "
				+ "(Defaults to 1):");
		
		productPrice = scan.nextDouble();
		
		System.out.print(UserName
				+ " finally, please enter an end date for the product "
				+ "(Defaults to 7 days from now)\n"
				+ "Format is month-day-year or month.day.year: ");
		
		scan.nextLine();
		
		productendDate = scan.nextLine();
		
		while (true) {
			if (productendDate.matches("(([0-1]?[0-9])-([0-3]?[0-9])-(\\d*))")) {
				
				parsedendDate = secondFormat.parse(productendDate).getTime();
				break;
				
			} else if (productendDate.matches("(([0-1]?[0-9])\\.([0-3]?[0-9])\\.(\\d*))")) {
				
				parsedendDate = firstFormat.parse(productendDate).getTime();
				break;
				
			} else {
				
				System.out.println("Wrong format try again");
				productendDate = scan.nextLine();
				
			}
		}
	}

	@Override
	public State next() {
		Object[] lastItem = AuctionService.auctionmodel.values().toArray();
		
		List.create(new Auction(
				(long) (((Auction) lastItem[lastItem.length - 1]).getId() + 1),
				productName, productDescription, productPrice, UserName, 0,
				parsedendDate));
		
		return new UserHomeState(UserName, List);
	}

}
