package test;

import main.Tennis;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TennisTests {
	@Test
	public void zeroZeroReturnsZeroZero() {
		Tennis tennis = new Tennis();

		Assert.assertEquals(tennis.getScore(), "0-0");
	}

	@Test
	public void playerOneFirstScore() {
		Tennis tennis = new Tennis();
		tennis.score(1);
		Assert.assertEquals(tennis.getScore(), "15-0");
	}

	@Test
	public void playerOneSecondScore() {
		Tennis tennis = new Tennis();
		tennis.score(1);
		tennis.score(1);
		tennis.score(2);
		tennis.score(2);
		Assert.assertEquals(tennis.getScore(), "30-30");
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void wrongPlayerNumberReturnsException() {
		Tennis tennis = new Tennis();
		tennis.score(0);
	}

	@Test
	public void playerOneWin() {
		Tennis tennis = new Tennis();
		for (int i = 0; i < 4; i++) {
			tennis.score(1);
		}
		Assert.assertEquals(tennis.getScore(), "Win-0");
	}

	@Test
	public void playerTwoWin() {
		Tennis tennis = new Tennis();
		for (int i = 0; i < 4; i++) {
			tennis.score(2);
		}
		Assert.assertEquals(tennis.getScore(), "0-Win");
	}

	@Test
	public void deuce() {
		Tennis tennis = new Tennis();
		for (int i = 0; i < 4; i++) {
			tennis.score(1);
			tennis.score(2);
		}
		Assert.assertEquals(tennis.getScore(), "Deuce");
	}

	@Test
	public void advantage() {
		Tennis tennis = new Tennis();
		for (int i = 0; i < 3; i++) {
			tennis.score(1);
			tennis.score(2);
		}
		tennis.score(1);
		Assert.assertEquals(tennis.getScore(), "Advantage-");
	}

	@Test
	public void advantagePlayerTwo() {
		Tennis tennis = new Tennis();
		for (int i = 0; i < 3; i++) {
			tennis.score(1);
			tennis.score(2);
		}
		tennis.score(2);
		Assert.assertEquals(tennis.getScore(), "-Advantage");
	}

	@Test
	public void manyDeucesOneWin() {
		Tennis tennis = new Tennis();
		for (int i = 0; i < 7; i++) {
			tennis.score(1);
			tennis.score(2);
		}
		tennis.score(1);
		tennis.score(1);
		tennis.score(1);
		Assert.assertEquals(tennis.getScore(), "Win-");
	}

}
