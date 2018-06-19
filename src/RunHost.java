import java.io.IOException;
import java.io.ObjectOutputStream;

public class RunHost {
    public static void main(String[] args) throws IOException {
        Host host = new Host();
        ObjectOutputStream out = host.getOut();
        out.writeObject("host sending");
        out.flush();
    }
}
