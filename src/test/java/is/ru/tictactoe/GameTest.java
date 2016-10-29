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
		assertEquals('O',game.getCurrPlayerSymbol());
		game.switchPlayer();
		assertEquals('X',game.getCurrPlayerSymbol());
	}

	@Test
	public void testWinnerTrue() {
		Game game = new Game();

		game.makeMove(1);
		game.switchPlayer();
		game.makeMove(4);
		game.switchPlayer();
		game.makeMove(2);
		game.switchPlayer();
		game.makeMove(5);
		game.switchPlayer();
		game.makeMove(3);

		assertTrue("Winner should be true",game.getWinner());
	}

	@Test
	public void testWinnerFalse() {
		Game game = new Game();

		game.makeMove(4);
		game.switchPlayer();
		game.makeMove(5);
		game.switchPlayer();
		game.makeMove(6);
		game.switchPlayer();
		game.makeMove(7);
		game.switchPlayer();
		game.makeMove(8);
		game.switchPlayer();
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
		assertFalse("validMenuInput should return false", game.validMenuInput(2));
	}

	@Test
	public void testGetCurrPlayer () {
		Game game = new Game();
		Player player = new Player('X');
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

		char[][] testBoard = new char[3][3];
		char num = '1';
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				testBoard[i][j] = num;
				num++;
			}
		}

		game.makeMove(1);
		game.switchPlayer();
		game.makeMove(4);
		game.switchPlayer();
		game.makeMove(2);
		game.switchPlayer();
		game.makeMove(5);
		game.switchPlayer();
		game.makeMove(3);
		game.switchPlayer();

		game.newGame();
		assertArrayEquals(testBoard, game.getBoard().getBoard());
		assertFalse("Should return False", game.getWinner());
		assertFalse("Should return False", game.getDraw());
		assertEquals('X', game.getPlayerX().getSymbol());
	}

	@Test
	public void testConvertToPointDefaultCase() {
		Game game = new Game();

		assertEquals(null, game.convertToPoint(10));
	}

}
