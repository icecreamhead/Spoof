package uk.co.icecreamhead.spoof.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created with IntelliJ IDEA.
 * User: joshcooke
 * Date: 03/04/15
 * Time: 15:52
 */
public class LaunchClient {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spoof-client-config.xml");

        JsonSocketClient socketClient = (JsonSocketClient) context.getBean("socketClient");

        Thread clientThread = new Thread(socketClient, socketClient.getPlayerStrategy().getName());
        clientThread.start();
    }
}
