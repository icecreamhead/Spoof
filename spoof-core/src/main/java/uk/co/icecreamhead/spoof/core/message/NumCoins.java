package uk.co.icecreamhead.spoof.core.message;

/**
 * Created with IntelliJ IDEA.
 * User: joshcooke
 * Date: 03/04/15
 * Time: 23:14
 */
public class NumCoins extends Message {
    private final int num;

    public NumCoins(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }

}
