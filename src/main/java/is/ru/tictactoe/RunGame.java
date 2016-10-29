package is.ru.tictactoe;

public class RunGame {

    public static void main (String[] args) {
        Game game = new Game();
        UI ui = new UI();
        Application app = new Application(game,ui);

        app.runApp();
    }
}
