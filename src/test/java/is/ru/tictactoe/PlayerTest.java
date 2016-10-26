package is.ru.tictactoe;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PlayerTest {

	@Test
	public void testCharacter() {
	       Player p = new Player('X');
           assertEquals('X', p.getChar());
	}

    @Test
    public void testScore() {
           Player p = new Player('X');
           assertEquals(0, p.getScore());
    }
}
