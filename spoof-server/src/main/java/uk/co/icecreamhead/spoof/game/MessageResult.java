package uk.co.icecreamhead.spoof.game;

/**
 * Created with IntelliJ IDEA.
 * User: joshcooke
 * Date: 05/04/15
 * Time: 20:41
 */
public class MessageResult {
    private final String message;
    private final Status status;

    public MessageResult(String message, Status status) {
        this.message = message;
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public Status getStatus() {
        return status;
    }

    public static enum Status {
        SUCCESS,
        FAIL
    }
}
