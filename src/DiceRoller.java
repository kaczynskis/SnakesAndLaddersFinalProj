
import java.util.*;

public class DiceRoller {
	public static int roll() {
		Random rand = new Random();
		double result = rand.next() * 6;
		int finalResult = int(result);
		return finalResult;
	}

}
