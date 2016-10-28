package is.ru.tictactoe;
import java.util.Scanner;


public class UI {

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

	// Reads input from StdIn and sends it forward
	public int getInput () {
		Scanner s = new Scanner(System.in);
		int input  = s.nextInt();

		return input;
	}

	
}

