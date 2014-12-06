package labs.one.two;

public interface AuctionService {
	public Auction[] search(String criteria);
	
	public void bid(String username, Integer itemId);
}
