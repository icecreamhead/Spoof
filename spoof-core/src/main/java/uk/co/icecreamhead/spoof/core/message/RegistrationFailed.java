package uk.co.icecreamhead.spoof.core.message;

import uk.co.icecreamhead.spoof.core.handler.MessageHandler;

/**
 * Created with IntelliJ IDEA.
 * User: joshcooke
 * Date: 05/04/15
 * Time: 20:30
 */
public class RegistrationFailed implements Message {
    private final String reason;

    public RegistrationFailed(String reason) {
        this.reason = reason;
    }

    public String getReason() {
        return reason;
    }

    @Override
    public void handle(MessageHandler handler) {
        handler.handle(this);
    }
}
