import java.util.*;

public class GameBoard {
	private GridBox[] boxes = new GridBox[100];;
	GameBoard() {
		for(int i = 1; i <= 100; i++) {
			boxes[i] = new GridBox(i);
		}
		List<BoardPair> pairs = new ArrayList<BoardPair>();
		pairs.add(new BoardPair("ladder", boxes[1], boxes[38]));
		pairs.add(new BoardPair("ladder", boxes[4], boxes[14]));
		pairs.add(new BoardPair("ladder", boxes[9], boxes[31]));
		pairs.add(new BoardPair("ladder", boxes[28], boxes[84]));
		pairs.add(new BoardPair("ladder", boxes[21], boxes[42]));
		pairs.add(new BoardPair("ladder", boxes[36], boxes[44]));
		pairs.add(new BoardPair("ladder", boxes[51], boxes[67]));
		pairs.add(new BoardPair("ladder", boxes[80], boxes[100]));
		pairs.add(new BoardPair("ladder", boxes[71], boxes[91]));
		pairs.add(new BoardPair("snake", boxes[6], boxes[16]));
		pairs.add(new BoardPair("snake", boxes[11], boxes[49]));
		pairs.add(new BoardPair("snake", boxes[19], boxes[62]));
		pairs.add(new BoardPair("snake", boxes[24], boxes[87]));
		pairs.add(new BoardPair("snake", boxes[26], boxes[48]));
		pairs.add(new BoardPair("snake", boxes[53], boxes[56]));
		pairs.add(new BoardPair("snake", boxes[60], boxes[64]));
		pairs.add(new BoardPair("snake", boxes[73], boxes[93]));
		pairs.add(new BoardPair("snake", boxes[75], boxes[95]));
		pairs.add(new BoardPair("snake", boxes[78], boxes[98]));
		boxes[0].hasP1 = true;
		boxes[0].hasP2 = true;
		boxes[0].hasP3 = true;
	}
}
