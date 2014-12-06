package examples;

public interface Transformer<K,T> {
	public T Transform(K obj);
}
