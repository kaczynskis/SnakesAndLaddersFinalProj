import java.util.*;
import java.lang.*;
import java.net.Socket;
import java.io.*;

public class Client {
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
		//System.out.println(DiceRoller.roll());
	}
}
