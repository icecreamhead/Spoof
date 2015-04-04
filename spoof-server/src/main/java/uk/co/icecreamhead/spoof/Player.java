package uk.co.icecreamhead.spoof;

/**
 * Created with IntelliJ IDEA.
 * User: joshcooke
 * Date: 24/04/2013
 * Time: 19:13
 * To change this template use File | Settings | File Templates.
 */
public abstract class Player {

    protected final String name;

    abstract public Guess announceGuess(Game game, Game.RequestType requestType);
    abstract public CoinsHeld chooseCoinsToHold(Game game, Game.RequestType requestType);

    public Player(String name) {
        this.name = name;
    }

    public final String getName() {
        return name;
    }

    @Override
    public final String toString() {
        return getName();
    }
}
