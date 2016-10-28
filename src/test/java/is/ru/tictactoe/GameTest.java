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
	public void testInsert() {
		Game game = new Game();
		game.makeMove(5);

		Board board = new Board();
		board = game.getBoard();

		assertEquals(false,board.isFree(new Point(1,1)));
	}

	@Test
	public void testSwitchPlayer() {
		Game game = new Game();
		game.makeMove(5);
		assertEquals('O',game.getCurrPlayerSymbol());
		game.makeMove(3);
		assertEquals('X',game.getCurrPlayerSymbol());
	}

	@Test
	public void testWinner() {
		Game game = new Game();

		game.makeMove(1);
		game.makeMove(4);
		game.makeMove(2);
		game.makeMove(5);
		game.makeMove(3);

		assertTrue("Winner should be true",game.getWinner());

	}


}
