import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author samm0091
 * @version 03-04-2017.
 */
public class ServerMain {

    public static void main(String[] args) {

        try {

            ServerSocket serverSocket = new ServerSocket(1234);
            Socket socket = serverSocket.accept();
            new Thread(new HandleAClient(socket)).start();

        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }

}

class HandleAClient implements Runnable {

    private Socket socket;
    //private static ArrayList<Client> list = new ArrayList<>();

    public HandleAClient(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            BufferedReader fromClient = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
            PrintWriter toClient = new PrintWriter(this.socket.getOutputStream(), true);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}

