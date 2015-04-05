package uk.co.icecreamhead.spoof.server;

import com.j256.simplejmx.server.JmxServer;
import com.j256.simplejmx.web.JmxWebServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import uk.co.icecreamhead.spoof.game.Game;
import uk.co.icecreamhead.spoof.game.GameConfig;
import uk.co.icecreamhead.spoof.gui.Gui;

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
    private final JmxServer jmxServer = new JmxServer(8000);
    private final JmxWebServer jmxWebServer = new JmxWebServer(8080);

    private GameConfig gameConfig;
    private ServerConfig serverConfig;

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

        Gui gui = new Gui(game);
        gui.launch();

        /*try {
            jmxServer.start();
            jmxWebServer.start();
            jmxServer.register(game);
        } catch (JMException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }*/

        while (!Thread.interrupted()) {
            try {
                Socket sock = serverSocket.accept();

                ClientHandler clientHandler = new ClientHandler(sock, game);
                clientHandler.start();

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        /*jmxServer.stop();
        try {
            jmxWebServer.stop();
        } catch (Exception e) {
            e.printStackTrace();
        }*/
    }

    public void setGameConfig(GameConfig gameConfig) {
        this.gameConfig = gameConfig;
    }

    public void setServerConfig(ServerConfig serverConfig) {
        this.serverConfig = serverConfig;
    }
}
