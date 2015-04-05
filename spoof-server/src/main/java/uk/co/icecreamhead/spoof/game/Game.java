package uk.co.icecreamhead.spoof.game;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: joshcooke
 * Date: 04/04/15
 * Time: 12:21
 */
public class Game {
    private final Logger logger = LoggerFactory.getLogger(Game.class);
    private final GameConfig config;
    private final Set<String> registeredPlayers = new HashSet<String>();

    public Game(GameConfig config) {
        this.config = config;
    }

    public MessageResult registerPlayer(String player) {
        if (registeredPlayers.contains(player)) {
            return new MessageResult("Player name '"+player+"' is already in use. Please register with a different name.", MessageResult.Status.FAIL);
        } else {
            registeredPlayers.add(player);
            return new MessageResult("Player '"+player+"' registered successfully!", MessageResult.Status.SUCCESS);
        }
    }

    public void start() {
        logger.info("STARTING GAME! :D");
    }

}
