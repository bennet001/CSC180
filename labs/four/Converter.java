package labs.four;

public interface Converter<T> {
	T parse(String fromString);
	String format(T fromObject);
}
