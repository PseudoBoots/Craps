import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class CrapsTest {

	@Test
	public void test() {
		Craps craps = new Craps();
		int toTest;
		
		for(int i = 0; i < 100000; i++)
		{
			toTest = craps.rollDie();
			Assert.assertTrue(toTest > 0 && toTest < 7);
		}
	}

}
