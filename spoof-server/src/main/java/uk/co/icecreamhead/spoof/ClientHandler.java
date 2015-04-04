package uk.co.icecreamhead.spoof;

import uk.co.icecreamhead.spoof.socket.Client;

/**
 * Created with IntelliJ IDEA.
 * User: joshcooke
 * Date: 26/03/15
 * Time: 20:19
 */
public interface ClientHandler {
    public void handle(String message, Client.Callback<String> callback);
}
