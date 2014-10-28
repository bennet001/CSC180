package lab.two.one;

public interface Predicate<T> {
	boolean evaluate(T t);
	public void setFirstNeed(Predicate firstNeed);
	public void setSecondNeed(Predicate secondNeed);
}
