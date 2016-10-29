package is.ru.tictactoe;
import java.util.Scanner;


public class UI {

	// Prints the menu and prompts the user to input his selection
	public int getChoice () {
		printMenu();
		int choice = getInput();

		return choice;
	}

	// Helper function to print the menu
	private void printMenu() {
		System.out.println("Press '1' to play Tic-Tac-Toe against another player");
		System.out.println("Press '0' to exit the program");
	}

	// Draws the current state of the board
	public void drawBoard (Board b) {
		char[][] board = b.getBoard();

		System.out.println('\n');
        System.out.println(" " + board[0][0] + " | " + board[0][1] + " | "
                + board[0][2]);
        System.out.println(" ---------");
        System.out.println(" " + board[1][0] + " | " + board[1][1] + " | "
                + board[1][2]);
        System.out.println(" ---------");
        System.out.println(" " + board[2][0] + " | " + board[2][1] + " | "
                + board[2][2]);
	}

	// Reads input from StdIn
	private int getInput () {
		Scanner s = new Scanner(System.in);
		int input  = s.nextInt();

		return input;
	}

	// Takes a player object and prints the winner
	public void printWinner (Player winner) {
		System.out.println("Congratulations " + winner.getSymbol() + " you are the winner!");
	}

	// Prints a msg saying the game ended in a draw
	public void printDraw () {
		System.out.println("The game has ended with a draw.");
	}

	// Prints the current score, that is how many games each player has won
	public void printScore (Player playerO, Player playerX) {
		System.out.println("Player O: " + playerO.getScore());
		System.out.println("Player X: " + playerX.getScore());
	}

	// Prints an error msg if the input is invalid
	public void printInvalidInput (int min, int max) {
		System.out.println("Input should be between " + min + " and " + max + "!");
	}

	// Prints an error msg if the input field is already taken
	public void printFieldTaken () {
		System.out.println("That field is already taken, please choose another one");
	}

	// Prints out who's turn it is and prompts that user to make a move
	public int getNextMove (Player player) {
			System.out.println('\n');
			System.out.print("Player " + player.getSymbol() + ", input your next move: ");
			int move = getInput();

			return move;
	}
}
