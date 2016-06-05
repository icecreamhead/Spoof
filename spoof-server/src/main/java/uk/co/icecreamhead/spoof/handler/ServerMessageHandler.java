package uk.co.icecreamhead.spoof.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import uk.co.icecreamhead.spoof.core.handler.MessageHandlerBase;
import uk.co.icecreamhead.spoof.core.io.MessageWriter;
import uk.co.icecreamhead.spoof.game.Game;
import uk.co.icecreamhead.spoof.core.message.*;

import java.net.SocketAddress;

/**
 * Created with IntelliJ IDEA.
 * User: joshcooke
 * Date: 03/04/15
 * Time: 22:55
 */
public class ServerMessageHandler extends MessageHandlerBase {
    private final Logger logger = LoggerFactory.getLogger(ServerMessageHandler.class);
    private final Game game;
    private final MessageWriter writer;

    public ServerMessageHandler(Game game, MessageWriter writer) {
        this.game = game;
        this.writer = writer;
    }

    @Override
    public void handle(Registration registration, SocketAddress client) {
        String playerName = registration.getName();
        logger.info("Received registration request for "+registration.getName()+"@"+client+".");
        game.registerPlayer(playerName, client, writer);
    }
    
    @Override
    public void handle(NumCoins numCoins, SocketAddress client) {
        logger.info(client + " has chosen coins ("+numCoins.getNum()+")");
    }
    
}
