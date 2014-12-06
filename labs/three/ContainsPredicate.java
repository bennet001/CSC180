package labs.three;

public class ContainsPredicate<T> implements Predicate<T> {
	Object input = null;
	public ContainsPredicate(T provided){
		input = provided;
	}
	
	@Override
	public boolean evaluate(T t) {
		boolean eval = t.toString().contains(input.toString());
		return eval;
	}
	@SuppressWarnings("rawtypes")
	@Override
	public void setFirstNeed(Predicate firstNeed) {	
	}

	@SuppressWarnings("rawtypes")
	@Override
	public void setSecondNeed(Predicate secondNeed) {	
	}
}
