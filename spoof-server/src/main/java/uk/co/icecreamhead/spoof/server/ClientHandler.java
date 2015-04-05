package uk.co.icecreamhead.spoof.server;

import com.cedarsoftware.util.io.JsonReader;
import uk.co.icecreamhead.spoof.core.io.MessageWriter;
import uk.co.icecreamhead.spoof.handler.ServerMessageHandler;
import uk.co.icecreamhead.spoof.core.message.Message;
import uk.co.icecreamhead.spoof.game.Game;

import java.io.IOException;
import java.net.Socket;

/**
 * Created with IntelliJ IDEA.
 * User: joshcooke
 * Date: 05/04/15
 * Time: 19:35
 */
public class ClientHandler extends Thread {
//    private final Socket socket;
    private final JsonReader reader;
    private final ServerMessageHandler messageHandler;

    public ClientHandler(Socket socket, Game game) {
//        this.socket = socket;
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
            Message message = (Message)reader.readObject();
            message.handle(messageHandler);
        }
    }
}
