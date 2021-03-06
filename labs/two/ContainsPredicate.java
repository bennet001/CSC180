package lab.two;

public class ContainsPredicate<T> implements Predicate<T> {
	Object input = null;
	public ContainsPredicate(T provided){
		input = provided;
	}
	
	@Override
	public boolean evaluate(T t) {
		return t.toString().contains(input.toString());
	}
	@Override
	public void setFirstNeed(Predicate firstNeed) {	
	}

	@Override
	public void setSecondNeed(Predicate secondNeed) {	
	}
}
