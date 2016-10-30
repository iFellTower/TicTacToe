package is.ru.tictactoe;

import java.awt.Point;

public class Game {

	private Board board;
	private boolean winner,draw;
    private Player playerX;
    private Player playerO;
    private Player currPlayer;
	private Player winPlayer;

	public Game() {
		 board = new Board();
		 winner = false;
         draw = false;
         playerX = new Player('X');
         playerO = new Player('O');
         currPlayer = playerO;
		 winPlayer = null;
	}

	public void newGame() {
		board.clearBoard();
		winner = false;
		draw = false;
		currPlayer = playerO;
	}

	public void makeMove(int input) {
		switchPlayer();
        insertIntoBoard(input);
        checkDraw();
        checkWinner();
		if (winner) {
			winPlayer = currPlayer;
			winPlayer.incrementScore();
		}
    }

	public boolean validInput(int input) {
        if(input >= 1 && input <= 9) {
            Point point = convertToPoint(input);
            if (board.isFree(point)) {
                return true;
            }
            else
                return false;
        }
        return false;
    }

	public boolean validMenuInput(int input) {
		if(input >= 0 && input <= 1) {
			return true;
		}
		return false;
	}

    private void insertIntoBoard(int input) {
        Point point = convertToPoint(input);
        board.insert(point,currPlayer.getSymbol());
    }

    public Point convertToPoint(int input) {
        Point point = null;
        switch (input) {
            case 1:  point = new Point(0,0);
                     break;
            case 2:  point = new Point(0,1);
                     break;
            case 3:  point = new Point(0,2);
                     break;
            case 4:  point = new Point(1,0);
                     break;
            case 5:  point = new Point(1,1);
                     break;
            case 6:  point = new Point(1,2);
                     break;
            case 7:  point = new Point(2,0);
                     break;
            case 8:  point = new Point(2,1);
                     break;
            case 9:  point = new Point(2,2);
                    break;
            default: // Will not run because of check in validInput.
                     break;
        }
        return point;
    }

    public Board getBoard() {
        return board;
    }

	public Player getCurrPlayer() {
		return currPlayer;
	}

	public Player getPlayerX() {
		return playerX;
	}

	public Player getPlayerO() {
		return playerO;
	}

    public void switchPlayer() {
        if(currPlayer == playerX)
            currPlayer = playerO;
        else
            currPlayer = playerX;
    }

    public boolean getWinner() {
        return winner;
    }

    private void checkWinner() {
        winner = board.winner();
    }

    public boolean getDraw() {
        return draw;
    }

    private void checkDraw() {
        draw = board.isFull();
    }
}
