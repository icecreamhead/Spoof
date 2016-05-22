package uk.co.icecreamhead.spoof.server;

import com.cedarsoftware.util.io.JsonIoException;
import com.cedarsoftware.util.io.JsonReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import uk.co.icecreamhead.spoof.core.io.MessageWriter;
import uk.co.icecreamhead.spoof.handler.ServerMessageHandler;
import uk.co.icecreamhead.spoof.core.message.Message;
import uk.co.icecreamhead.spoof.game.Game;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketAddress;

/**
 * Created with IntelliJ IDEA.
 * User: joshcooke
 * Date: 05/04/15
 * Time: 19:35
 */
public class ClientHandler extends Thread {
    private final Logger logger = LoggerFactory.getLogger(ClientHandler.class);
//    private final Socket socket;
    private final SocketAddress clientSocketAddress;
    private final JsonReader reader;
    private final ServerMessageHandler messageHandler;

    public ClientHandler(Socket socket, Game game) {
//        this.socket = socket;
        this.clientSocketAddress = socket.getRemoteSocketAddress();
        try {
            this.messageHandler = new ServerMessageHandler(game, new MessageWriter(socket.getOutputStream()));
            this.reader = new JsonReader(socket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run() {
        while (!Thread.interrupted()) {
            try {
                Message message = (Message)reader.readObject();
                message.handle(messageHandler, clientSocketAddress);
            } catch (JsonIoException ex) {
                logger.info("Client disconnected ({})", clientSocketAddress);
                break;
            }
        }
    }
}
