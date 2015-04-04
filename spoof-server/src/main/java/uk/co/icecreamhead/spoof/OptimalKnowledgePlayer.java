package uk.co.icecreamhead.spoof;

/**
 * Created with IntelliJ IDEA.
 * User: joshcooke
 * Date: 05/05/2013
 * Time: 14:46
 * To change this template use File | Settings | File Templates.
 */
public class OptimalKnowledgePlayer extends Player {
    @Override
    public Guess announceGuess(Game game, Game.RequestType requestType) {
        int expectation = (int)((game.getAllowedCoins() / 2.0f) * game.getAllowedCoins());
        for (Guess g : game.getKnowledge().getGuesses().keySet()) {
            float average = g.getValue() / (float)game.getCurrentPlayers().size();
            
        }


        return null;
    }

    @Override
    public CoinsHeld chooseCoinsToHold(Game game, Game.RequestType requestType) {
        return new CoinsHeld(3);
    }

    public OptimalKnowledgePlayer(String name) {
        super(name);
    }
}
