import java.net.*;
import java.io.*;

public class Server {
	private static int playerNum;
	
	public static void main(String args[]) {
		try {
			ServerSocket ss = new ServerSocket(1234);
			Socket s = ss.accept();
			DataInputStream in = new DataInputStream(s.getInputStream());
			System.out.println(in.readUTF());
			
			GameBoard game = new GameBoard();
			
			ss.close();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}

	/*private Socket socket = null;
	private ServerSocket s = null;
	private DataInputStream stream = null;
	
	public GameServer (int 1234) {
		try {
			System.out.println("");
			s = new ServerSocket(1234);
			System.out.println("" + s);
			System.out.println("");
			socket = s.accept();
			System.out.println("" + socket);
			open();
			
			boolean finish = false;
			
			while (!finish) {
				try {
					String box = stream.readUTF();
					System.out.print(box); // box = box on grid
					finish = box.equals("");
				}
				catch (IOException IOE) {
					finish=true;
				}
			}
		close();
		}
		catch (IOException IOE) {
		}*/

}
