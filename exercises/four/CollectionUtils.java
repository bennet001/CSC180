package exercises.four;

import java.util.ArrayList;
import java.util.Collection;

public class CollectionUtils {
	public static int cardinality(Object obj, Collection<?> coll) {
		int counter = 0;
		if (obj != null && coll != null) {
			for (Object object : coll) {
				if (object!=null && object.equals(obj)) {
					counter++;
				}
			}
			return counter;
		}else{
			System.out.print("Provided a null in either obj or collection parameter ");
			return counter;
		}
	}
	public <T> Collection<T> filter(Collection<T> providedCollection, Predicate<T> providedPredicate){
		final Collection<T> passeditems = new ArrayList<T>();
		for (T t : providedCollection) {
			if (providedPredicate.evaluate(t)) {
				passeditems.add(t);
			}
		}
		return passeditems;
	}
}