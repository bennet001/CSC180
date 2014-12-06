package examples.oct1514.two;

public interface AuctionService {
	public Auction[] search(String criteria);
	
	public void bid(String username, Integer itemId);
}
