package uk.co.icecreamhead.spoof.client;

import com.cedarsoftware.util.io.JsonReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import uk.co.icecreamhead.spoof.core.handler.ClientMessageHandler;
import uk.co.icecreamhead.spoof.core.handler.MessageHandlerBase;
import uk.co.icecreamhead.spoof.core.message.Message;
import uk.co.icecreamhead.spoof.core.io.MessageWriter;
import uk.co.icecreamhead.spoof.core.message.Registration;
import uk.co.icecreamhead.spoof.core.player.Player;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * Created with IntelliJ IDEA.
 * User: joshcooke
 * Date: 03/04/15
 * Time: 16:00
 */
public class JsonSocketClient implements Runnable {
    private static final Logger logger = LoggerFactory.getLogger(JsonSocketClient.class);
    private Player player;
    private Socket sock;
    private JsonReader reader;
    private MessageWriter messageWriter;


    private String hostname;
    private int port;

    @Override
    public void run() {
        logger.info("Launched client. Attempting connection to "+hostname+":"+port+".");
        MessageHandlerBase handler;
        try {
            sock = new Socket();
            sock.connect(new InetSocketAddress(hostname, port));
            reader = new JsonReader(sock.getInputStream());
            messageWriter = new MessageWriter(sock.getOutputStream());
            handler = new ClientMessageHandler(player, messageWriter);
            logger.info("Connected!");
        } catch (IOException e) {
            logger.error("Failed to launch Spoof player", e);
            return;
        }

        logger.info("Sending registration for player '"+player.getName()+"'.");
        messageWriter.write(new Registration(player.getName()));

        while (!Thread.interrupted()) {
            Message message = (Message) reader.readObject();
            message.handle(handler);
        }
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
