package uk.co.icecreamhead.spoof.server;

import uk.co.icecreamhead.spoof.game.Game;
import uk.co.icecreamhead.spoof.game.GameConfig;

/**
 * Created with IntelliJ IDEA.
 * User: joshcooke
 * Date: 04/04/15
 * Time: 11:37
 */
public class JsonSpoofServer implements Runnable {
    private GameConfig gameConfig;
    private ServerConfig serverConfig;

    @Override
    public void run() {
        Game game = new Game(gameConfig);

    }

    public void setGameConfig(GameConfig gameConfig) {
        this.gameConfig = gameConfig;
    }

    public void setServerConfig(ServerConfig serverConfig) {
        this.serverConfig = serverConfig;
    }
}
