package is.ru.tictactoe;
import static spark.Spark.*;

import java.awt.Point;

public class Game {

	private Board board;
	private int turn;
	private boolean winner;

	public Game() {
		 board = new Board();
		 turn = 0;
		 winner = false;
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

    private Point convertToPoint(int input) {
        Point point;
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
 
            return point;
    }

	public void insertIntoBoard(int input) {		


	}

	public static void main(String[] args) {
    	get("/hello", (req, res) -> "Hello World");
  	}
}
