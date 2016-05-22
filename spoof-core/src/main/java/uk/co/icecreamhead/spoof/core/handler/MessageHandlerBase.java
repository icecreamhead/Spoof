package uk.co.icecreamhead.spoof.core.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import uk.co.icecreamhead.spoof.core.message.*;

import java.net.SocketAddress;

/**
 * Created with IntelliJ IDEA.
 * User: joshcooke
 * Date: 03/04/15
 * Time: 22:57
 */
public abstract class MessageHandlerBase implements MessageHandler {
    private static final Logger logger = LoggerFactory.getLogger(MessageHandlerBase.class);

    @Override
    public void handle(CoinRequest coinRequest, SocketAddress client) {
        log(coinRequest);
    }

    @Override
    public void handle(NumCoins numCoins, SocketAddress client) {
        log(numCoins);
    }

    @Override
    public void handle(Registration registration, SocketAddress client) { log(registration); }

    @Override
    public void handle(RegistrationFailed registrationFailed, SocketAddress client) {log(registrationFailed);}

    @Override
    public void handle(RegistrationAccepted registrationAccepted, SocketAddress client) {log(registrationAccepted);}

    @Override
    public void handle(Guess guess, SocketAddress client) {log(guess);}

    @Override
    public void handle(GameSetup gameSetup, SocketAddress client) {
        log(gameSetup);
    }

    private void log(Message message) {
        logger.error("Received unhandled message: {}", message);
    }
}
