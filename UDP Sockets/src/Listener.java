import java.io.*;
import java.net.*;
import java.math.*;

public class Listener {
	public static void main(String args[]) throws IOException
    {
		if (args.length != 2) {
	        System.err.println("Usage: java Listener <port number> <Talker ip>");
	        System.exit(1);
	    }
		int portNumber = Integer.parseInt(args[0]);
		InetAddress ip = InetAddress.getByName(args[1]);
		DatagramSocket ds = new DatagramSocket(portNumber);
		byte[] receive = new byte[65535];
		byte ack[] = new byte[1];
		DatagramPacket DReceive = null;
		int i = 0;
		int numMessages = 7;
		String TotalMessage = "";
		int NumACK = 0;
		int PreviousACK = 99;
		while(true) {
			DReceive = new DatagramPacket(receive, receive.length);
			ds.receive(DReceive);
			receive = DReceive.getData();
			String message = new String(receive);
			InetAddress address = DReceive.getAddress();
			int port = DReceive.getPort();
			if (Math.random() >0.5 ) {
				NumACK = Integer.parseInt(message.substring(0,1)) + 1; 
			}
				if (NumACK >= 2 & NumACK != PreviousACK) {
					TotalMessage = TotalMessage + message.substring(3,13);
					PreviousACK = NumACK;
				}
				ack = String.valueOf(NumACK).getBytes();
				DatagramPacket packet = new DatagramPacket(ack, ack.length, address, port);
				//System.out.println("Received message: " + message);
				if (i == 0) {
					numMessages = Integer.parseInt(message.substring(3,4));
					i = 1;
				}
				//System.out.println("ack: " + NumACK);
				if (NumACK - 1 == numMessages) {
					System.out.println(TotalMessage);
					ds.close();
					return;
				}
		
			ds.send(packet);
		}
		
    }
}
