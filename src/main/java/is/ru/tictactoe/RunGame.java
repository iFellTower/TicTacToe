package is.ru.tictactoe;

import spark.*;
import static spark.Spark.*;
import spark.servlet.SparkApplication;
import org.json.simple.JSONObject;

public class RunGame  implements SparkApplication {

    public static void main (String[] args) {
        /*Game game = new Game();
        UI ui = new UI();
        Application app = new Application(game,ui);

        app.runApp();*/

        staticFileLocation("/public");
        SparkApplication runGame = new RunGame();
        String port = System.getenv("PORT");
        if (port != null) {
            port(Integer.valueOf(port));
        }

        runGame.init();
    }

    @Override
    public void init() {
        final Game game = new Game();

        post("newGame", (req, res) -> {
            game.newGame();
            res.status(200);
            return res;
        });

        post("makeMove", (req, res) -> {
            game.makeMove( Integer.parseInt(req.queryParams("tile")) );

            char playerSymbol = game.getCurrPlayer().getSymbol();

            JSONObject move = new JSONObject();
            move.put("status", "200");
            move.put("player", Character.toString(playerSymbol));
            return move;
        } );

        post("changePlayer", (req, res) -> {
            game.switchPlayer();
            res.status(200);
            return res;
        });

        get("checkWinner", (req, res) -> {
          JSONObject status = new JSONObject();

          if(game.getWinner()){
            Player winner = game.getWinPlayer();

            status.put("status", true);
            status.put("player", Character.toString(winner.getSymbol()));
          } else {
            status.put("status", false);
          }
          return status;
        });

        get("checkDraw", (req, res) -> {
            JSONObject status = new JSONObject();

            if(game.getDraw()) {
                status.put("status", true);
            } else {
                status.put("status", false);
            }

            return status;
        });

        get("getScores", (req, res) -> {
            JSONObject scores = new JSONObject();
            scores.put("playerX", game.getPlayerX().getScore());
            scores.put("playerO", game.getPlayerO().getScore());
            return scores;
        });

        post("clearGame", (req, res) -> {
            game.clearGame();
            res.status(200);
            return res;
        });

    }
}
