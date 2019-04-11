import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * A simple client for the chat server. 
 * 
 * The client follows the following Chat Protocol. When the server sends "SUBMIT_NAME" the
 * client replies with the desired screen name. The server will keep sending "SUBMIT_NAME"
 * requests as long as the client submits screen names that are already in use. When the
 * server sends a line beginning with "NAME_ACCEPTED" the client is now allowed to start
 * sending the server arbitrary strings to be broadcast to all chatters connected to the
 * server. When the server sends a line beginning with "MESSAGE" then all characters
 * following this string should be displayed in its message area.
 */
public class ChatClient {

    String serverAddress;
    String name;
    Scanner in;
    PrintWriter out;

    /**
     * Constructs the client with the serverAddress
     */
    public ChatClient(String serverAddress) {
        this.serverAddress = serverAddress;        
    }

    private void start() throws IOException {
        try {
            Socket socket = new Socket(serverAddress, 1234);
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
            SendingHandler sendingHandler = new SendingHandler(consoleInput, out);
            Thread sendingThread = new Thread(sendingHandler);
            sendingThread.start();
            
            // Start receiving thread
            ReceivingHandler receivingHandler = new ReceivingHandler(name, consoleInput, in);
            Thread receivingThread = new Thread(receivingHandler);
            receivingThread.start();
            
        } finally {
        }
    }

    public static void main(String[] args) throws Exception {
        ChatClient client = new ChatClient("localhost");
        client.start();
    }
    
    class SendingHandler implements Runnable {
        Scanner consoleInput;
    	PrintWriter out;
    	SendingHandler(Scanner consoleInput, PrintWriter out){
    		this.consoleInput = consoleInput;
    		this.out = out;
    	}

		@Override
		//console input
		public void run() {
			String msg = "";
			while (!msg.equals("{quit}")) {
				msg = consoleInput.nextLine();
				out.println(msg);
			}
		}
    }
    
    class ReceivingHandler implements Runnable {
    	String name;
        Scanner consoleInput;
        Scanner in;
        ReceivingHandler(String name, Scanner consoleInput, Scanner in){
        	this.name = name;
    		this.consoleInput = consoleInput;
    		this.in = in;
    	}

		@Override
		public void run() {
            while (in.hasNextLine()) {
                String line = in.nextLine();
                if (line.startsWith("MESSAGE") && !line.contains(name + ":")) {
                    System.out.println(line.substring(8));
                }
                else if (line.startsWith("ROLL_DICE")) {
    				
                }
            }
		}
    }
}