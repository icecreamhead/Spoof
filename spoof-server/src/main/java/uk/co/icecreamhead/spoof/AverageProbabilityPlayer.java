package uk.co.icecreamhead.spoof;

/**
 * Created with IntelliJ IDEA.
 * User: joshcooke
 * Date: 24/04/2013
 * Time: 20:51
 * To change this template use File | Settings | File Templates.
 */
public class AverageProbabilityPlayer extends Player {

    @Override
    public Guess announceGuess(Game game, Game.RequestType requestType) {
        int guessVal;
        float closeVal = (((float)game.getAllowedCoins()) / 2) * ((float)game.getCurrentPlayers().size());

        guessVal = Math.round(closeVal);
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
        return new CoinsHeld((int)(Math.floor(Math.random()*(game.getAllowedCoins()+1))));
    }

    public AverageProbabilityPlayer(String name) {
        super(name);
    }
}
