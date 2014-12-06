package examples.weekeight;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	public static void main(String[] args) throws ClassNotFoundException {
		String serverHostname = new String("127.0.0.1");

		if (args.length > 0){
			serverHostname = args[0];
			System.out.println("Attemping to connect to host " + serverHostname
					+ " on port 10007.");			
		}
		
		try (Socket socket = new Socket("localhost", 30000);) {
					
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
			
			//Send object to server
			Food f = new Food(12, "Manga");
			objectOutputStream.writeObject(f);
			objectOutputStream.flush();
			
			//check response from server
			BufferedReader inRead = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String serverResponse = inRead.readLine();
			
			if(serverResponse.equals("OBJECT RECEIVED")){
				System.out.println("Server received my object.");
			}
			
			//objectinputstream code goes here
			

			objectOutputStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// open up a socket to server
		// send some kind of request from input stream
		// read the response from the server
	}
}
