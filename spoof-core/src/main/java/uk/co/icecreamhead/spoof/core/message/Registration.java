package uk.co.icecreamhead.spoof.core.message;

/**
 * Created with IntelliJ IDEA.
 * User: joshcooke
 * Date: 03/04/15
 * Time: 22:19
 */
public class Registration extends Message {
    private final String name;

    public Registration(String name) {
        this.name = name;
    }
}
