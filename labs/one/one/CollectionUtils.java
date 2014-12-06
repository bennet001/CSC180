package labs.one.one;

import java.util.Collection;

public class CollectionUtils {
//	public static void main(String[] args) {
//		ArrayList names = new ArrayList();
//		names.add(null);
//		names.add(35);
//		names.add("Am");
//		names.add("Am");
//		names.add("brad");
//		System.out.println(cardinality("Am", null));
//		names.add("Kyle");
//		names.add(null);
//		names.add("Kyle");
//		names.add(100);
//		names.add(100);
//		names.add(.100);
//		names.add(0.1);
//		names.add(.1);
//		System.out.println(cardinality("Kyle", names));
//		System.out.println(cardinality(100, names));
//		System.out.println(cardinality(.1, names));
//		System.out.println(cardinality(null, names));
//	}

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
}
