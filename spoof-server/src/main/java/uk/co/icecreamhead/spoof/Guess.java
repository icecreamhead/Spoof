package uk.co.icecreamhead.spoof;

/**
 * Created with IntelliJ IDEA.
 * User: joshcooke
 * Date: 24/04/2013
 * Time: 19:41
 * To change this template use File | Settings | File Templates.
 */
public class Guess {

    private int guess;

    public Guess(int guess) {
        this.guess = guess;
    }

    public int getValue() {
        return guess;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Guess) {
            return ((Guess) o).getValue() == guess;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return guess;
    }

}
