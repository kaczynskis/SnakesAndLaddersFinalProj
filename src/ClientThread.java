import java.io.DataOutputStream;
import java.io.IOException;
import java.net.*;

public class ClientThread extends Thread{
	private DiceRoller die = new DiceRoller();
	private Socket socket;
	public int currentLocation;
	ClientThread(Socket socket) {
		this.socket = socket;
		currentLocation = 0;
	}
	@Override
	public void run() {
		System.out.println("running");
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
}
