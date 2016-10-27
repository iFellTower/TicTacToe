package is.ru.tictactoe;

import java.awt.Point;

public class Board {

	private char[][] board;

	public Board(){
		board = new char[3][3];
	}

	public void draw() {

	}

	public boolean insert(Point pos, char playerSymbol) {
		validatePosition(pos);
		if(isFree(pos)){
			board[pos.x][pos.y] = playerSymbol;
			return true;
		}
		else{
			return false;
		}
	}

	private void validatePosition(Point pos) {
		if(pos.getX() < 0 || pos.getX() > 2 || pos.getY() < 0 || pos.getY() > 2) {
			throw new IndexOutOfBoundsException("Board: Index out of bounds: (" + pos.x + "," + pos.y + ") is illegal");
		}
	}

	public Boolean isFree(Point pos) {
		return ((board[pos.x][pos.y] != 'X') && (board[pos.x][pos.y] != 'O'));
	}
}
