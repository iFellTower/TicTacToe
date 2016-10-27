package is.ru.tictactoe;

import java.awt.Point;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.rules.ExpectedException;
import org.junit.Rule;

import org.junit.Test;

public class BoardTest {

	@Rule
  	public final ExpectedException exception = ExpectedException.none();

	@Test
	public void testInvalidInsertUpper() {
		exception.expect(IndexOutOfBoundsException.class);
		exception.expectMessage("Board: Index out of bounds: (4,4) is illegal");
		Board b = new Board();
		b.insert(new Point(4,4), 1);
	}

	@Test
	public void testIsFreeTrue() {
		Point pos = new Point(1,1);
		Board b = new Board();
		assertTrue("Should return true", b.isFree(pos));
	}

}
