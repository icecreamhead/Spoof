package uk.co.icecreamhead.spoof.core.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import uk.co.icecreamhead.spoof.core.message.CoinRequest;
import uk.co.icecreamhead.spoof.core.io.MessageWriter;
import uk.co.icecreamhead.spoof.core.message.RegistrationAccepted;
import uk.co.icecreamhead.spoof.core.message.RegistrationFailed;
import uk.co.icecreamhead.spoof.core.player.PlayerStrategy;

import java.net.SocketAddress;

/**
 * Created with IntelliJ IDEA.
 * User: joshcooke
 * Date: 03/04/15
 * Time: 21:49
 */
public class ClientMessageHandler extends MessageHandlerBase {
    private final Logger logger = LoggerFactory.getLogger(ClientMessageHandler.class);
    private final PlayerStrategy playerStrategy;
    private final MessageWriter writer;

    public ClientMessageHandler(PlayerStrategy playerStrategy, MessageWriter writer) {
        this.playerStrategy = playerStrategy;
        this.writer = writer;
    }

    @Override
    public void handle(CoinRequest coinRequest, SocketAddress client) {
        writer.write(playerStrategy.chooseNumCoins());
    }

    @Override
    public void handle(RegistrationFailed registrationFailed, SocketAddress client) {
        logger.error("Failed to register! Reason: {}", registrationFailed.getReason());
    }

    @Override
    public void handle(RegistrationAccepted registrationAccepted, SocketAddress client) {
        logger.info("Successfully registered!");
    }
}
