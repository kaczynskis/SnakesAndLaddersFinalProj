import java.util.*;

public class GameBoard {
	private GridBox[] boxes = new GridBox[100];
	GameBoard() {
		for(int i = 1; i <= 100; i++) {
			boxes[i] = new GridBox(i);
		}
		List<BoardPair> pairs = new ArrayList<BoardPair>();
		pairs.add(new BoardPair("ladder", boxes[1], boxes[38]));
		pairs.add(new BoardPair("ladder", boxes[4], boxes[14]));
		pairs.add(new BoardPair("ladder", boxes[9], boxes[31]));
		
	}
}
