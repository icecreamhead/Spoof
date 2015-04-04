package uk.co.icecreamhead.spoof.server;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created with IntelliJ IDEA.
 * User: joshcooke
 * Date: 04/04/15
 * Time: 11:34
 */
public class SpoofServerLauncher {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spoof-server-config.xml");

        JsonSpoofServer spoofServer = (JsonSpoofServer) context.getBean("spoofServer");

        Thread serverThread = new Thread(spoofServer, "Spoof Server");
        serverThread.start();
    }
}
