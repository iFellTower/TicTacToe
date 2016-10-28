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
		System.out.println("Choose 1 to play Tic-Tac-Toe against another player");
		System.out.println("Press 'Q' to exit the program");
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
	public int getInput () {
		Scanner s = new Scanner(System.in);
		int input  = s.nextInt();

		return input;
	}
}

