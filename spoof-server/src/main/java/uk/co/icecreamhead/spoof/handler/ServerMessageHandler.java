package uk.co.icecreamhead.spoof.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import uk.co.icecreamhead.spoof.core.handler.MessageHandlerBase;
import uk.co.icecreamhead.spoof.core.io.MessageWriter;
import uk.co.icecreamhead.spoof.core.message.Registration;
import uk.co.icecreamhead.spoof.core.message.RegistrationAccepted;
import uk.co.icecreamhead.spoof.core.message.RegistrationFailed;
import uk.co.icecreamhead.spoof.game.Game;
import uk.co.icecreamhead.spoof.game.MessageResult;

/**
 * Created with IntelliJ IDEA.
 * User: joshcooke
 * Date: 03/04/15
 * Time: 22:55
 */
public class ServerMessageHandler extends MessageHandlerBase {
    private final Logger logger = LoggerFactory.getLogger(ServerMessageHandler.class);
    private final Game game;
    private final MessageWriter writer;

    public ServerMessageHandler(Game game, MessageWriter writer) {
        this.game = game;
        this.writer = writer;
    }

    @Override
    public void handle(Registration registration) {
        String playerName = registration.getName();
        logger.info("Received registration request for '"+registration.getName()+"'.");
        MessageResult result = game.registerPlayer(playerName);
        switch (result.getStatus()) {
            case SUCCESS:
                logger.info("Registration successful");
                writer.write(new RegistrationAccepted());
                break;

            case FAIL:
                logger.info("Registration failed: "+result.getMessage());
                writer.write(new RegistrationFailed(result.getMessage()));
                break;
        }
    }
}
