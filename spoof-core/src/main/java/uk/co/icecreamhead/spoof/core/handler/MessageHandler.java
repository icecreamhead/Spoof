package uk.co.icecreamhead.spoof.core.handler;

import uk.co.icecreamhead.spoof.core.message.*;

import java.net.SocketAddress;

/**
 * Created with IntelliJ IDEA.
 * User: joshcooke
 * Date: 05/04/15
 * Time: 21:12
 */
public interface MessageHandler {
    void handle(CoinRequest coinRequest, SocketAddress client); // add socket address to handler methods

    void handle(NumCoins numCoins, SocketAddress client);

    void handle(Registration registration, SocketAddress client);

    void handle(RegistrationFailed registrationFailed, SocketAddress client);

    void handle(RegistrationAccepted registrationAccepted, SocketAddress client);

    void handle(Guess guess, SocketAddress client);

    void handle(GameSetup gameSetup, SocketAddress client);
}
