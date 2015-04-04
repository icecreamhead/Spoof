package uk.co.icecreamhead.spoof;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 * User: joshcooke
 * Date: 24/04/2013
 * Time: 19:08
 * To change this template use File | Settings | File Templates.
 */
public class Game {

    private LinkedList<Player> registeredPlayers;
    private Queue<Player> players;
    private LinkedHashMap<CoinsHeld,Player> coinsHeldList;
    private Knowledge knowledge;
    private int allowedCoins;

    public Game(int numCoins) {
        knowledge = new Knowledge();
        coinsHeldList = new LinkedHashMap<CoinsHeld, Player>();
        allowedCoins = numCoins;
        registeredPlayers = new LinkedList<Player>();
    }

    public Game() {
        this(3);
    }

    public void addPlayer(Player player) {
        registeredPlayers.add(player);
    }

    public LinkedList<Player> getRegisteredPlayers() {
        return registeredPlayers;
    }

    public Queue<Player> getCurrentPlayers() {
        return players;
    }

    public Knowledge getKnowledge() {
        return knowledge;
    }

    public LinkedHashMap<Player,Integer> runGame() {
        LinkedHashMap<Player,Integer> roundScore = new LinkedHashMap<Player,Integer>();
        players = (Queue<Player>)registeredPlayers.clone();
        setStartPlayer();

        // Each round
        while (players.size() > 1) {

            System.out.println("Round of " + players.size());
            // All players choose to hold a number of coins
            for (Player player : players) {
                CoinsHeld coins = player.chooseCoinsToHold(this, RequestType.NORMAL);
                coinsHeldList.put(coins,player);
            }

            // Each player announces guess in turn, which must be different to other guesses (possibly based on knowledge)
            for (Player player : players) {
                Guess guess = player.announceGuess(this, RequestType.NORMAL);
                if (!validGuess(guess)) {
                    // Invalid guess - try again
                    guess = player.announceGuess(this, RequestType.REVISE);
                    if (!validGuess(guess)) {
                        // Another invalid guess - try again, last chance
                        guess = player.announceGuess(this, RequestType.LAST_CHANCE);
                        if (!validGuess(guess)) {
                            //disqualify
                        }
                    }
                }
                System.out.println(player.getName() + " announces " + guess.getValue());
                knowledge.getGuesses().put(guess,player);
            }

            int total = 0;
            for (Map.Entry<CoinsHeld,Player> coins: coinsHeldList.entrySet()) {
                System.out.println(coins.getValue().getName()+" holds "+coins.getKey().getNumCoins()+" coins");
                if (!validCoinsHeld(coins.getKey())) {
                    // Instant disqualification
                }
                total += coins.getKey().getNumCoins();
            }

            System.out.println("Total is "+total);
            Guess winningGuess = new Guess(total);

            if (knowledge.getGuesses().containsKey(winningGuess)) {
                Player winningPlayer = knowledge.getGuesses().get(winningGuess);
                players.remove(winningPlayer);
                roundScore.put(winningPlayer, 1);
                System.out.println("Correct guess! "+winningPlayer.getName()+" guessed correctly and leaves the game.");
            } else {
                players.offer(players.poll());
                System.out.println("No correct guesses. First to announce next is " + players.peek());
            }

            // new round
            knowledge.reset();
            coinsHeldList.clear();
            System.out.println();
        }

        System.out.println("Losing player is "+players.peek()+"!");
        roundScore.put(players.poll(),1-registeredPlayers.size());
        return roundScore;
    }

    private void setStartPlayer() {
        int startIndex  = (int) Math.floor(Math.random()*players.size());
        for (int i=0; i<startIndex; i++) {
            players.offer(players.poll());
        }
        System.out.println("Playing order is as follows:");
        for (Player player : players) {
            System.out.println(player);
        }
        System.out.println();
    }

    public int getAllowedCoins() {
        return allowedCoins;
    }

    public void setAllowedCoins(int allowedCoins) {
        this.allowedCoins = allowedCoins;
    }

    private boolean validGuess(Guess guess) {
        return !knowledge.getGuesses().containsKey(guess) && guess.getValue() <= players.size()*allowedCoins && guess.getValue() >= 0;
    }

    private boolean validCoinsHeld(CoinsHeld coinsHeld) {
        return coinsHeld.getNumCoins() >= 0 && coinsHeld.getNumCoins() <= allowedCoins;
    }

    public enum RequestType {
        NORMAL,
        REVISE,
        LAST_CHANCE
    }
}
