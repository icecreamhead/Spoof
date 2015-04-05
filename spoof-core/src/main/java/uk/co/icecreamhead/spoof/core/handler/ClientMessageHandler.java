package uk.co.icecreamhead.spoof.core.handler;

import uk.co.icecreamhead.spoof.core.message.CoinRequest;
import uk.co.icecreamhead.spoof.core.io.MessageWriter;
import uk.co.icecreamhead.spoof.core.message.RegistrationAccepted;
import uk.co.icecreamhead.spoof.core.message.RegistrationFailed;
import uk.co.icecreamhead.spoof.core.player.Player;

/**
 * Created with IntelliJ IDEA.
 * User: joshcooke
 * Date: 03/04/15
 * Time: 21:49
 */
public class ClientMessageHandler extends MessageHandlerBase {
    private final Player player;
    private final MessageWriter writer;

    public ClientMessageHandler(Player player, MessageWriter writer) {
        this.player = player;
        this.writer = writer;
    }

    @Override
    public void handle(CoinRequest coinRequest) {
        writer.write(player.chooseNumCoins());
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
