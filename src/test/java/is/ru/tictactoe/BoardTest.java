package is.ru.tictactoe;

import java.awt.Point;
import static org.junit.Assert.*;
import org.junit.rules.ExpectedException;
import org.junit.Rule;

import org.junit.Test;

public class BoardTest {

	@Rule
  	public final ExpectedException exception = ExpectedException.none();


	//Tests on insert action
	@Test
	public void testInvalidInsertXOver() {
		exception.expect(IndexOutOfBoundsException.class);
		exception.expectMessage("Board: Index out of bounds: (4,1) is illegal");
		Board b = new Board();
		b.insert(new Point(4,1), 'X');
	}

	@Test
	public void testInvalidInsertXUnder() {
		exception.expect(IndexOutOfBoundsException.class);
		exception.expectMessage("Board: Index out of bounds: (-1,1) is illegal");
		Board b = new Board();
		b.insert(new Point(-1,1), 'X');
	}

	@Test
	public void testInvalidInsertYOver() {
		exception.expect(IndexOutOfBoundsException.class);
		exception.expectMessage("Board: Index out of bounds: (1,4) is illegal");
		Board b = new Board();
		b.insert(new Point(1,4), 'X');
	}

	@Test
	public void testInvalidInsertYUnder() {
		exception.expect(IndexOutOfBoundsException.class);
		exception.expectMessage("Board: Index out of bounds: (1,-1) is illegal");
		Board b = new Board();
		b.insert(new Point(1,-1), 'X');
	}

	@Test
	public void testInsertPosIsFree() {
		Board b = new Board();
		assertTrue("Board: Should return true because pos is free",b.insert(new Point(1,1), 'X'));
		assertFalse("Board: Should return false because pos is not free",b.insert(new Point(1,1), 'X'));
	}

	@Test
	public void testIsFreeTrue() {
		Point pos = new Point(1,1);
		Board b = new Board();
		assertTrue("Board: Should return true", b.isFree(pos));
	}

	@Test
	public void testIsFreeFalse() {
		Point pos1 = new Point(1,1);
		Board b1 = new Board();
		b1.insert(pos1, 'X');
		assertFalse("Should return false", b1.isFree(pos1));

		Point pos2 = new Point(1,1);
		Board b2 = new Board();
		b2.insert(pos2, 'O');
		assertFalse("Should return false", b2.isFree(pos2));

	}

	@Test
	public void testGetAt() {
		Board board = new Board();
		assertEquals('1', board.getAt(new Point(0, 0)));
		assertEquals('2', board.getAt(new Point(0, 1)));
		assertEquals('3', board.getAt(new Point(0, 2)));
		assertEquals('4', board.getAt(new Point(1, 0)));
		assertEquals('5', board.getAt(new Point(1, 1)));
	}

	@Test
	public void testWinner() {
		Board b = new Board();
		assertFalse("Board: Should return false", b.winner());

		// Check horizontal winner
		for (int i = 0; i < 3; i++) {
			b.insert(new Point(0, i), 'X');
		}
		assertTrue("Board: Should return true", b.winner());

		// Check vertical winner
		Board b1 = new Board();
		for (int i = 0; i < 3; i++) {
			b1.insert(new Point(i, 0), 'X');
		}
		assertTrue("Board: Should return true", b1.winner());

		Board b2 = new Board();
		b2.insert(new Point(0, 1), 'X');
		b2.insert(new Point(1, 1), 'X');
		b2.insert(new Point(2, 1), 'O');
		assertFalse("Board: Should return false", b2.winner());

		// Check diagonal winner
		Board b3 = new Board();
		b3.insert(new Point(0, 0), 'X');
		b3.insert(new Point(1, 1), 'X');
		b3.insert(new Point(2, 2), 'X');
		assertTrue("Board: Should return true", b3.winner());

		Board b4 = new Board();
		b4.insert(new Point(0, 0), 'X');
		b4.insert(new Point(1, 1), 'X');
		b4.insert(new Point(2, 2), 'O');
		assertFalse("Board: Should return false", b4.winner());

		Board b5 = new Board();
		b5.insert(new Point(0, 0), 'O');
		b5.insert(new Point(1, 1), 'X');
		b5.insert(new Point(2, 2), 'X');
		assertFalse("Board: Should return false", b5.winner());

		Board b6 = new Board();
		b6.insert(new Point(0, 2), 'X');
		b6.insert(new Point(1, 1), 'X');
		b6.insert(new Point(2, 0), 'X');
		assertTrue("Board: Should return true", b6.winner());

		Board b7 = new Board();
		b7.insert(new Point(0, 2), 'X');
		b7.insert(new Point(1, 1), 'X');
		b7.insert(new Point(2, 0), 'O');
		assertFalse("Board: Should return false", b7.winner());

		Board b8 = new Board();
		b8.insert(new Point(0, 2), 'O');
		b8.insert(new Point(1, 1), 'X');
		b8.insert(new Point(2, 0), 'X');
		assertFalse("Board: Should return false", b8.winner());
	}

	@Test
	public void testIsFull() {
		Board b = new Board();
		assertFalse("Board: Should return false", b.isFull());

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				b.insert(new Point(i, j), 'X');
			}
		}

		assertTrue("Board: Should return true", b.isFull());
	}



}
