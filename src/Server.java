import java.net.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javafx.application.Application;

import java.io.*;

public class Server {
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
	
	static Vector<Client> arr = new Vector<>();
	static int i = 0;
	
	Queue<Player> players = new LinkedList<Player>();
	
	public static void main(String args[]) throws IOException {
		
		ServerSocket ss = new ServerSocket(1234);
		Socket s;
		
		while (Client.size < 3) {
			s = ss.accept();
			
			DataInputStream dis = new DataInputStream(s.getInputStream());
			DataInputStream dos = new DataInputStream(s.getOutputStream());
			
			Client match = new Client(s, "player" + i, dis, dos);
			Thread t = new Thread(match);
			System.out.println("New player added: " + s);
			
			arr.add(match);
			t.start();
			i++;
		}
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
	public void getCurrentLocation() {
		
	}
	public void move(int roll) {
		
			try {
				ServerSocket serverS = new ServerSocket(1234);
				Socket s = serverS.accept();
				DataInputStream in = new DataInputStream(s.getInputStream());
			}
			catch(IOException e) {
				e.printStackTrace();
			}
	}

}
