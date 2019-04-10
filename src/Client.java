import java.util.*;
import java.lang.*;
import java.net.*;
import java.io.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Client {
	private int currentLocation;
	//connect to server
	public static void main(String[] args) {
		try {
			Socket s = new Socket("localhost", 1234);
			DataOutputStream out = new DataOutputStream(s.getOutputStream());
			DataInputStream in = new DataInputStream(s.getInputStream());
			Scanner scanIn = new Scanner(System.in);
			System.out.print("press 'r' to roll die");
			String response = scanIn.nextLine();
			if(response.equals("r")) {
				int roll = DiceRoller.roll();
				String rollString = Integer.toString(roll);
				out.writeUTF(rollString);
			}
			else {
				System.out.print("press 'r' to roll die");
			}
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
		
}

