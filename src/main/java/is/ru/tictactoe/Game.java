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


	}

	public static void main(String[] args) {
    	get("/hello", (req, res) -> "Hello World");
  	}
}
