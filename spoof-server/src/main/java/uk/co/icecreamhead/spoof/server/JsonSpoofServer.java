package uk.co.icecreamhead.spoof.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import uk.co.icecreamhead.spoof.game.Game;
import uk.co.icecreamhead.spoof.game.GameConfig;
import uk.co.icecreamhead.spoof.gui.GraphGui;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created with IntelliJ IDEA.
 * User: joshcooke
 * Date: 04/04/15
 * Time: 11:37
 */
public class JsonSpoofServer implements Runnable {
    private final Logger logger = LoggerFactory.getLogger(JsonSpoofServer.class);

    private GameConfig gameConfig;
    private ServerConfig serverConfig;
    
    private boolean startGui = true;

    @Override
    public void run() {
        Game game = new Game(gameConfig);
        ServerSocket serverSocket;
        try {
            serverSocket = new ServerSocket(serverConfig.getPort());
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        logger.info("Successfully launched Spoof server! Listening for players on port "+serverConfig.getPort());

        if (startGui) {
            GraphGui graphGui = new GraphGui(game);
            graphGui.launch();
            //SimpleGui gui = new SimpleGui(new GameControlListener(game));
//            gui.setVisible(true);
        }

        while (!Thread.interrupted()) {
            try {
                Socket sock = serverSocket.accept();

                ClientHandler clientHandler = new ClientHandler(sock, game);
                clientHandler.start();

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    public void setGameConfig(GameConfig gameConfig) {
        this.gameConfig = gameConfig;
    }

    public void setServerConfig(ServerConfig serverConfig) {
        this.serverConfig = serverConfig;
    }
    
    public void setStartGui(boolean startGui) {
        this.startGui = startGui;
    }
}
