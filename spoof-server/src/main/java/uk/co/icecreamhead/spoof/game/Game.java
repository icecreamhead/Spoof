package uk.co.icecreamhead.spoof.game;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import uk.co.icecreamhead.spoof.core.io.MessageWriter;
import uk.co.icecreamhead.spoof.core.message.CoinRequest;
import uk.co.icecreamhead.spoof.core.message.RegistrationAccepted;
import uk.co.icecreamhead.spoof.core.message.RegistrationFailed;
import uk.co.icecreamhead.spoof.core.player.Player;

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
    private final Set<Player> registeredPlayers = new HashSet<Player>();

    public Game(GameConfig config) {
        this.config = config;
    }

    public void registerPlayer(String player, MessageWriter writer) {
        if (registeredPlayers.add(new Player(player, writer))) {
            writer.write(new RegistrationAccepted());
            logger.info("Registration successful.");
        } else {
            writer.write(new RegistrationFailed("Player name '" + player + "' is already in use. Please register with a different name."));
            logger.warn("Registration failed: name already in use.");
        }
    }

    public void start() {
        logger.info("STARTING GAME! :D");
        for (Player player : registeredPlayers) {
            player.send(new CoinRequest());
        }
    }

}
