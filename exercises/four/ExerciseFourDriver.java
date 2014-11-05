package exercises.four;

import exercises.four.auction.InMemoryAuctionService;

public class ExerciseFourDriver {
	public static void main(String[] args){
		InMemoryAuctionService test = new InMemoryAuctionService();
		ContainsPredicate filter = new ContainsPredicate("B");
		test.getClass();
		filter.getClass();
		//test.search(filter, usable);
	}
}
