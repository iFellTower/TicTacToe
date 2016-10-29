package is.ru.tictactoe;

import java.awt.Point;

public class Application {
	private Game game;
	private UI ui;

	public Application (Game game, UI ui) {
		this.game = game;
		this.ui = ui;
	}

	public void runApp () {
		while (true) {
			if (quitApp(getMenuChoice())) {
				break;
			}
			else {
				playGame();
				ui.drawBoard(game.getBoard());
				if (game.getWinner()) {
					game.switchPlayer();
					(game.getCurrPlayer()).incrementScore();
					ui.printWinner(game.getCurrPlayer());
				}
				else if (game.getDraw()) {
					ui.printDraw();
				}
				ui.printScore(game.getPlayerO(), game.getPlayerX());
			}
		}
	}

	private int getMenuChoice () {
		int choice;
		boolean validChoice;
		do {
			choice = ui.getChoice();
			validChoice = game.validMenuInput(choice);
			if (!validChoice) {
				ui.printInvalidInput(0, 1);
			}
		} while(!validChoice);
		return choice;
	}

	private void playGame () {
		game.newGame();
		while (!game.getWinner() && !game.getDraw()) {
			ui.drawBoard(game.getBoard());
			int input;
			boolean validInput, isFree;
			do{
				input = ui.getNextMove(game.getCurrPlayer());
				validInput = game.validInput(input);
				isFree = game.getBoard().isFree(game.convertToPoint(input));
				if(!isFree) {
					ui.printFieldTaken();
				}
				else if (!validInput) {
					ui.printInvalidInput(1, 9);
				}
			} while (!validInput);
			game.makeMove(input);
			game.switchPlayer();
		}
	}
	private boolean quitApp (int choice) {
		return (choice == 0);
	}


	public static void main (String[] args) {
		Game game = new Game();
		UI ui = new UI();
		Application app = new Application(game,ui);

		app.runApp();
	}
}
