package examples.weeksix;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileBurrferedReaderandWriter{
	private static void readLine(){
		File file = new File("FileBufferedReaderandWriter.java");
		StringBuilder sb = new StringBuilder();
		try(BufferedReader render = new BufferedReader(new FileReader(file))){
			String line = null;
			while((line = render.readLine()) != null){//do not use render.ready() because the os my not have information avaliable but it is ready to access and vice versa the file might not be ready but there is information
				sb.append(line);
				sb.append("\n");
				line = render.readLine();
			}
		} catch (IOException e){
			e.printStackTrace();;
		}
		String entireFile = sb.toString();
		entireFile = entireFile.replaceAll("readLine", "readLine2");
		try(BufferedWriter writer = new BufferedWriter(new FileWriter(file))){
			Scanner scan = new Scanner(entireFile);
			while(scan.hasNext()){
				String line = scan.nextLine();
				line.replaceAll("readLine","readLine2");
				writer.write(line);
				writer.newLine();
			}
			scan.close();
		} catch(IOException e){
			e.printStackTrace();;
		}
	}
	public static void main(){
		readLine();
	}
}