package main;

public class Tennis {
	private int playerOneScore;
	private int playerTwoScore;
	private String[][] Score;
	private String errMsg = "Only \"1\" or \"2\" is allowed!";
	private String gaveOverMsg = "Game is over.";

	public Tennis() {
		Score = new String[2][8];
		initScore();
		playerOneScore = 0;
		playerTwoScore = 0;
	}

	private void initScore() {
		for (int i = 0; i < 2; i++) {
			Score[i][0] = "0";
			Score[i][1] = "15";
			Score[i][2] = "30";
			Score[i][3] = "40";
			Score[i][4] = "Win";
			Score[i][5] = "Advantage";
			Score[i][6] = "Deuce";
			Score[i][7] = "";
		}
	}

	public void score(int player) {
		if (!isGameOver()) {
			switch (player) {
			case 1:
				if (isDeuce())
					setAdvantage(1);
				else if (isAdvantage(2))
					setDeuce();
				else if (isAdvantage(1))
					setWin(1);
				else
					addScore(1);
				break;
			case 2:
				if (isDeuce())
					setAdvantage(2);
				else if (isAdvantage(1))
					setDeuce();
				else if (isAdvantage(2))
					setWin(2);
				else
					addScore(2);
				break;
			default:
				throw new IllegalArgumentException(errMsg);
			}
		} else
			System.out.println(gaveOverMsg);
	}

	public void addScore(int player) {
		switch (player) {
		case 1:
			playerOneScore++;
			break;
		case 2:
			playerTwoScore++;
			break;
		default:
			throw new IllegalArgumentException(errMsg);
		}
	}

	public String getScore() {
		if (isDeuce())
			return "Deuce";
		return Score[0][playerOneScore] + "-" + Score[1][playerTwoScore];
	}

	public boolean isDeuce() {
		return ((playerOneScore == playerTwoScore) && ((playerOneScore == 6) || (playerOneScore == 3)));
	}

	public void setDeuce() {
		playerOneScore = playerTwoScore = 6;
	}

	public boolean isAdvantage(int player) {
		switch (player) {
		case 1:
			return (playerOneScore == 5 && playerTwoScore == 7);
		case 2:
			return (playerOneScore == 7 && playerTwoScore == 5);
		default:
			throw new IllegalArgumentException(errMsg);
		}
	}

	public void setAdvantage(int player) {
		switch (player) {
		case 1:
			playerOneScore = 5;
			playerTwoScore = 7;
			break;
		case 2:
			playerOneScore = 7;
			playerTwoScore = 5;
			break;
		default:
			throw new IllegalArgumentException(errMsg);
		}
	}

	public void setWin(int player) {
		switch (player) {
		case 1:
			playerOneScore = 4;
			playerTwoScore = 7;
			break;
		case 2:
			playerOneScore = 7;
			playerTwoScore = 4;
			break;
		default:
			throw new IllegalArgumentException(errMsg);
		}
	}

	public boolean isGameOver() {
		return (playerOneScore == 4 || playerTwoScore == 4);
	}
}
