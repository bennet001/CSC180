package lab.two.two;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Stack;

import lab.two.one.AndPredicate;
import lab.two.one.ContainsPredicate;
import lab.two.one.OrPredicate;
import lab.two.one.Predicate;


public class InMemoryAuctionService implements AuctionService {
	public InMemoryAuctionService(){
		Auction item1 = new Auction(001, "The odyssey", 100);
		Auction item2 = new Auction(002, "Batman Issue #1", 35000);
		Auction item3 = new Auction(003, "Batman Issue #2", 1200, "Mint condition still in package");
		auctionmodel.put(item1.getId(),item1);
		auctionmodel.put(item2.getId(),item2);
		auctionmodel.put(item3.getId(),item3);
	}
	@Override
	public Auction[] search(String criteria) {
		Stack<Predicate> predicateContainer = new Stack<Predicate>();
		Stack<Predicate> OperatorContainer = new Stack<Predicate>();
		String[] lookfor = criteria.split(" ");
		for (int i = 0; i < (lookfor.length); i++) {
			if(lookfor[i].equalsIgnoreCase("AND")){
				OperatorContainer.push(new AndPredicate());
			} else if(lookfor[i].equalsIgnoreCase("OR") && !OperatorContainer.contains(new AndPredicate())){
				OperatorContainer.push(new OrPredicate());
			} else if((lookfor[i].equalsIgnoreCase("OR") && OperatorContainer.contains(new AndPredicate())) || i == lookfor.length){
				Predicate<Auction> pop1 = predicateContainer.pop();
				Predicate<Auction> pop2 = predicateContainer.pop();
				Predicate pop3 = OperatorContainer.pop();
				pop3.setFirstNeed(pop1);
				pop3.setSecondNeed(pop2);
				predicateContainer.push(pop3);
				OperatorContainer.push(new OrPredicate());
			}
			else if((i+1)%4==0){
				Predicate<Auction> pop1 = predicateContainer.pop();
				Predicate<Auction> pop2 = predicateContainer.pop();
				Predicate pop3 = OperatorContainer.pop();
				pop3.setFirstNeed(pop1);
				pop3.setSecondNeed(pop2);
				predicateContainer.push(pop3);
			}
			else{
				predicateContainer.push(new ContainsPredicate<String>(lookfor[i]));
			}
		}
		return Filter(auctionmodel.values(), predicateContainer.pop());
	}
	
	public Auction[] Filter(Collection<Auction> providedCollection, Predicate<Auction> providedPredicate) {
		ArrayList<Auction> searchResult = new ArrayList<Auction>();
		for (Auction CurrentAuctionItem : providedCollection) {
			Auction check = providedPredicate.evaluate(CurrentAuctionItem) ? CurrentAuctionItem:null;
			if(check!=null){
				searchResult.add(check);
			}
		}
		Auction[] container = new Auction[searchResult.size()]; 
		return (Auction[]) searchResult.toArray(container);
	}

	@Override
	public void bid(String username, Integer itemId) {
		Auction tempItem = null;
		for (Auction currentAucItem : auctionmodel.values()) {
			if(currentAucItem.equals(itemId)){
				tempItem = currentAucItem;
			}
		}
		if(tempItem != null){
			tempItem.setCurrentBid((tempItem.getCurrentBid()+1));
			tempItem.setOwner(username);
			auctionmodel.put(tempItem.getId(), tempItem);			
		}
	}
	@Override
	public Auction create(Auction auction) {
		// TODO Auto-generated method stub
		auctionmodel.put(auction.getId(), auction);
		return auction;
	}
	@Override
	public Auction update(Auction auction, Integer id) {
		// TODO Auto-generated method stub
		auctionmodel.replace(id, auction);
		return auction;
	}
	@Override
	public Auction retreive(Integer id) {
		// TODO Auto-generated method stub
		return auctionmodel.get(id);
	}
	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		auctionmodel.remove(id);
	}
}