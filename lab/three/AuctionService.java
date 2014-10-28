package lab.two.two;

import java.util.HashMap;
import java.util.Map;


public interface AuctionService {
	static Map<Integer,Auction> auctionmodel = new HashMap<Integer,Auction>();
	public Auction[] search(String criteria);
	
	public void bid(String username, Integer itemId);
	Auction create(Auction auction);
	
	Auction update(Auction auction, Integer id);
	
	Auction retreive(Integer id);
	
	void delete(Integer id);
}
