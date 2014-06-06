package test;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import main.Tennis;

public class TennisTests {
	@Test
	public void zeroZeroReturnsZeroZero() {
		Tennis tennis = new Tennis();

		AssertJUnit.assertEquals(tennis.getScore(), "ZERO-ZERO");
	}

	@Test
	public void playerOneFirstScore() {
		Tennis tennis = new Tennis();
		tennis.score(1);
		AssertJUnit.assertEquals(tennis.getScore(), "FIFTEEN-ZERO");
	}

	@Test
	public void playerOneSecondScore() {
		Tennis tennis = new Tennis();
		tennis.score(1);
		tennis.score(1);
		AssertJUnit.assertEquals(tennis.getScore(), "THIRTY-ZERO");
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void wrongPlayerNumberReturnsException() {
		Tennis tennis = new Tennis();
		tennis.score(0);
	}

	@Test
	public void playerOneWins() {
		Tennis tennis = new Tennis();
		for (int i = 0; i < 5; i++) {
			tennis.score(1);
		}
		AssertJUnit.assertEquals(tennis.getScore(), "WINS-ZERO");
	}
	
	@Test
	public void deuce() {
		Tennis tennis = new Tennis();
		for (int i = 0; i < 3; i++) {
			tennis.score(1);
			tennis.score(2);
			System.out.println(tennis.getScore());
		}
		AssertJUnit.assertEquals(tennis.getScore(), "DOUCE");
	}
	
	
}
