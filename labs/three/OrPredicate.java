package labs.three;


public class OrPredicate implements Predicate<Auction> {
	Predicate<Auction> firstPossible;
	Predicate<Auction> secondPossible;
	
	public OrPredicate(){
		
	}
	
	public OrPredicate(Predicate<Auction> firstCompare, Predicate<Auction> secondCompare) {
		// TODO Auto-generated constructor stub
		firstPossible = firstCompare;
		secondPossible = secondCompare;
	}

	@Override
	public boolean evaluate(Auction t) {
		// TODO Auto-generated method stub
		return firstPossible.evaluate(t) || secondPossible.evaluate(t);
	}

	@Override
	public void setFirstNeed(Predicate firstNeed) {
		firstPossible = firstNeed;		
	}

	@Override
	public void setSecondNeed(Predicate secondNeed) {
		secondPossible = secondNeed;		
	}
}
