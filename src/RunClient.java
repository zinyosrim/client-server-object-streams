import java.io.IOException;
import java.io.ObjectOutputStream;

public class RunClient {
    public static void main(String[] args) throws IOException {
        Client client = new Client("localhost");
        ObjectOutputStream out = client.getOut();
        out.writeObject("client sending");
        out.flush();
    }
}