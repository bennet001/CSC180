package exercises.four;

import exercises.four.auction.Auction;

public class ContainsPredicate implements Predicate<Auction> {
	Object input = null;
	public ContainsPredicate(Object provided){
		input = provided;
	}
	
	@Override
	public boolean evaluate(Auction t) {
		return t.getClass() == input.getClass() && t.toString().contains(input.toString());
	}

}
