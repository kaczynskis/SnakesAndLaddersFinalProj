import java.util.*;
import java.lang.*;
import java.net.*;
import java.io.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Client /*extends Application*/ {
	private Socket socket;
	private String string;
	private DataInputStream dis;
	private DataOutputStream dos;
	
	public Client(Socket socket, String string, DataInputStream dis, DataOutputStream dos) {
		this.socket = socket;
		this.string = string;
		this.dis = dis;
		this.dos = dos;
	}

	private int currentLocation;
	//connect to server
	public static void main(String[] args) {
		try {
			Socket s = new Socket("localhost", 1234);
			DataOutputStream out = new DataOutputStream(s.getOutputStream());
			DataInputStream in = new DataInputStream(s.getInputStream());
			/*Scanner scanIn = new Scanner(System.in);
			System.out.print("press 'r' to roll die");
			String response = scanIn.nextLine();
			if(response.equals("r")) {
				int roll = roller.roll();
				String rollString = Integer.toString(roll);
				out.writeUTF(rollString);
			}*/
//			Scanner in = new Scanner(System.in);
//			System.out.print("roll die? (y/n)");
//			String response = in.nextLine();
//			if(response.equalsIgnoreCase("y")) {
//				out.writeUTF(response);
//			}// continue on for 
//			else {
//				System.out.print("press 'r' to roll die");
//			}
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	public Socket getSocket() {
		return socket;
	}
	public void 
}
