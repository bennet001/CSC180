package exercises.six;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexPractice {

	public RegexPractice() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args){
		RegexPractice use = new RegexPractice();
		System.out.println(use.exttractNumbers("3 + 2 / 4.0 * 1 ^ 17.34"));
	}
	
	public String exttractNumbers(String input){
		//[*\d]?[0-9][.*]\d*|[0-9]*
		String regex = "[*\\d]?[0-9][.*]\\d*|[0-9]*";
		Pattern pattern = 
				Pattern.compile(regex);

		Matcher matcher = 
				pattern.matcher(input);
		return matcher.toString();
	}
//	public String[] extractOperators(String input){
//		//[+/*^-]
//		String regex = "[+/*^-]";
//	}
	
}
