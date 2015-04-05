package uk.co.icecreamhead.spoof.core.message;

import uk.co.icecreamhead.spoof.core.handler.MessageHandler;

/**
 * Created with IntelliJ IDEA.
 * User: joshcooke
 * Date: 04/04/15
 * Time: 11:31
 */
public class RegistrationAccepted implements Message {

    @Override
    public void handle(MessageHandler handler) {
        handler.handle(this);
    }
}
