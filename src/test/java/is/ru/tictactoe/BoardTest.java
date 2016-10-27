package is.ru.tictactoe;

import java.awt.Point;
import static org.junit.Assert.assertEquals;
import org.junit.rules.ExpectedException;
import org.junit.Rule;

import org.junit.Test;

public class BoardTest {

	@Test
	public void firstTest() {
		//assertEquals(0, Board.isFree('3'));
	}

	@Rule
  	public final ExpectedException exception = ExpectedException.none();


	//Tests on insert action
	@Test
	public void testInvalidInsertUpper() {
		exception.expect(IndexOutOfBoundsException.class);
		exception.expectMessage("Board: Index out of bounds: (4,4) is illegal");
		Board b = new Board();
		b.insert(new Point(4,4), 1);
	}

	@Test
	public void testInvalidInsertLower() {
		exception.expect(IndexOutOfBoundsException.class);
		exception.expectMessage("Board: Index out of bounds: (-1,-2) is illegal");
		Board b = new Board();
		b.insert(new Point(-1,-2), 1);
	}

	@Test
	public void testInsertTurn() {
		exception.expect(IllegalArgumentException.class);
		exception.expectMessage("Board: Illegal turn value: 15");
		Board b = new Board();
		b.insert(new Point(1,1), 15);
	}
}
