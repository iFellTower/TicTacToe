package is.ru.tictactoe;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.ExpectedException;
import java.awt.Point;


public class GameTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();


	@Test
	public void testValidInput() {
		Game game = new Game();
		assertEquals(false,game.validInput(-1));
		assertEquals(true,game.validInput(2));
		assertEquals(true,game.validInput(3));
		assertEquals(true,game.validInput(9));
	}

	@Test
	public void testInsertIntoBoard() {
		Game game = new Game();
		game.insertIntoBoard(5);
		assertEquals(1,game.getTurn());
	}

	@Test
	public void testGetTurn() {
		Game game = new Game();
		assertEquals(0,game.getTurn());
	}
	/*@Test
	public void testRunGame() {
		Game game = new Game();
		game.runGame()
		assertEquals(1, game.getTurn())
	}*/



}
