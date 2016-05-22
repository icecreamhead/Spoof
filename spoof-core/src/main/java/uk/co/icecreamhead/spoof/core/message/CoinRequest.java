package uk.co.icecreamhead.spoof.core.message;

import uk.co.icecreamhead.spoof.core.handler.MessageHandler;

import java.net.SocketAddress;

/**
 * Created with IntelliJ IDEA.
 * User: joshcooke
 * Date: 03/04/15
 * Time: 22:23
 */
public class CoinRequest implements Message {
    @Override
    public void handle(MessageHandler handler, SocketAddress address) {
        handler.handle(this, address);
    }

    @Override
    public String toString() {
        return "CoinRequest{}";
    }
}
