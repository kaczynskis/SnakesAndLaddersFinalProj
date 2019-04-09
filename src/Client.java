import java.util.*;
import java.lang.*;
import java.net.*;
import java.io.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

<<<<<<< HEAD
public class Client extends Application {
=======
public class Client {
>>>>>>> branch 'master' of https://github.com/kaczynskis/SnakesAndLaddersFinalProj.git
	private int currentLocation;
	//connect to server
	public static void main(String[] args) {
		try {
			Socket s = new Socket("localhost", 1234);
			DataOutputStream out = new DataOutputStream(s.getOutputStream());
			Scanner in = new Scanner(System.in);
			System.out.print("roll die? (y/n)");
			String response = in.nextLine();
			if(response.equalsIgnoreCase("y")) {
				out.writeUTF(response);
			}
			else {
			}
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
		
}

