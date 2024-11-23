package genericUtils;

import java.util.Random;

public class JavaUtility {
	
	public int generateRandomNum(int limit) {
		Random random = new Random();
		return random.nextInt(limit);
	}

}
