package examples.weekeight;

import java.util.HashMap;
import java.util.Map;

public class FoodService {
	public Map<Integer, Food> model = new HashMap<Integer, Food>();
	private Integer counter = 0;
	
	public Food create(Food food){
		Integer Id = ++counter;
		model.put(Id, new Food(Id, food.getName()));
		return retrive(Id);
	}
	public Food retrive(Integer Id){
		return model.get(Id);
	}
	
	public Food update(Food food){
		model.put(food.getId(), food);
		return retrive(food.getId());
	}
	
	public boolean delete(Integer Id){
		model.remove(Id);
		return model.get(Id) == null?true:false;
	}
}
