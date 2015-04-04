package uk.co.icecreamhead.spoof.core.handler;

import uk.co.icecreamhead.spoof.core.message.CoinRequest;
import uk.co.icecreamhead.spoof.core.message.MessageWriter;
import uk.co.icecreamhead.spoof.core.player.Player;

/**
 * Created with IntelliJ IDEA.
 * User: joshcooke
 * Date: 03/04/15
 * Time: 21:49
 */
public class ClientMessageHandler extends AbstractMessageHandler {
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

}
