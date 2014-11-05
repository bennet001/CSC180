package exercises.five;

import java.text.SimpleDateFormat;

public class FiveDriverExercise {

	public FiveDriverExercise() {
		// TODO Auto-generated constructor stub
		
	}
	public static void main(String[] args){
		SimpleDateFormatConverter test = new SimpleDateFormatConverter();
		System.out.println(test.parse("mm/dd/yyyy"));
		SimpleDateFormat juxtapose = new SimpleDateFormat();
//		System.out.println(test.format(juxtapose));
	}

}
