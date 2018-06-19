import java.io.IOException;
import java.io.ObjectInputStream;

public class CommandListener implements Runnable{
    private ObjectInputStream in;

    public CommandListener(ObjectInputStream in) {
        this.in = in;
        run();
    }

    public void run() {
        String inboundCmd;
        try {
            System.out.println("listener running, waiting for inbound command");
            inboundCmd = (String) in.readObject();
            System.out.println("listener read inbound command" + inboundCmd);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
