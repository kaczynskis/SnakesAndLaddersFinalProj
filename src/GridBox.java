/*
 * This class constructs GridBox objects and contains a method to return the number
 * of the box so that that information can be visible to other classes without risk 
 */
public class GridBox {
	private int boxNum;
	GridBox(int boxNum) {
		this.boxNum = boxNum;
	}
	public int getBoxNum() {
		return boxNum;
	}
}
