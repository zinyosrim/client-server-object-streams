import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    private int portNumber = Settings.PORT;
    private ObjectOutputStream out;
    private ObjectInputStream in;
    private Socket clientSocket;

    public Client(String ip) {
        connectToHost(ip);
        CommandListener commandListener = new CommandListener(in);
    }

    public ObjectOutputStream getOut() {
        return out;
    }

    public ObjectInputStream getIn() {
        return in;
    }

    private void connectToHost(String ip) {
        try {
            clientSocket = new Socket(ip, portNumber);
            out = new ObjectOutputStream(clientSocket.getOutputStream());
            in = new ObjectInputStream(clientSocket.getInputStream());

        } catch (UnknownHostException e) {
            System.err.println("Don't know about host " + ip);
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to " + ip);
            e.printStackTrace();
        }
    }
}
