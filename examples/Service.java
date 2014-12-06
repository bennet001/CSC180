package examples;

public interface Service<T> {
	public T create(T g);
	public T retrive(Integer id);
	public T update(Integer id, T g);
	public void delete(Integer id);
}
