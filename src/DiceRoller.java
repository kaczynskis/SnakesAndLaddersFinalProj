
import java.util.*;

public class DiceRoller {
	/*public static void main(String[] args) {
		System.out.println(DiceRoller.roll());
	}*/
	public static int roll() {
		Random rand = new Random();
		double result = rand.nextDouble() * 6;
		int finalResult = (int)result;
		return finalResult;
	}

}
