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
		tennis.score(tennis.one);
		Assert.assertEquals(tennis.getScore(), "15-0");
	}
	
	@Test
	public void playerOneSecondScore() {
		Tennis tennis = new Tennis();
		tennis.score(tennis.one);
		tennis.score(tennis.one);
		Assert.assertEquals(tennis.getScore(), "30-0");
	}
}
