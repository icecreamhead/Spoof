package uk.co.icecreamhead.spoof.core.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import uk.co.icecreamhead.spoof.core.message.*;

/**
 * Created with IntelliJ IDEA.
 * User: joshcooke
 * Date: 03/04/15
 * Time: 22:57
 */
public abstract class MessageHandlerBase implements MessageHandler {
    private static final Logger logger = LoggerFactory.getLogger(MessageHandlerBase.class);

    public void handle(CoinRequest coinRequest) {
        log(coinRequest);
    }

    public void handle(NumCoins numCoins) {
        log(numCoins);
    }

    public void handle(Registration registration) { log(registration); }

    public void handle(RegistrationFailed registrationFailed) {log(registrationFailed);}

    public void handle(RegistrationAccepted registrationAccepted) {log(registrationAccepted);}

    public void handle(Guess guess) {log(guess);}

    private void log(Message message) {
        logger.error("Received unhandled message: "+message);
    }
}
