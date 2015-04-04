package uk.co.icecreamhead.spoof.core.message;

import uk.co.icecreamhead.spoof.core.handler.AbstractMessageHandler;

/**
 * Created with IntelliJ IDEA.
 * User: joshcooke
 * Date: 03/04/15
 * Time: 21:26
 */
public abstract class Message {
    public final void handle(AbstractMessageHandler handler) {
        handler.handle(this);
    }
}
