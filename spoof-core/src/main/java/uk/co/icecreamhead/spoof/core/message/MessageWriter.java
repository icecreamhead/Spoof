package uk.co.icecreamhead.spoof.core.message;

import com.cedarsoftware.util.io.JsonWriter;

import java.io.OutputStream;

/**
 * Created with IntelliJ IDEA.
 * User: joshcooke
 * Date: 03/04/15
 * Time: 23:25
 */
public class MessageWriter {
    private final OutputStream outputStream;

    public MessageWriter(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    public void write(Message message) {
        JsonWriter writer = new JsonWriter(outputStream);
        writer.write(message);
        writer.flush();
    }
}
