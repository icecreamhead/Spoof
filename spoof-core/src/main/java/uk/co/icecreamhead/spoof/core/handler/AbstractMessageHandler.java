package uk.co.icecreamhead.spoof.core.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import uk.co.icecreamhead.spoof.core.message.CoinRequest;
import uk.co.icecreamhead.spoof.core.message.Message;
import uk.co.icecreamhead.spoof.core.message.NumCoins;

/**
 * Created with IntelliJ IDEA.
 * User: joshcooke
 * Date: 03/04/15
 * Time: 22:57
 */
public abstract class AbstractMessageHandler {
    private static final Logger logger = LoggerFactory.getLogger(AbstractMessageHandler.class);

    public void handle(Message message) {
        log(message);
    }

    public void handle(CoinRequest coinRequest) {
        log(coinRequest);
    }

    public void handle(NumCoins numCoins) {
        log(numCoins);
    }

    private final void log(Message message) {
        logger.error("Received unhandled message: "+message);
    }
}
