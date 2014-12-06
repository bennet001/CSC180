package examples;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CollectionUtils {
	public <T, K> Collection<T> Transform (Collection<K> coll, Transformer<K,T> t){
		List<T> trans = new ArrayList<T>();
		for (K k : coll) {
			trans.add(t.Transform(k));
		}
		return trans;
		
	}
}
