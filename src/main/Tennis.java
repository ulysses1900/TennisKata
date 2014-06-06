package main;

public class Tennis {
	public Player one;
	public Player two;
	
	class Player{
		int playerNumber;
		int currentScore;
		
		public int getCurrentScore(){
			return currentScore;
		}
		
		Player (int number, int score){
			playerNumber = number;
			currentScore = score;
		}
		
		public void addPoints(){
			if (currentScore < 30) currentScore += 15;
			if (currentScore >= 30) currentScore += 10;
		}
	}
	
	public Tennis (){
		one = new Player(1, 0);
		two = new Player(2, 0);
	}
	
	public void score(Player player){
		player.addPoints();
	}
	
	public String getScore(){
		return one.getCurrentScore() + "-" + two.getCurrentScore();
	}
}
