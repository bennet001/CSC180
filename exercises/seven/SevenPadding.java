package exercises.seven;

public class SevenPadding {
	public String pad(Object obj, int len){
		StringBuilder input = new StringBuilder();
		if(obj != null){
			input.append(obj.toString());
		}
		while(input.length() < len){
			input.append(Character.toString((char)32));
		}
		return input.toString().substring(0,len);
	}
	public <T> T unpad(String str, Class<T> clazz){
		if (clazz.isAssignableFrom(Integer.class)){
			return clazz.cast(Integer.parseInt(str.trim()));
		} else if (clazz.isAssignableFrom(Double.class)){
			return clazz.cast(Double.parseDouble(str.trim()));
		} else if (clazz.isAssignableFrom(Long.class)){
			return clazz.cast(Long.parseLong(str.trim()));
		}
		return clazz.cast(str.trim());
	}
}
