package exercises.two;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InMemoryAuctionService check = new InMemoryAuctionService();
		System.out.println(check.search("The odyssey").length);
		System.out.println(check.search("Free").length);
		check.bid("Bennet", 1);
		check.bid("Aron", 1);
		check.bid("Bennet", 1);
		check.bid("Calvin", 4);
		System.out.println(check.ItemsContainer.toString());
	}

}
