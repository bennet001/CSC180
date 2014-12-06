package labs.four;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


public interface AuctionService {
	static Map<Long,Auction> auctionmodel = new HashMap<Long,Auction>();
	public Collection<Auction> search(String criteria);
	public void bid(String username, Long itemId);
	public void bid(String username, Long itemId, Collection<Auction> list);
	Auction create(Auction auction);
	
	Auction update(Auction auction, Long id);
	
	Auction retreive(Long id);
	
	boolean delete(Long id);
}
