package is.ru.tictactoe;

import java.awt.Point;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.junit.rules.ExpectedException;
import org.junit.Rule;

import org.junit.Test;

public class BoardTest {

	@Rule
  	public final ExpectedException exception = ExpectedException.none();


	//Tests on insert action
	@Test
	public void testInvalidInsertUpper() {
		exception.expect(IndexOutOfBoundsException.class);
		exception.expectMessage("Board: Index out of bounds: (4,4) is illegal");
		Board b = new Board();
		b.insert(new Point(4,4), 'X');
	}

	@Test
	public void testInvalidInsertLower() {
		exception.expect(IndexOutOfBoundsException.class);
		exception.expectMessage("Board: Index out of bounds: (-1,-2) is illegal");
		Board b = new Board();
		b.insert(new Point(-1,-2), 'X');
	}

	@Test
	public void testIsFreeTrue() {
		Point pos = new Point(1,1);
		Board b = new Board();
		assertTrue("Should return true", b.isFree(pos));
	}

	@Test
	public void testIsFreeFalse() {
		Point pos = new Point(1,1);
		Board b = new Board();
		b.insert(pos, 'X');
		assertFalse("Should return false", b.isFree(pos));
	}

}
