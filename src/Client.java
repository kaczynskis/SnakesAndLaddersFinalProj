import java.util.*;
import java.lang.*;
import java.net.Socket;
import java.io.*;

public class Client {
	//connect to server
	public static void main(String[] args) {
		while(true) {
			try {
				Socket s = new Socket("localhost", 1234);
				DataOutputStream out = new DataOutputStream(s.getOutputStream());
				System.out.println("connected");
			}
			catch(IOException e) {
				e.printStackTrace();
			}
			System.out.println(DiceRoller.roll());
		}
	}
}
