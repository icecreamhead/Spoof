package uk.co.icecreamhead.spoof.core.player;

import uk.co.icecreamhead.spoof.core.game.Rules;
import uk.co.icecreamhead.spoof.core.message.Guess;
import uk.co.icecreamhead.spoof.core.message.NumCoins;

/**
 * Implement this interface with your Spoof player's strategy
 */
public interface PlayerStrategy {

    String getName();
    NumCoins chooseNumCoins();
    Guess announceGuess();

    void hearOtherGuess(String player, Guess guess);
    void loser(String losingPlayer);
    void rules(Rules rules);

}
