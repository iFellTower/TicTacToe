package is.ru.tictactoe;

public class Board {


	private Player playerX;
	private Player playerO;

	char[][] board = new char[3][3];

	public Board(){
		playerX = new Player('X');
		playerO = new Player('O');
	}

	public void draw() {

	}

	public boolean input(char input,int turn) {
		return false;
	}

	public void isFree(char input) {

	}
}
