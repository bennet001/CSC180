package examples.weekeight;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public Server() {
		try (ServerSocket ss = new ServerSocket(300);) {
			while (true) {
				try {
					Socket s = ss.accept();
					InputStream is = s.getInputStream();
					OutputStream os = s.getOutputStream();

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	public static void main(String[] args) {

		try (ServerSocket ss = new ServerSocket(30000)) {
			FoodService foodService = new FoodService();
			Socket socket = ss.accept();
			
			PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);

			BufferedReader inRead = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			ObjectInputStream inObject = new ObjectInputStream(socket.getInputStream());

			Food inputFood = (Food) inObject.readObject();
			
			printWriter.println("OBJECT RECEIVED");
			printWriter.flush();
			
			//food service retrive and objectoutputstream code goes
			
			
			printWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	// wait for a request from a client
	// read a request and serialize it to a java request
	// write the
	// Server will implements Server Socket and executes accept to wait for
	// information

}
