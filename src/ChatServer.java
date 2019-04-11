import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Set;
import java.util.HashSet;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * A multithreaded chat room server. When a client connects the server requests
 * a screen name by sending the client the text "SUBMIT_NAME", and keeps
 * requesting a name until a unique one is received. After a client submits a
 * unique name, the server acknowledges with "NAME_ACCEPTED". Then all messages
 * from that client will be broadcast to all other clients that have submitted a
 * unique screen name. The broadcast messages are prefixed with "MESSAGE".
 *
 * This is just a teaching example so it can be enhanced in many ways, e.g.,
 * better logging. Another is to accept a lot of fun commands, like Slack.
 */
public class ChatServer {

	// All client names, so we can check for duplicates upon registration.
	private static Set<String> names = new HashSet<>();
	//create a new GameBoard
	//private static GameBoard game = new GameBoard();
	// The set of all the print writers for all the clients, used for broadcast.
	private static Set<PrintWriter> writers = new HashSet<>();

	public static void main(String[] args) throws Exception {
		System.out.println("The game server is running...");
		ExecutorService pool = Executors.newFixedThreadPool(500); //explain ?
		try (ServerSocket listener = new ServerSocket(1234)) {
			while (true) {
				pool.execute(new Handler(listener.accept()));
			}
		}
	}

	/**
	 * The client handler task.
	 */
	private static class Handler implements Runnable {
		private String name;
		private Socket socket;
		private Scanner in;
		private PrintWriter out;

		/**
		 * Constructs a handler thread, squirreling away the socket. All the interesting
		 * work is done in the run method. Remember the constructor is called from the
		 * server's main method, so this has to be as short as possible.
		 */
		public Handler(Socket socket) {
			this.socket = socket;
		}

		/**
		 * Services this thread's client by repeatedly requesting a screen name until a
		 * unique one has been submitted, then acknowledges the name and registers the
		 * output stream for the client in a global set, then repeatedly gets inputs and
		 * broadcasts them.
		 */
		public void run() {
			try {
				in = new Scanner(socket.getInputStream());
				out = new PrintWriter(socket.getOutputStream(), true);

				// Keep requesting a name until we get a unique one.
				while (true) {
					out.println("SUBMIT_NAME");
					name = in.nextLine();
					if (name == null) {
						return;
					}
					synchronized (names) {
						if (!name.isEmpty() && !names.contains(name)) {
							names.add(name);
							break;
						}
					}
				}

				// Now that a successful name has been chosen, add the socket's print writer
				// to the set of all writers so this client can receive broadcast messages.
				// But BEFORE THAT, let everyone else know that the new person has joined!
				out.println("NAME_ACCEPTED " + name);
				for (PrintWriter writer : writers) {
					writer.println("MESSAGE " + name + " has joined");
				}
				writers.add(out);

				//method to say "roll die" ?
				
				// Accept messages from this client and broadcast them.
				int spacesMoved;
				//this loop handles input and broadcasting for whole game
				while (true) { // replace true with exit condition (a player is at GridBox 100)
					String input = in.nextLine();
					for(PrintWriter writer: writers) {
						writer.println("ROLL_DICE");
					}
					//client sends back position
					//update position by checking if snake or ladder
					if (input.toLowerCase().startsWith("r")) {
						spacesMoved = DiceRoller.roll();
						//update location
						//check what player it is, then update game.boxes.hasPx accordingly
						for (PrintWriter writer : writers) {
							writer.println("MESSAGE " + name + ": " + spacesMoved); //replace spacesMoved with location
						}
					}
				}
			} catch (Exception e) {
				System.out.println(e);
			} finally {
				if (out != null) {
					writers.remove(out);
				}
				if (name != null) {
					System.out.println(name + " is leaving");
					names.remove(name);
					for (PrintWriter writer : writers) {
						writer.println("MESSAGE " + name + " has left");
					}
				}
				try {
					socket.close();
				} catch (IOException e) {
				}
			}
		}
	}
}
