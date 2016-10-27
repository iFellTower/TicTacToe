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

	@Test
	public void testInvalidInsert(){
		exception.expect(IndexOutOfBoundsException.class);
		exception.expectMessage("Board: Index out of bounds");
		Board b = new Board();
		b.insert(new Point(4,4), 1);
	}
}
