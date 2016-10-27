package is.ru.tictactoe;
import static spark.Spark.*;

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
		if(input >= 0 && input <= 8){
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
