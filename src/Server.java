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
	public static Socket s;
	//public static Socket s;
	GameBoard game = new GameBoard();
	static DataInputStream dis;
	static DataOutputStream dos;
	
	//Queue<ClientThread> players = new LinkedList<ClientThread>();
	static ArrayList<ClientThread> players = new ArrayList<ClientThread>();
	
	public static void main(String args[]) throws IOException, NullPointerException{
		ss = new ServerSocket(1234);
		while (players.size() < 3) {
			System.out.println("waiting for players...");
			s = ss.accept();
			players.add(new ClientThread(s));
			//String input = dis.readUTF();
		}
		dis = new DataInputStream(s.getInputStream());
		dos = new DataOutputStream(s.getOutputStream());
		while(p1Loc != 100 && p2Loc != 100 && p3Loc != 100) {
			for(int i = 0; i < 3; i++) {
				players.get(i).move(dos);
				//run updateLocation method
			}
		}
	}
	public int updateLocation(int numRolled, int currentLocation) {
		int newLocation = currentLocation + numRolled;
		//check to see if gridbox has either snake or ladder, update newLocation accordingly
		return newLocation;
	}
	

}
