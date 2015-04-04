package uk.co.icecreamhead.spoof.core.player;

import uk.co.icecreamhead.spoof.core.message.Guess;
import uk.co.icecreamhead.spoof.core.message.NumCoins;

/**
 * Implement this interface with your Spoof player's strategy
 */
public interface Player {

    public String getName();
    public NumCoins chooseNumCoins();
    public Guess announceGuess();

    public void hearOtherGuess(String player, Guess guess);
    public void winner(String winningPlayer);

}
