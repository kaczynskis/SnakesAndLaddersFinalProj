import java.io.IOException;
import java.net.*;

public class ClientThread extends Thread{
	private Socket socket;
	ClientThread(Socket socket) {
		this.socket = socket;
	}
	public void run() {
		try {
			
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
}
