package uk.co.icecreamhead.spoof.socket;

import uk.co.icecreamhead.spoof.ArithmeticHandler;
import uk.co.icecreamhead.spoof.ClientHandler;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created with IntelliJ IDEA.
 * User: joshcooke
 * Date: 04/03/15
 * Time: 22:48
 */
public class SocketServer implements Runnable {

    private final SocketServerConfig config;
    private final ClientHandler clientHandler = new ArithmeticHandler();
    private int i = 1;

    public SocketServer(SocketServerConfig config) {
        this.config = config;
    }

    @Override
    public void run() {
        final int port = config.getPort();
        ServerSocket server = null;
        try {
            server = new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to start server", e);
        }
        System.out.println("Listening on port "+port);
        while (!Thread.interrupted()) {
            try {
                Socket newSocket = server.accept();
                Client client = new Client(i++, newSocket);
                client.start();
                client.registerHandler(clientHandler);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new Thread(new SocketServer(new SocketServerConfig(12345))).start();
    }

}
