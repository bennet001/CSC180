package midterm;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SpeedDial {
	String input;
	Map<String, String> directory = new HashMap<String,String>();
	public SpeedDial(){
		
	}
	@SuppressWarnings("resource")
	public void prompt(){
		System.out.println("Welcome to Speed Dial v3.14");
		while(true){
			System.out.print(">");
			Scanner scan = new Scanner(System.in);
			input = scan.nextLine();
			execute(input);
		}
	}
	private void execute(String passedInput) {
		// TODO Auto-generated method stub
		String[] parse = passedInput.split("[\\W]");
		if("Save".equalsIgnoreCase(parse[0])){
			save(parse[1],parse[2]);
		}else if ("Dial".equalsIgnoreCase(parse[0])){
			dial(parse[1]);
		}else if ("list".equalsIgnoreCase(parse[0])){
			
		}
	}
	private void dial(String string) {
		// TODO Auto-generated method stub
		if(directory.containsKey(string)){
			directory.get(string);
		} else{
			System.out.println("Sorry I don't recognize" + string);
		}
	}
	private void save(String string, String string2) {
		// TODO Auto-generated method stub
		directory.put(string,string2);
		
	}
}
