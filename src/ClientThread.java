import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.*;
import java.util.Scanner;

//public class ClientThread extends Thread{
//	private DiceRoller die = new DiceRoller();
//	private static Socket clientSocket;
//	private static int currentLocation;
//	private static DataOutputStream dos;
//	private static DataInputStream dis;
//	private static Socket socket;
//	
//	ClientThread(Socket socket) {
//		this.socket = socket;
//		currentLocation = 0;
//	}
//	
//	public Socket getSocket() {
//		return socket;
//	}
//	
//	@Override
//	public void run() {
//		try {
//			dos.writeUTF("running");
//		}
//		catch(IOException e) {
//			//e.printStackTrace();
//		}
//	}
//	
//	public void move(DataOutputStream os) {
//		try {
//			os.writeUTF(Integer.toString(die.roll()));
//			os.flush();
//			System.out.println(currentLocation);
//		}
//		catch(IOException e) {
//			//e.printStackTrace();
//		}
//	}
//	
//	public int getCurrentLocation() {
//		return currentLocation;
//	}
//	
//	public static void main(String[] args) {
//		int portNumber = 1234;
//		String host = "localhost";
//		try {
//			clientSocket = new Socket(host, portNumber);
//	        dos = new DataOutputStream(clientSocket.getOutputStream());
//		    dis = new DataInputStream(clientSocket.getInputStream());
//	    } 
//		catch (UnknownHostException e) {
//		      System.err.println("unknown host: " + host);
//		} 
//		catch (IOException e) {
//		      System.err.println("Couldn't connect to host: "
//		          + host);
//	    }
//	}
	public class ClientThread {
	  String address, name;
	  Scanner in;
	  PrintWriter out;
	  public ClientThread(String address) {
		  this.address = address;
	  }
	  private void start() throws IOException {
        try {
            Socket socket = new Socket(address, 1234);
            Scanner consoleInput = new Scanner(System.in);
            in = new Scanner(socket.getInputStream());
            out = new PrintWriter(socket.getOutputStream(), true);
            // Submit screen name
            while (in.hasNextLine()) {
                String line = in.nextLine();
                if (line.startsWith("SUBMIT_NAME")) {
                	System.out.println("Enter your name:");
                	name = consoleInput.nextLine();
                    out.println(name);
                } else if (line.startsWith("NAME_ACCEPTED")) {
                    System.out.printf("Hello %s! If you ever want to quit, type {quit} to exit.%n", line.substring(13));
                    break;
                }
            }
            
            // Start sending thread
            SendHandler sendHandler = new SendHandler(consoleInput, out);
            Thread sendingThread = new Thread(sendHandler);
            sendingThread.start();
            
            // Start receiving thread
            ReadHandler readHandler = new ReadHandler(name, consoleInput, in);
            Thread receivingThread = new Thread(readHandler);
            receivingThread.start();
            
        } finally {
        }
    }
	  private DiceRoller die = new DiceRoller();
	  private static int currentLocation;
	  public void move(DataOutputStream os) {
			try {
				os.writeUTF(Integer.toString(die.roll()));
				os.flush();
				System.out.println(currentLocation);
			}
			catch(IOException e) {
				//e.printStackTrace();
			}
		}

    public static void main(String[] args) throws Exception {
        ClientThread client = new ClientThread("localhost");
        client.start();
    }
}

