package uk.co.icecreamhead.spoof.core.message;

import uk.co.icecreamhead.spoof.core.handler.MessageHandler;

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
    public void handle(MessageHandler handler) {
        handler.handle(this);
    }
}
