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
		String choice;
		boolean validChoice;
		int num;
		do {
			choice = ui.getChoice();
			num = convertStringToInt(choice);
			validChoice = game.validMenuInput(num);
			if (!validChoice) {
				ui.printInvalidInput(0, 1);
			}
		} while(!validChoice);
		return num;
	}

	private void playGame () {
		game.newGame();
		while (!game.getWinner() && !game.getDraw()) {
			ui.drawBoard(game.getBoard());
			String input;
			boolean validInput, isFree;
			int num;
			do{
				input = ui.getNextMove(game.getCurrPlayer());
				num = convertStringToInt(input);
				validInput = game.validInput(num);
				if (validInput) {
					isFree = game.getBoard().isFree(game.convertToPoint(num));
					if(!isFree) {
						ui.printFieldTaken();
					}
				}
				else {
					ui.printInvalidInput(1, 9);
				}
			} while (!validInput);
			game.makeMove(num);
			game.switchPlayer();
		}
	}

	private int convertStringToInt(String str) {
		return Character.getNumericValue(str.charAt(0));
	}

	private boolean quitApp (int choice) {
		return (choice == 0);
	}
}
