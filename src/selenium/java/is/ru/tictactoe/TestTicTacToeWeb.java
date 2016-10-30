package is.ru.tictactoe;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TestTicTacToeWeb extends SeleniumTestWrapper {

    @Test
    public void titleMatches() throws InterruptedException {
        //Thread.sleep(5000);
        driver.get(baseUrl);
        Thread.sleep(5000);
        assertEquals("iFellTower - Tic Tac Toe", driver.getTitle());
        Thread.sleep(5000);
    }
    /*
    @Test
    public void assertUpdatingNameChangesSpecificJoke() {
        driver.get(baseUrl + "/config.html");

        1. Fill in some name (first name, last name)
        2. Submit form.
        3. Assert that form notifies of success ("Name set as: ...")
        4. Navigate to page to get specific Joke
        5. Enter a specific joke number
        6. Assert the name is used in the joke.

    }*/
}
