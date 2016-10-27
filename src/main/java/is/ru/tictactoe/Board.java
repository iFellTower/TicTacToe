package is.ru.tictactoe;

import java.awt.Point;

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

	public boolean insert(Point pos, int turn) {
		if(pos.getX() < 0 || pos.getX() > 2) {
			throw new IndexOutOfBoundsException("Board: Index out of bounds: (" + pos.x + "," + pos.y + ") is illegal");
		}
		if(pos.getY() < 0 || pos.getY() > 2) {
			throw new IndexOutOfBoundsException("Board: Index out of bounds: (" + pos.x + "," + pos.y + ") is illegal");
		}
		if(turn < 1 || turn > 9) {
			throw new IllegalArgumentException("Board: Illegal turn value: " + turn);
		}
		return false;
	}

	public void isFree(char input) {

	}
}
