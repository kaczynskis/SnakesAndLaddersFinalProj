import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.*;

public class ClientThread extends Thread{
	private DiceRoller die = new DiceRoller();
	private static Socket clientSocket;
	private static int currentLocation;
	private static DataOutputStream dos;
	private static DataInputStream dis;
	
	ClientThread(Socket socket) {
		this.socket = socket;
		currentLocation = 0;
	}
	
	@Override
	public void run() {
		try {
			//dos.writeUTF("running");
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void move(DataOutputStream os) {
		try {
			os.writeUTF(Integer.toString(die.roll()));
			System.out.println(currentLocation);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public int getCurrentLocation() {
		return currentLocation;
	}
	
	public static void main(String[] args) {
		int portNumber = 1234;
		String host = "localhost";
		try {
			clientSocket = new Socket(host, portNumber);
	        dos = new DataOutputStream(clientSocket.getOutputStream());
		    dis = new DataInputStream(clientSocket.getInputStream());
	    } 
		catch (UnknownHostException e) {
		      System.err.println("unknown host: " + host);
		} 
		catch (IOException e) {
		      System.err.println("Couldn't connect to host: "
		          + host);
	    }
	}
}
