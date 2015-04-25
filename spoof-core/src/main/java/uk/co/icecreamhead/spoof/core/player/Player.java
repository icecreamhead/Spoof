package uk.co.icecreamhead.spoof.core.player;

import uk.co.icecreamhead.spoof.core.io.MessageWriter;
import uk.co.icecreamhead.spoof.core.message.Message;

/**
 * Created with IntelliJ IDEA.
 * User: joshcooke
 * Date: 19/04/15
 * Time: 17:12
 */
public class Player {
    private final String name;
    private final MessageWriter writer;

    public Player(String name, MessageWriter writer) {
        this.name = name;
        this.writer = writer;
    }

    public void send(Message message) {
        writer.write(message);
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Player && this.name.equals(((Player) obj).getName());
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
