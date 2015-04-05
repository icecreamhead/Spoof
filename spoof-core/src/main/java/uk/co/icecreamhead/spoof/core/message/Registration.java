package uk.co.icecreamhead.spoof.core.message;

import uk.co.icecreamhead.spoof.core.handler.MessageHandler;

/**
 * Created with IntelliJ IDEA.
 * User: joshcooke
 * Date: 03/04/15
 * Time: 22:19
 */
public class Registration implements Message {
    private final String name;

    public Registration(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void handle(MessageHandler handler) {
        handler.handle(this);
    }
}
