import java.util.*;
import java.lang.*;
import java.net.*;
import java.io.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Client extends Application{
	private int currentLocation;
	//connect to server
	public static void main(String[] args) {
		try {
			launch(args);
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
		//System.out.println(DiceRoller.roll());
	}
	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
			/**
			 * loads start menu
			 * root is set to main menu fxml file
			 */			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("main_menu.fxml"));
			Parent root = loader.load();
			Scene scene = new Scene(root);
			primaryStage.setTitle("Snakes & Ladders");
			primaryStage.setScene(scene);
			primaryStage.show();

		} catch(Exception e) {
			e.printStackTrace();
		}

		
	}
}
