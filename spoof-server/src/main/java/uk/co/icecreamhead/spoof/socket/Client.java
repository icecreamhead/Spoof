package uk.co.icecreamhead.spoof.socket;

import uk.co.icecreamhead.spoof.ClientHandler;

import java.io.*;
import java.net.Socket;

/**
 * Created with IntelliJ IDEA.
 * User: joshcooke
 * Date: 26/03/15
 * Time: 20:24
 */
public class Client extends Thread {
    private final BufferedReader streamReader;
    private final BufferedWriter streamWriter;
    private final Socket socket;
    private final int i;

    private ClientHandler handler = null;

    Client(int i, Socket socket) throws IOException {
        this.i = i;
        this.socket = socket;
        this.streamReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        this.streamWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
    }

    @Override
    public void run() {
        String str;
        System.out.println("Starting new client "+i);
        while (!Thread.interrupted()) {
            try {
                str = streamReader.readLine();
                if (str == null) break;
                if (handler == null) {
                    throw new RuntimeException("No handler registered for client "+i+"!");
                } else {
                    System.out.println(i+"<< "+str);
                    handler.handle(str, new Callback<String>() {
                        @Override
                        public void reply(String message) {
                            try {
                                System.out.println(i+">> "+message);
                                streamWriter.write(message);
                                streamWriter.newLine();
                                streamWriter.flush();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    });
                }
            } catch (Exception e) {
                e.printStackTrace();
                try {
                    socket.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                break;
            }
        }
        System.err.println("Client "+i+" has disconnected");
    }

    public boolean registerHandler(ClientHandler handler) {
        this.handler = handler;
        return true;
    }

    public interface Callback<String> {
        public void reply(String message);
    }
}