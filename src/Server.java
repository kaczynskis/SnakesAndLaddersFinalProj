import java.net.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javafx.application.Application;

import java.io.*;

public class Server {
	static int p1Loc, p2Loc, p3Loc;
	public static DiceRoller die;
	public static ServerSocket ss;
	//public static Socket s;
	GameBoard game = new GameBoard();
	static DataInputStream dis;
	static DataOutputStream dos;
	/*private static int playerNum;
	
	private ServerSocket serverSocket;
	
	public Server() throws IOException {
		serverSocket = new ServerSocket(1234);
	}
	
	// multi-thread
	public void getClients() throws IOException {
		ExecutorService threads = Executors.newCachedThreadPool();
		try {
			while (!Thread.currentThread().isInterrupted()) {
				Socket clientSocket = serverSocket.accept();
				new Thread().start();
			}
		}
		finally {
			threads.shutdown();
		}
	}
	public void stop() throws IOException {
		serverSocket.close();
	}
	private static class ClientHandler extends Client {
		private final Socket clientSocket;
		public ClientHandler(Socket clientSocket) {
			this.clientSocket = clientSocket;
		}
		public void run() {
			}
	*/	
	
	//static Vector<Client> arr = new Vector<>();
	static int i = 0;
	
	//Queue<ClientThread> players = new LinkedList<ClientThread>();
	static ArrayList<ClientThread> players = new ArrayList<ClientThread>();
	
	public static void main(String args[]) throws IOException, NullPointerException{
		while (true) {
			System.out.println("waiting for players...");
			Socket s = ss.accept();
			players.add(new ClientThread(s));
			dis = new DataInputStream(s.getInputStream());
			dos = new DataOutputStream(s.getOutputStream());
			String input = dis.readUTF();
			while(p1Loc != 100 && p2Loc != 100 && p3Loc != 100) {
				players.get(0).move(dos);
			}
			/*Client match = new Client(s, "player " + i, dis, dos);
			Thread t = new ClientThread(match.getSocket());
			System.out.println("New player added: " + s);
			
			arr.add(match);
			t.start();*/
			//i++;
		}
		
	}
//	public void getCurrentLocation() {
//		
//	}
	

}
