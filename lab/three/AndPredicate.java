package lab.two.one;

import lab.two.two.Auction;


public class AndPredicate implements Predicate<Auction> {
	Predicate<Auction> firstPossible;
	Predicate<Auction> secondPossible;
	public AndPredicate(){
		
	}
	public AndPredicate(Predicate<Auction> initial, Predicate<Auction> compare) {
		// TODO Auto-generated constructor stub
		firstPossible = initial;
		secondPossible = compare;
	}

	@Override
	public boolean evaluate(Auction t) {
		// TODO Auto-generated method stub
		return firstPossible.evaluate(t) && secondPossible.evaluate(t);
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
