package examples;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractService<T> implements Service<T>{
	protected Map<Integer,T> models = new HashMap<Integer,T>();
	public T create(T g) {
		return null;
	}
	public T retrive(Integer id) {
		return null;
	}
	public T update(Integer id, T g) {
		return null;
	}
	public void delete(Integer id) {
		models.remove(id);
	}
}
