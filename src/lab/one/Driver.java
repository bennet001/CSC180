package lab.one;

import exercises.two.InMemoryAuctionService;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InMemoryAuctionService check = new InMemoryAuctionService();
		check.bid("Bennet", 1);
		check.bid("Aron", 1);
		check.bid("Bennet", 1);
		check.bid("Calvin", 4);
		System.out.println(check.ItemsContainer.toString());
	}
}
