package is.ru.tictactoe;
import static spark.Spark.*;

import java.awt.Point;

public class Game {

	Board board = new Board();
	int turn;
	boolean winner;

	public Game() {

	}


	public void runGame() {

	}

	public void drawScreen() {

	}

	public boolean validInput(int input) {

		if(input >= 1 && input <= 9){
			return true;
		}
		return false;
	}

	public void checkInput() {
		//throw new IllegalArgumentException("Game checkInput(): Invalid input");
		do{
			int input = 5;


		}while(!validInput(input));
		turn++;
		Point point = new Point(1,1);

	}

	public static void main(String[] args) {
    	get("/hello", (req, res) -> "Hello World");
  	}
}
