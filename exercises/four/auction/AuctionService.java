package exercises.four.auction;

import java.util.HashMap;
import java.util.Map;

import exercises.four.CollectionUtils;


public interface AuctionService {
	static Map<Integer,Auction> auctionmodel = new HashMap<Integer,Auction>();
	public Auction[] search(String criteria, CollectionUtils utils);
	
	public void bid(String username, int itemId);
	
	Auction create(Auction auction);
	
	Auction update(Auction auction, Integer id);
	
	Auction retreive(Integer id);
	
	void delete(Integer id);
}
