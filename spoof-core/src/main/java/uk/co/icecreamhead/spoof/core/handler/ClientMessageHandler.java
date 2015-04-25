package uk.co.icecreamhead.spoof.core.handler;

import uk.co.icecreamhead.spoof.core.message.CoinRequest;
import uk.co.icecreamhead.spoof.core.io.MessageWriter;
import uk.co.icecreamhead.spoof.core.message.RegistrationAccepted;
import uk.co.icecreamhead.spoof.core.message.RegistrationFailed;
import uk.co.icecreamhead.spoof.core.player.PlayerStrategy;

/**
 * Created with IntelliJ IDEA.
 * User: joshcooke
 * Date: 03/04/15
 * Time: 21:49
 */
public class ClientMessageHandler extends MessageHandlerBase {
    private final PlayerStrategy playerStrategy;
    private final MessageWriter writer;

    public ClientMessageHandler(PlayerStrategy playerStrategy, MessageWriter writer) {
        this.playerStrategy = playerStrategy;
        this.writer = writer;
    }

    @Override
    public void handle(CoinRequest coinRequest) {
        writer.write(playerStrategy.chooseNumCoins());
    }

    @Override
    public void handle(RegistrationFailed registrationFailed) {
        super.handle(registrationFailed);
    }

    @Override
    public void handle(RegistrationAccepted registrationAccepted) {
        super.handle(registrationAccepted);
    }
}
