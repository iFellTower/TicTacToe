package is.ru.tictactoe;



import org.junit.Test;
import org.junit.Rule;
import static org.junit.Assert.*;

import java.awt.Point;


public class GameTest {

	@Test
	public void testValidInput() {
		Game game = new Game();
		assertFalse("validInput should return false",game.validInput(-1));
		assertTrue("validInput should return true",game.validInput(2));
	}

	@Test
	public void testInsertIntoBoard() {
		Game game = new Game();
		game.insertIntoBoard(5);

		Board board = new Board();
		board = game.getBoard();

		assertEquals(false,board.isFree(new Point(1,1)));
	}

	@Test
	public void testSwitchPlayer() {
		Game game = new Game();
		game.makeMove();
		assertEquals('O',game.getCurrPlayerSymbol());
		game.makeMove();
		assertEquals('X',game.getCurrPlayerSymbol());
	}


	/*@Test
	public void testRunGame() {
		Game game = new Game();
		game.runGame()
		assertEquals(1, game.getTurn())
	}*/



}
