package exercises.two;

import java.util.ArrayList;

public class InMemoryAuctionService implements AuctionService {
	public ArrayList<Auction> ItemsContainer = new ArrayList<Auction>();
	public InMemoryAuctionService(){
		Auction item1 = new Auction(001, "The odyssey", 100);
		Auction item2 = new Auction(002, "Batman Issue #1", 35000);
		Auction item3 = new Auction(003, "Batman Issue #2", 1200);
		ItemsContainer.add(item1);
		ItemsContainer.add(item2);
		ItemsContainer.add(item3);
	}
	@Override
	public Auction[] search(String criteria) {
		ArrayList<Auction> searchResult = new ArrayList<Auction>();
		for (Auction CurrentAuctionItem : ItemsContainer) {
			if(CurrentAuctionItem.get_Name() == criteria){
				searchResult.add(CurrentAuctionItem);
			}
		}
		Auction[] container = new Auction[searchResult.size()]; 
		return (Auction[]) searchResult.toArray(container);
	}

	@Override
	public void bid(String username, int itemId) {
		Auction tempItem = null;
		for (Auction currentAucItem : ItemsContainer) {
			if(currentAucItem.equals(itemId)){
				tempItem = currentAucItem;
			}
		}
		if(tempItem != null){
			ItemsContainer.remove(tempItem);
			tempItem.set_CurrentBid((tempItem.get_CurrentBid()+1));
			tempItem.set_Owner(username);
			ItemsContainer.add(tempItem);			
		}
	}
}