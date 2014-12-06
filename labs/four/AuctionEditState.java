package labs.four;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class AuctionEditState implements State, AuctionService {

	private Auction OwnerAuction;
	private AuctionService randomAuctionService;
	private SimpleDateFormat param = new SimpleDateFormat("M-dd-yyyy");
	private SimpleDateFormat param2 = new SimpleDateFormat("M.dd.yyyy");
	private AuctionDateFormat firstFormat = new AuctionDateFormat(param2);
	private AuctionDateFormat secondFormat = new AuctionDateFormat(param);

	public AuctionEditState(Auction retrieved, AuctionService auctionSiteList) {
		OwnerAuction = retrieved;
		randomAuctionService = auctionSiteList;
	}

	@SuppressWarnings("resource")
	@Override
	public void show() {
		System.out
				.printf("Would you like to 1)Change the name: %s\n2)Description: %s\n3)End Date: %s\n4)Item price: %s\n5) Delete this item\n0) Change nothing/ Commit changes\n",
						OwnerAuction.getName(), OwnerAuction.getDescription(),
						OwnerAuction.getEndTimeMillis().getTime(),
						OwnerAuction.getCurrentBid());

		Scanner scan = new Scanner(System.in);
		int userIntDecision = scan.nextInt();
		while (userIntDecision != 0) {
			switch (userIntDecision) {
			case 1:
				System.out.printf("Enter new item name: %s\n", OwnerAuction.getName());
				scan.nextLine();
				String productName = scan.nextLine();
				if (productName != null && productName.length() != 0 && productName.length() > 0) {
					OwnerAuction.setName(productName);
				}

				update(OwnerAuction,OwnerAuction.getId());
				break;
			case 2:
				System.out.printf("Enter new item Description: %s\n", OwnerAuction.getDescription());
				scan.nextLine();
				String productDescription = scan.nextLine();
				if (productDescription != null) {
					OwnerAuction.setDescription(productDescription);
				}

				update(OwnerAuction,OwnerAuction.getId());
				break;
			case 3:
				System.out.printf("Enter new item end date: %s\n", OwnerAuction.getEndTimeMillis());
				System.out.print(OwnerAuction.getCreator()
						+ " please enter a new end date for the product "
						+ "(Defaults to 7 days from now)\n"
						+ "Format is month-day-year or month.day.year: ");
				
				
				
				String productendDate = scan.nextLine();
				Long parsedendDate;
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
				Calendar changedDate = new GregorianCalendar();
				changedDate.setTimeInMillis(parsedendDate);
				OwnerAuction.setEndTimeMillis(changedDate);

				update(OwnerAuction,OwnerAuction.getId());
				break;
			case 4:
				System.out.printf("Enter new price ",OwnerAuction.getCurrentBid());
				
				OwnerAuction.setCurrentBid(scan.nextDouble());

				update(OwnerAuction,OwnerAuction.getId());
				break;
			case 5:
				if(delete(OwnerAuction.getId())){
					System.out.println("This item is deleted");
				}else{
					System.out.println("There was an error");
				}
				
			default:
				break;
			}
			userIntDecision = scan.nextInt();
		}
	}

	@Override
	public State next() {
		try (PrintStream out = new PrintStream(new FileOutputStream("auction.dat"))) {
			for (Long auctionId : auctionmodel.keySet()) {
				Auction auction = auctionmodel.get(auctionId);
				if(auction != null){
					out.println(auction.toString());
				}else{
					out.println(auctionId + "$$tombstone$$");
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return new UserHomeState(OwnerAuction.getCreator(),
				randomAuctionService);
	}

	@Override
	public Collection<Auction> search(String criteria) {
		return null;
	}

	@Override
	public void bid(String username, Long itemId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void bid(String username, Long itemId, Collection<Auction> list) {
		// TODO Auto-generated method stub

	}

	@Override
	public Auction create(Auction auction) {
		auctionmodel.put(auction.getId(), auction);
		return auction;
	}

	@Override
	public Auction update(Auction auction, Long id) {
		// TODO Auto-generated method stub
		auctionmodel.replace(id, auction);
		return auction;
	}

	@Override
	public Auction retreive(Long id) {
		return auctionmodel.get(id);
	}

	@Override
	public boolean delete(Long id) {
		boolean wasDeleted = false;
		if(auctionmodel.replace(id,null) == auctionmodel.get(id)){
			wasDeleted = true;
		}
		return wasDeleted;
	}

}
