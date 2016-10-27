package is.ru.tictactoe;

import java.awt.Point;

public class Board {

	private char[][] board;

	public Board(){
		board = new char[3][3];
		fillBoard();
	}

	private void fillBoard() {
		char num = '1';
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				board[i][j] = num;
				num++;
			}
		}
	}

	public void insert(Point pos, char playerSymbol) {
		validatePosition(pos);
		board[pos.x][pos.y] = playerSymbol;
	}

	private void validatePosition(Point pos) {
		if(pos.getX() < 0 || pos.getX() > 2 || pos.getY() < 0 || pos.getY() > 2) {
			throw new IndexOutOfBoundsException("Board: Index out of bounds: (" + pos.x + "," + pos.y + ") is illegal");
		}
	}

	public Boolean isFree(Point pos) {
		return ((board[pos.x][pos.y] != 'X') && (board[pos.x][pos.y] != 'O'));
	}

	public char[][] getBoard() {
		return board;
	}
}
