package uk.co.icecreamhead.spoof;

/**
 * Created with IntelliJ IDEA.
 * User: joshcooke
 * Date: 28/04/2013
 * Time: 20:05
 * To change this template use File | Settings | File Templates.
 */
public class ConsistentCoinsHeldPlayer extends Player {

    private int holdingCoins = -1;

    public ConsistentCoinsHeldPlayer(String name) {
        super(name);
    }

    @Override
    public Guess announceGuess(Game game, Game.RequestType requestType) {
        int guessVal;
        float closeVal = (((float)game.getAllowedCoins()) / 2) * (game.getCurrentPlayers().size()-1);

        guessVal = Math.round(closeVal+ holdingCoins);
        Guess guess = new Guess(guessVal);
        int guessDiff = 1;
        boolean add = false;
        while (game.getKnowledge().getGuesses().containsKey(guess)) {
            guessVal = add ? guessVal + guessDiff : guessVal - guessDiff;
            guess = new Guess(guessVal);
            add = !add;
            guessDiff++;
        }
        return guess;
    }

    @Override
    public CoinsHeld chooseCoinsToHold(Game game, Game.RequestType requestType) {
        if (holdingCoins == -1) holdingCoins = (int) Math.floor(Math.random()*(game.getAllowedCoins()+1));
        return new CoinsHeld(holdingCoins);
    }
}
