package is.ru.tictactoe;

public class Player {

	private int score;
	private char symbol;

	public Player(char s) {
		score = 0;
		symbol = s;
	}

	public char getChar() {
		return symbol;
	}

	public int getScore() {
		return score;
	}

	public void incrementScore() {
		score++;
	}
}
