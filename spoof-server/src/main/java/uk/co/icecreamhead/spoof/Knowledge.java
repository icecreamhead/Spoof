package uk.co.icecreamhead.spoof;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: joshcooke
 * Date: 24/04/2013
 * Time: 19:34
 * To change this template use File | Settings | File Templates.
 */
public class Knowledge {

    private HashMap<Guess,Player> guesses;

    public Knowledge() {
        guesses = new HashMap<Guess, Player>();
    }

    public HashMap<Guess,Player> getGuesses() {
        return guesses;
    }

    public void reset() {
        guesses.clear();
    }
}
