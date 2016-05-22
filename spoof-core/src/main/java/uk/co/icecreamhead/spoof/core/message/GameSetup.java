package uk.co.icecreamhead.spoof.core.message;

import uk.co.icecreamhead.spoof.core.handler.MessageHandler;

import java.net.SocketAddress;

/**
 * Created with IntelliJ IDEA.
 * User: joshcooke
 * Date: 19/04/15
 * Time: 20:41
 */
public class GameSetup implements Message {

    @Override
    public void handle(MessageHandler handler, SocketAddress address) {

    }

    @Override
    public String toString() {
        return "GameSetup{}";
    }
}
