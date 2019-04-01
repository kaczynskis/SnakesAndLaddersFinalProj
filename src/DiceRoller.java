
import java.util.*;

public class DiceRoller {
	public static int roll() {
		Random rand = new Random();
		double result = (rand.nextDouble() * 6) + 1;
		int finalResult = (int)result;
		return finalResult;
	}

}
