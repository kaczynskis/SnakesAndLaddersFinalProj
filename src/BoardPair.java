/*
 * This class constructs pairs of GridBoxes connected by either snakes or ladders.
 * It contains a method to return the location to move to upon landing on a top or bottom
 * of a snake or ladder.
 */
public class BoardPair {
	private String type;
	private GridBox bottom, top;
	private int newLocation;
	BoardPair(String type, GridBox bottom, GridBox top) {
		this.type = type;
		this.bottom = bottom;
		this.top = top;
	}
	public GridBox getBottom() {
		return bottom;
	}
	public GridBox getTop() {
		return top;
	}
	public int move() {
		if(type.equalsIgnoreCase("ladder")) {
			newLocation = top.getBoxNum();
		}
		else if(type.equalsIgnoreCase("snake")) {
			newLocation = bottom.getBoxNum();
		}
		else {
		}
		return newLocation;
	}
}
