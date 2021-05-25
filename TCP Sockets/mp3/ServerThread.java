package mp3;
import java.net.*;
import java.io.*;

public class ServerThread extends Thread {
	private Socket socket = null;
	private String str;
	private int N;

    public ServerThread(Socket socket, String str, int N) {
        super("ServerThread");
        this.socket = socket;
        this.str = str;
        this.N = N;
    }
    public void run() {

        try (
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(
                new InputStreamReader(
                    socket.getInputStream()));
        ) {
          
            while (N > 0) {
            	if (N != 1) { out.println(str); }
            	else { out.println(str + "\n");}
                N = N - 1;
                Thread.sleep(1000);
            }
            socket.close();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
