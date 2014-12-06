package examples.weekeight;

import java.io.Serializable;

public class Food implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final int serial;
	private final String productName;
	public Food(Integer id, Object name) {
		// TODO Auto-generated constructor stub
		serial = id;
		productName = name.toString();
	}

	public Integer getId() {
		int copy = serial;
		return copy;
	}

	public Object getName() {
		String name = productName;
		return name;
	}

}
