package labs.four;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Collection;
import java.util.Scanner;

public class SearchResultsState implements State {
	private String _search;
	private String _UserName;
	Collection<Auction> output;
	private String input;
	private AuctionService auctionSiteList;

	public SearchResultsState(String SearchCriteria, String userName,
			AuctionService list) {
		_search = SearchCriteria;
		_UserName = userName;
		auctionSiteList = list;
	}

	@SuppressWarnings("resource")
	@Override
	public void show() {
		// TODO Auto-generated method stub
		System.out.printf(_UserName + ", here are your search results:\n"
				+ "========================================\n"
				+ "===          Search Results          ===\n"
				+ "========================================\n"
				+ "%-12s, %-85s, %-10s, %-10s, %-10s, %-10s\n", "ID", "Name",
				"Current Bid", "Bid Count", "Owner", "Ends By");
		output = auctionSiteList.search(_search);
		if (output.size() > 0) {
			for (Auction auction : output) {
				if (auction.getCreator().equals(_UserName)) {
					System.out.println(auction.toString() + " Edit");
				} else {
					System.out.println(auction.toString());
				}
			}
		}
		System.out.println("========================================");
		System.out
				.println("Enter the item id to increase the bid by $1.\nIf you are an  owner enter item ID to edit\nOtherwise, enter another search: (Tap enter to go back to home page)\n");
		Scanner scan = new Scanner(System.in);
		input = scan.nextLine();

	}

	@Override
	public State next() {
		// TODO Auto-generated method stub
		try{
			Long longParse = Long.parseLong(input);
			Auction retrieved = auctionSiteList.retreive(longParse);
			if(retrieved != null && retrieved.getCreator() != _UserName){
				auctionSiteList.bid(_UserName, Long.parseLong(input));
				
				try (PrintStream out = new PrintStream(new FileOutputStream("auction.dat"))) {
					for (Long auctionId : AuctionService.auctionmodel.keySet()) {
						Auction auction = AuctionService.auctionmodel.get(auctionId);
						if(auction != null){
							out.println(auction.toString());
						}else{
							out.println(auctionId + " $$tombstone$$");
						}
					}
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}else{
				return new AuctionEditState(retrieved,auctionSiteList);
			}
		}catch(Exception e){
			_search = input;
			if (_search.isEmpty()) {

			} else {
				return new SearchResultsState(_search, _UserName,
						auctionSiteList);
			}
		}
		
			
		return new UserHomeState(_UserName, auctionSiteList);
	}

	@Override
	public String toString() {
		return _UserName;
	}
}
