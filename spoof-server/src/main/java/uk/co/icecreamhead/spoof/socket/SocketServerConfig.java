package uk.co.icecreamhead.spoof.socket;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created with IntelliJ IDEA.
 * User: joshcooke
 * Date: 04/03/15
 * Time: 22:48
 */
public class SocketServerConfig {
    private final Properties properties = new Properties();
    private final String file = "spoof.properties";
    private final InputStream propertiesStream = getClass().getResourceAsStream(file);

    public int getPort() {
        return port;
    }

    private final int port;

    public SocketServerConfig() throws IOException {
        load();
        port = Integer.parseInt(properties.getProperty("port"));
    }

    public SocketServerConfig(int port) {
        this.port = port;
    }

    private void load() throws IOException {
        if (propertiesStream != null) {
            properties.load(propertiesStream);
        }
        System.out.println("Loaded port: " + properties.getProperty("port"));
    }
}
