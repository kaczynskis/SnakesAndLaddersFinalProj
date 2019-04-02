import java.net.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.io.*;

public class Server {
	private static int playerNum;
	
	private ServerSocket serverSocket;
	
	public Server() throws IOException {
		serverSocket = new ServerSocket(1234);
	}
	
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
		}
	
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
	public void getCurrentLocation() {
		
	}
	public void move(int roll) {
		
		//while(true) {
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
