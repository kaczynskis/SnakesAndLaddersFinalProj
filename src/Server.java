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
	public static DiceRoller die;
	public static ServerSocket ss;
	public static Socket s;
	GameBoard game = new GameBoard();
	static DataInputStream dis;
	static DataOutputStream dos;
	static int[] locations = new int[3];
	
	public static void main(String args[]) throws IOException, NullPointerException{
		ArrayList<ClientThread> clients = new ArrayList<ClientThread>();
		ss = new ServerSocket(1234);
		int i = 1;
		while(clients.size() < 3) {
			System.out.println("waiting for players...");
			s = ss.accept();
			clients.add(new ClientThread("localhost"));
			System.out.println("Player " + i + " connected.");
			i++;
		}
		dis = new DataInputStream(s.getInputStream());
		dos = new DataOutputStream(s.getOutputStream());
		while(locations[0] != 100 && locations[1] != 100 && locations[2] != 100) {
			for(int j = 0; j < 3; j++) {
				clients.get(j).move(dos);
				//run updateLocation method
			}
			printLocations();
		}
	}
	public int updateLocation(int currentLocation, int numRolled) {
		int newLocation = currentLocation + numRolled;
		for(BoardPair bp:game.pairs) {
			int boxNumBottom = bp.getBottom().getBoxNum();
			int boxNumTop = bp.getTop().getBoxNum();
			if(boxNumBottom == newLocation || boxNumTop == newLocation) {
				newLocation = bp.move();
			}
		}
		return newLocation;
	}
	
	public static void printLocations() {
		System.out.printf("P1: %s	P2: %s	P3: %s\n", locations[0], locations[1], locations[2]);
	}

}
