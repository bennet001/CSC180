package labs.three;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Stack;


public class InMemoryAuctionService implements AuctionService {
	public InMemoryAuctionService(){
		Auction item1 = new Auction((long) 01, "The odyssey", 100.0, "Bennet");
		Auction item2 = new Auction((long) 002, "Batman Issue #1", 35000.0, "Bennet");
		Auction item3 = new Auction((long) 003, "Batman Issue #2", 1200.0, "Bennet", "Mint condition still in package");
		auctionmodel.put(item1.getId(),item1);
		auctionmodel.put(item2.getId(),item2);
		auctionmodel.put(item3.getId(),item3);
	}
	
	public InMemoryAuctionService(String filepath){
		
	}
	
//	@Override
//	public Auction[] search(String criteria) {
//		Stack<Predicate> predicateContainer = new Stack<Predicate>();
//		Stack<String> OperatorContainer = new Stack<String>();
//		String[] lookfor = criteria.split(" ");
//		for (int i = 0; i < (lookfor.length); i++) {
//			if(lookfor[i].equalsIgnoreCase("AND")){
//				OperatorContainer.push("AND");
//			} else if(lookfor[i].equalsIgnoreCase("OR") && !OperatorContainer.contains(new AndPredicate())){
//				OperatorContainer.push("OR");
//			} else if((lookfor[i].equalsIgnoreCase("OR") && OperatorContainer.contains(new AndPredicate())) || i == lookfor.length){
//				Predicate<Auction> pop1 = predicateContainer.pop();
//				Predicate<Auction> pop2 = predicateContainer.pop();
//				Predicate pop3 = DecidePredicate(OperatorContainer.pop());
//				pop3.setFirstNeed(pop1);
//				pop3.setSecondNeed(pop2);
//				predicateContainer.push(pop3);
//				OperatorContainer.push("OR");
//			}
//			else{
//				predicateContainer.push(new ContainsPredicate<String>(lookfor[i]));
//			}
//		}
//		return Filter(auctionmodel.values(), predicateContainer.pop());
//	}
	
	private Predicate DecidePredicate(String pop) {
		Predicate action = null;
		switch (pop) {
		case "AND":
			action = new AndPredicate();
			break;
		case "OR":
			action = new OrPredicate();
			break;
		default:
			break;
		}
		return action;
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
	public void bid(String username, Long itemId) {
		Auction tempItem = auctionmodel.get(itemId);
		
		if(tempItem != null && tempItem.getEndTimeMillis().compareTo(new GregorianCalendar()) <= 0){
			tempItem.setCurrentBid((tempItem.getCurrentBid()+1));
			tempItem.setOwner(username);
			auctionmodel.put(tempItem.getId(), tempItem);			
		} else{
			
		}
	}

	@Override
	public Auction create(Auction auction) {
		// TODO Auto-generated method stub
		auctionmodel.put(auction.getId(), auction);
		return auction;
	}
	
	@Override
	public Auction update(Auction auction, Long id) {
		// TODO Auto-generated method stub
		auctionmodel.replace(id, auction);
		return auction;
	}
	
	@Override
	public Auction retreive(Long id) {
		// TODO Auto-generated method stub
		return auctionmodel.get(id);
	}
	
	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		auctionmodel.remove(id);
	}

	@Override
	public Collection<Auction> search(String criteria) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void bid(String username, Long itemId, Collection<Auction> list) {
		// TODO Auto-generated method stub
		
	}
}