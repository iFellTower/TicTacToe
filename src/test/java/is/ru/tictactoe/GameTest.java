package is.ru.tictactoe;

import static org.junit.Assert.*;

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
	public void testWinnerAtStart() {
		Game game = new Game();
		assertFalse("Game: Should return false", game.getWinner());
	}

	/*@Test
	public void testRunGame() {
		Game game = new Game();
		game.runGame()
		assertEquals(1, game.getTurn())
	}*/



}
