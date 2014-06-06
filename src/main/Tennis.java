package main;

public class Tennis {
	public Player one;
	public Player two;

	public enum Score {
		ZERO, FIFTEEN, THIRTY, FOURTY, DOUCE, ADVANTAGE, WINS
	}

	class Player {
		int playerNumber;
		Score currentScore;

		public Score getCurrentScore() {
			return currentScore;
		}

		Player(int number) {
			playerNumber = number;
			currentScore = Score.ZERO;
		}

		public void addPoints() {
			if (currentScore == Score.ZERO)
				currentScore = Score.FIFTEEN;
			else if (currentScore == Score.FIFTEEN)
				currentScore = Score.THIRTY;
			else if (currentScore == Score.THIRTY)
				currentScore = Score.FOURTY;
			else if (currentScore == Score.FOURTY)
				currentScore = Score.WINS;
		}
	}

	public Tennis() {
		one = new Player(1);
		two = new Player(2);
	}

	public void score(int playerNumber) {
		if (playerNumber == 1) {
			one.addPoints();
		} else if (playerNumber == 2) {
			two.addPoints();
		} else
			throw new IllegalArgumentException(
					"Only \"1\" or \"2\" is allowed!");
	}

	public String getScore() {
		if (one.getCurrentScore() == Score.FOURTY
				&& two.getCurrentScore() == Score.FOURTY) {
			return Score.DOUCE.toString();
		}
		return one.getCurrentScore() + "-" + two.getCurrentScore();

	}
}
