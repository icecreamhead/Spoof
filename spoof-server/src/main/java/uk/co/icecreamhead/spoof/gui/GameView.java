package uk.co.icecreamhead.spoof.gui;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: joshcooke
 * Date: 05/06/2016
 * Time: 15:43
 */
public interface GameView {

    void updatePlayers(List<String> players);
    void announceGuess(String player, int guess);
    void announceLoser(String player, int loss);
    void updateScores(Map<String, Integer> scores);

}
