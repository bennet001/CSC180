package labs.two.one;

public class ContainsPredicate<T> implements Predicate<T> {
	Object input = null;
	public ContainsPredicate(T provided){
		input = provided;
	}
	
	@Override
	public boolean evaluate(T t) {
		return t.toString().contains(input.toString());
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
