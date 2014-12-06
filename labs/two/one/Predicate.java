package labs.two.one;

public interface Predicate<T> {
	boolean evaluate(T t);
	@SuppressWarnings("rawtypes")
	public void setFirstNeed(Predicate firstNeed);
	@SuppressWarnings("rawtypes")
	public void setSecondNeed(Predicate secondNeed);
}
