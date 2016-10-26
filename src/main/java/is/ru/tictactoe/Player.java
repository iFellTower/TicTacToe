package is.ru.tictactoe;

public class Player {

	private int score;
	private char symbol;

	public Player(char s) {
		symbol = s;
	}

	public char getChar() {
		return symbol;
	}
}
