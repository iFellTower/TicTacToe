package is.ru.tictactoe;

import java.awt.Point;

public class Board {

	private static final int size = 3;
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

	public char[][] getBoard() {
		return board;
	}

	public boolean winner() {
		return checkWinner();
	}

	private boolean checkWinner() {
		// Check horizontal and vertical winner
		for (int i = 0; i < size; i++) {
			if (board[i][0] == board[i][1] && board[i][1] == board[i][2])
				return true;
			if (board[0][i] == board[1][i] && board[1][i] == board[2][i])
				return true;
		}

		// Check diagonal winner
		if (board[0][0] == board[1][1] && board[1][1] == board[2][2])
			return true;
		if (board[0][2] == board[1][1] && board[1][1] == board[2][0])
			return true;

		return false;
	}
}
