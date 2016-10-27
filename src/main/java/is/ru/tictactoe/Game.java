package is.ru.tictactoe;
import static spark.Spark.*;

import java.awt.Point;

public class Game {

	private Board board;
	private int turn;
	private boolean winner;
    private Player playerX;
    private Player playerO;

	public Game() {
		 board = new Board();
		 turn = 0;
		 winner = false;
         playerX = new Player('X');
         playerO = new Player('Y');
	}

	public void runGame() {

	}

	public void drawScreen() {

	}

	public boolean validInput(int input) {
        if(input >= 1 && input <= 9){
            Point point = convertToPoint(input);
            if (board.isFree(point)) {
                return true;
            }
            else
                return false;
        }
        return false;
    }

    public void insertIntoBoard(int input) {
        Point point = convertToPoint(input);

        if(turn % 2 == 0) {
            //should be playerX.getSymbol()
            board.insert(point, 'X');
        }
        else {
            //should be playerX.getSymbol()
            board.insert(point, 'O');
        }

        turn++;
    }

    private Point convertToPoint(int input) {
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

    public int getTurn() {
        return turn;
    }
}

