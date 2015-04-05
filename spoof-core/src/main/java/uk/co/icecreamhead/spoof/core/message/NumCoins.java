package uk.co.icecreamhead.spoof.core.message;

import uk.co.icecreamhead.spoof.core.handler.MessageHandler;

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
    public void handle(MessageHandler handler) {
        handler.handle(this);
    }
}
