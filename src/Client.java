import java.util.*;
import java.lang.*;
import java.net.Socket;
import java.io.*;

public class Client {
	//connect to server
	public static void main(String[] args) {
		System.out.println(DiceRoller.roll());
		/*while(true) {
			try {
				Socket s = new Socket("localhost", 1234);
				System.out.println(DiceRoller.roll());
			}
			catch(IOException e) {
				e.printStackTrace();
			}
		}*/
	}
}
