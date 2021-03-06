package uk.co.icecreamhead.spoof.core.message;

import uk.co.icecreamhead.spoof.core.handler.MessageHandler;

import java.net.SocketAddress;

/**
 * Created with IntelliJ IDEA.
 * User: joshcooke
 * Date: 03/04/15
 * Time: 23:29
 */
public class Guess implements Message {
    private final int guess;

    public Guess(int guess) {
        this.guess = guess;
    }

    public int getGuess() {
        return guess;
    }

    @Override
    public void handle(MessageHandler handler, SocketAddress address) {
        handler.handle(this, address);
    }

    @Override
    public String toString() {
        return "Guess{" +
                "guess=" + guess +
                '}';
    }
}
