package is.ru.tictactoe;

import java.awt.Point;

public class Application {


	private Game game;
	private UI ui;

	public Application(Game game, UI ui) {
		this.game = game;
		this.ui = ui;

	}

	public void playGame() {

		while(!game.getWinner()) {
			int input;
			do{
				input = ui.getInput();
			}while(!game.validInput(input));

			game.makeMove(input);
		}

	}


	public static void main(String[] args) {

		Game game = new Game();
		UI ui = new UI();

		Application app = new Application(game,ui);

		app.playGame();




	}
}