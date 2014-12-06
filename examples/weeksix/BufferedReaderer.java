package examples.weeksix;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class BufferedReaderer{
	public static void main(String[] args) throws FileNotFoundException{
		File f = new File("D:/JavaLabChess/pawn");
		//InputStream m =  new FileInputStream(f);
		
		try (BufferedReader file = new BufferedReader(new InputStreamReader(new FileInputStream(f)))){
			System.out.println(file.readLine());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try(Scanner scanner = new Scanner(f)){
			String line = scanner.nextLine();
			System.getenv("User name goes here");
			System.out.println(line);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}