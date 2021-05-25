package mp3;
import java.io.*;
import java.net.*;

public class NaiveClient {

	public static void main(String[] args) throws IOException {
        
        if (args.length != 2) {
            System.err.println(
                "Usage: java NaiveClient <server ip> <server port>");
            System.exit(1);
        }
        String serverip = args[0];
        int portNumber = Integer.parseInt(args[1]);
        try (
                Socket NSocket = new Socket(serverip, portNumber);
                PrintWriter out = new PrintWriter(NSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(
                    new InputStreamReader(NSocket.getInputStream()));
            ) {
                String fromServer;
                while ((fromServer = in.readLine()) != null) {
                    System.out.println(fromServer);
                    if (fromServer.contains("\n")) { break; }
                }
        } catch (UnknownHostException e) {
        	System.err.println("Don't know serverip " + serverip);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to " +
                serverip);
            System.exit(1);
        }
	}
}
