package exercises.five;

import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Mafia {
	
	public Mafia() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args){
		SimpleDateFormatConverter changedate = new SimpleDateFormatConverter(new SimpleDateFormat("dd/MMM/YYYY"), new SimpleDateFormat("dd/MMM/Y"));
		System.out.println("Please provide Birthday information. DD/MM/YYYY");
		Scanner scan = new Scanner(System.in);
		Date input = new Date(scan.nextLine());
		System.out.println(changedate.format(input));
		System.out.println("Please provide your Social Security number.");
		String number = scan.nextLine();
		System.out.printf("%s-%s-%s",number.substring(0, 3),number.substring(3, 5),number.substring(5, 8));
		System.out.println("Please enter the amount of money in your bank account.");
		NumberFormat dollars = NumberFormat.getCurrencyInstance();
		number = scan.nextLine();
		try {
			System.out.println(dollars.parse(number));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String stream(String input){
		input.replace("Cat", "Dog");
		return input;
	}
}
