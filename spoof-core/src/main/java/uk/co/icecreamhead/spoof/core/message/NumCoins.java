package uk.co.icecreamhead.spoof.core.message;

import uk.co.icecreamhead.spoof.core.handler.MessageHandler;

import java.net.SocketAddress;

/**
 * Created with IntelliJ IDEA.
 * User: joshcooke
 * Date: 03/04/15
 * Time: 23:14
 */
public class NumCoins implements Message {
    private final int num;

    public NumCoins(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }

    @Override
    public void handle(MessageHandler handler, SocketAddress address) {
        handler.handle(this, address);
    }

    @Override
    public String toString() {
        return "NumCoins{" +
                "num=" + num +
                '}';
    }
}
