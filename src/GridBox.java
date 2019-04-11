/*
 * This class constructs GridBox objects and contains a method to return the number
 * of the box so that that information can be visible to other classes without risk 
 */
public class GridBox {
	private int boxNum;
	public boolean hasP1, hasP2, hasP3;
	GridBox(int boxNum) {
		this.boxNum = boxNum;
		hasP1 = false;
		hasP2 = false;
		hasP3 = false;
	}
	public int getBoxNum() {
		return boxNum;
	}
}
