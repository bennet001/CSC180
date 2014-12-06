package exercises.four.auction;

import java.util.ArrayList;

import exercises.four.CollectionUtils;


public class InMemoryAuctionService implements AuctionService {
	public InMemoryAuctionService(){
		Auction item1 = new Auction(001, "The odyssey", 100);
		Auction item2 = new Auction(002, "Batman Issue #1", 35000);
		Auction item3 = new Auction(003, "Batman Issue #2", 1200);
		auctionmodel.put(item1.getId(), item1);
		auctionmodel.put(item2.getId(), item2);
		auctionmodel.put(item3.getId(), item3);
	}
	@Override
	public Auction[] search(String criteria, CollectionUtils usable) {
		String[] lookfor = criteria.split(" ");
		ArrayList<Auction> searchResult = new ArrayList<Auction>();
		for (int i = 1; i < (lookfor.length - 1); i++) {
			if(lookfor[i].equalsIgnoreCase("AND")){
			} else if(lookfor[i].equalsIgnoreCase("OR")){
				
			}
		}
		Auction[] container = new Auction[searchResult.size()]; 
		return (Auction[]) searchResult.toArray(container);
	}

	@Override
	public void bid(String username, int itemId) {
		Auction tempItem =  auctionmodel.get(itemId);
		if(tempItem != null){
			tempItem.setCurrentBid((tempItem.getCurrentBid()+1));
			tempItem.setOwner(username);
			auctionmodel.put(tempItem.getId(), tempItem);		
		}
	}
	@Override
	public Auction create(Auction auction) {
		return auctionmodel.put(auction.getId(), auction);
	}
	@Override
	public Auction update(Auction auction, Integer id) {
		if(auctionmodel.containsKey(id)){
			return auctionmodel.put(id, auction);
		}
		System.out.println("Id Mismatch: Cannot find the designated object with this id");
		return null;
	}
	@Override
	public Auction retreive(Integer id) {	
		if (auctionmodel.containsKey(id)) {
			return auctionmodel.get(id);	
		}
		System.out.println("Object could not be found");
		return null;
	}
	@Override
	public void delete(Integer id) {
		if (auctionmodel.containsKey(id)) {
			auctionmodel.remove(id);
		}
	}
}