package is.ru.tictactoe;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

public class GameTest {

	@Test
	public void firstTest() {

	}

	@Test
	public void checkValidInput() {
		Game game = new Game();
		assertEquals(false,game.validInput(-1));
		assertEquals(true,game.validInput(2));
		assertEquals(true,game.validInput(3));
		assertEquals(true,game.validInput(9));
	}
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void checkGameInput() {
		Game game = new Game();
		game.checkInput();
		assertEquals(1,game.turn);

		

	}




}
