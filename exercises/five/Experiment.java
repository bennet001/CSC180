package exercises.five;

public class Experiment {
	public static void main(String[] args){
		String animal = "Red dog";
		System.out.println(animal.replaceFirst("cat", "Dog"));
		System.out.println(animal.replaceFirst("[\\w*]", "cat"));
		System.out.println(animal.replaceAll("[*a-z]", "Dog"));
		System.out.println(animal.replaceAll("[\\w*]", "Dog"));
		System.out.println(animal.replaceAll("(\\w*)\\s*(\\w*)", "$2 $1"));
		String numbers = "123-45-678";
		System.out.println(numbers.replaceAll("(\\d(3))[\\W]?(\\d(2))[\\W]?(\\d(3))", "$3 $2 $1"));
	}
}
