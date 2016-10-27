package is.ru.tictactoe;

import java.awt.Point;

public class Game {

	private Board board;
	private boolean winner;
    private Player playerX;
    private Player playerO;
	private Player currPlayer;
	private static UI ui;

	public Game() {
		 board = new Board();
		 winner = false;
         playerX = new Player('X');
         playerO = new Player('O');
		 currPlayer = playerX;
		 ui = new UI();
	}

	public void runGame() {
		int input;
		while(!winner || !board.isFull()){
			drawScreen();
			do{
				input = ui.getInput();
			}while(!validInput(input));
			insertIntoBoard(input);
			checkIfWinner();
			if(winner || board.isFull())
				break;
			switchPlayer();
		}
		declareWinner();
	}

	private void drawScreen() {
		ui.drawBoard(board);
	}

	public boolean validInput(int input) {
        if(input >= 1 && input <= 9){
            Point point = convertToPoint(input);
            if (board.isFree(point))
                return true;
            else
                return false;
        }
        return false;
    }

    public void insertIntoBoard(int input) {
        Point point = convertToPoint(input);
        board.insert(point, currPlayer.getSymbol());
    }

    public Point convertToPoint(int input) {
        Point point = null;
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
         	}

            return point;
    }
	public boolean getWinner() {
		return winner;
	}

	private void checkIfWinner() {
		winner = board.winner();
	}

	private void declareWinner() {
		if(winner)
			ui.declareWinner(currPlayer);
		else
			ui.declareDraw();
	}

	private void switchPlayer() {
		if(currPlayer == playerX)
			currPlayer = playerO;
		else
			currPlayer = playerX;
	}

	public static void main(String[] args){
		Game g = new Game();
		g.runGame();
	}
}
