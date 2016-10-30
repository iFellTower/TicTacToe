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
		assertFalse("validInput should return false",game.validInput(10));
		assertTrue("validInput should return true",game.validInput(2));
		assertTrue("validInput should return true",game.validInput(1));
		assertTrue("validInput should return true",game.validInput(9));
		game.makeMove(2);
		assertFalse("validInput should return false",game.validInput(2));

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
		game.switchPlayer();
		assertEquals('X',game.getCurrPlayer().getSymbol());
		game.switchPlayer();
		assertEquals('O',game.getCurrPlayer().getSymbol());
	}

	@Test
	public void testWinnerTrue() {
		Game game = new Game();

		game.makeMove(1);
		game.makeMove(4);
		game.makeMove(2);
		game.makeMove(5);
		game.makeMove(3);

		assertTrue("Winner should be true",game.getWinner());
	}

	@Test
	public void testWinnerFalse() {
		Game game = new Game();

		game.makeMove(4);
		game.makeMove(5);
		game.makeMove(6);
		game.makeMove(7);
		game.makeMove(8);
		game.makeMove(9);

		assertFalse("Winner should be false",game.getWinner());
	}

	@Test
	public void testIfDraw() {
		Game game = new Game();
		game.makeMove(1);
		game.makeMove(3);
		game.makeMove(2);
		game.makeMove(4);
		game.makeMove(6);
		game.makeMove(5);
		game.makeMove(7);
		game.makeMove(9);
		game.makeMove(8);

		assertTrue("Should be a draw",game.getDraw());
	}

	@Test
	public void testValidMenuInput() {
		Game game = new Game();
		assertTrue("validMenuInput should return true", game.validMenuInput(0));
		assertTrue("validMenuInput should return true", game.validMenuInput(1));
		assertFalse("validMenuInput should return false", game.validMenuInput(2));
		assertFalse("validMenuInput should return false", game.validMenuInput(-1));
	}

	@Test
	public void testGetCurrPlayer () {
		Game game = new Game();
		Player player = new Player('O');
		assertEquals(player.getSymbol(), game.getCurrPlayer().getSymbol());
	}


	@Test
	public void testGetPlayerX () {
		Game game = new Game();
		Player player = new Player('X');
		assertEquals(player.getSymbol(), game.getPlayerX().getSymbol());
	}


	@Test
	public void testGetPlayerO () {
		Game game = new Game();
		Player player = new Player('O');
		assertEquals(player.getSymbol(), game.getPlayerO().getSymbol());
	}

	@Test
	public void testNewGame() {
		Game game = new Game();

		game.makeMove(1);
		game.makeMove(4);
		game.makeMove(2);
		game.makeMove(5);
		game.makeMove(3);

		game.newGame();
		assertEquals('1', game.getBoard().getAt(new Point(0, 0)));
		assertEquals('2', game.getBoard().getAt(new Point(0, 1)));
		assertEquals('3', game.getBoard().getAt(new Point(0, 2)));
		assertEquals('4', game.getBoard().getAt(new Point(1, 0)));
		assertEquals('5', game.getBoard().getAt(new Point(1, 1)));
		assertFalse("Should return False", game.getWinner());
		assertFalse("Should return False", game.getDraw());
		assertEquals('X', game.getPlayerX().getSymbol());
	}

	@Test
	public void testConvertToPointDefaultCase() {
		Game game = new Game();

		assertEquals(null, game.convertToPoint(10));
	}

	@Test
	public void testGetWinPlayer() {
		Game game = new Game();

		game.makeMove(1);
		game.makeMove(3);
		game.makeMove(5);

		assertEquals(null, game.getWinPlayer());

		game.makeMove(2);
		game.makeMove(9);

		Player winner = game.getWinPlayer();

		assertEquals('X', winner.getSymbol());
	}
}
