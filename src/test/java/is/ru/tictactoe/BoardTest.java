package is.ru.tictactoe;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BoardTest {

	@Test
	public void firstTest() {
		assertEquals(0, Board.isFree(3));
	}

}
