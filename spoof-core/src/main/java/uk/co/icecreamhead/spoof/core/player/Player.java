package uk.co.icecreamhead.spoof.core.player;

import uk.co.icecreamhead.spoof.core.io.MessageWriter;
import uk.co.icecreamhead.spoof.core.message.Message;

import java.net.SocketAddress;

/**
 * Created with IntelliJ IDEA.
 * User: joshcooke
 * Date: 19/04/15
 * Time: 17:12
 */
public class Player {
    private final String name;
    private final SocketAddress address;
    private final MessageWriter writer;

    public Player(String name, SocketAddress address, MessageWriter writer) {
        this.name = name;
        this.address = address;
        this.writer = writer;
    }

    public void send(Message message) {
        writer.write(message);
    }

    public String getName() {
        return name;
    }

    public SocketAddress getAddress() {
        return address;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Player && this.name.equals(((Player) obj).getName()) && this.address.equals(((Player) obj).address);
    }

    @Override
    public int hashCode() {
        return name.hashCode() * address.hashCode();
    }

    @Override
    public String toString() {
        return "Player{" + name + '(' + address + ")}";
    }
}
