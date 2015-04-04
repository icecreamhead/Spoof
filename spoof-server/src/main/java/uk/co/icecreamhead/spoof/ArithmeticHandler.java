package uk.co.icecreamhead.spoof;

import uk.co.icecreamhead.spoof.socket.Client;

import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: joshcooke
 * Date: 26/03/15
 * Time: 20:42
 */
public class ArithmeticHandler implements ClientHandler {
    private final List<Character> operators = Arrays.asList('*', '/', '+', '-');
    @Override
    public void handle(String message, Client.Callback<String> callback) {
        if (message.length()==3 &&
                Character.isDigit(message.charAt(0)) &&
                Character.isDigit(message.charAt(2)) &&
                operators.contains(Character.valueOf(message.charAt(1)))) {
            double x = Integer.parseInt(Character.toString(message.charAt(0)));
            double y = Integer.parseInt(Character.toString(message.charAt(2)));
            switch (message.charAt(1)){
                case '*' : callback.reply(String.valueOf(x*y)); break;
                case '/' : callback.reply(String.valueOf(x/y)); break;
                case '+' : callback.reply(String.valueOf(x+y)); break;
                case '-' : callback.reply(String.valueOf(x-y)); break;

                default:
            }
        } else {
            callback.reply("Unable to parse input");
        }
    }
}
