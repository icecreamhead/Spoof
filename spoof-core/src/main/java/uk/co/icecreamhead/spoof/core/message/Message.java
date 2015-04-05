package uk.co.icecreamhead.spoof.core.message;

import uk.co.icecreamhead.spoof.core.handler.MessageHandler;

/**
 * Created with IntelliJ IDEA.
 * User: joshcooke
 * Date: 03/04/15
 * Time: 21:26
 */
public interface Message {
    public void handle(MessageHandler handler);
}
