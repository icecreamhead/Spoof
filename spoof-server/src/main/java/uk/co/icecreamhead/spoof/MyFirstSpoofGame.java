package uk.co.icecreamhead.spoof;


/**
 * Created with IntelliJ IDEA.
 * User: joshcooke
 * Date: 24/04/2013
 * Time: 21:12
 * To change this template use File | Settings | File Templates.
 */
public class MyFirstSpoofGame {

    public static void main(String[] args){
        Game game = new Game();
        ResultWriter resultWriter = new ResultWriter("results.csv");
        for (int i = 0; i<5; i++) {
            game.addPlayer(new AverageProbabilityPlayer(AverageProbabilityPlayer.class.getName()+i));
        }
        for (int i = 5; i<10; i++) {
            game.addPlayer(new ConsistentCoinsHeldPlayer(ConsistentCoinsHeldPlayer.class.getName()+i));
        }
        for(int rounds = 0; rounds < 100; rounds++) {
            resultWriter.addRoundScores(game.runGame());
        }
        resultWriter.write();
    }
}
